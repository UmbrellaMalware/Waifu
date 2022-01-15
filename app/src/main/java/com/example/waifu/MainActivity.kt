package com.example.waifu


import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waifu.Adapter.MyImageAdapter
import com.example.waifu.Common.Common
import com.example.waifu.Interface.RetrofitServices
import com.example.waifu.Model.Image
import com.example.waifu.R

import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyImageAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        recyclerMovieList.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerMovieList.layoutManager = layoutManager
        dialog = SpotsDialog.Builder().setCancelable(true).setContext(this).build()

        getAllImageList()
    }

    private fun getAllImageList() {
        dialog.show()
        mService.getImageList().enqueue(object : Callback<Image> {
            override fun onFailure(call: Call<Image>, t: Throwable) {
                Log.e("sdfgh", t.toString())
            }

            override fun onResponse(call: Call<Image>, response: Response<Image>) {
                Log.e("sdfgh", response.body().toString())
                adapter = MyImageAdapter(baseContext, response.body() as Image)
                adapter.notifyDataSetChanged()
                recyclerMovieList.adapter = adapter

                dialog.dismiss()
            }
        })
    }
}