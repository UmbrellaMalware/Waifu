package com.example.waifu.Adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.waifu.Model.Image
import com.example.waifu.Model.Picture
import com.example.waifu.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_layout.view.*

class MyImageAdapter(private val context: Context,private val movieList: Image):RecyclerView.Adapter<MyImageAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.image_movie

        fun bind(listItem: Picture) {
            image.setOnClickListener {
                Toast.makeText(it.context, "нажал на ${itemView.image_movie}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount() = movieList.images.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val listItem = movieList.images[position]
        holder.bind(listItem)

        Picasso.get().load(movieList.images[position].url).into(holder.image)
    }

}
