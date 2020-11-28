package com.cahstudio.gallery.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cahstudio.gallery.R
import com.cahstudio.gallery.datasource.model.Gallery
import com.cahstudio.gallery.ui.DetailImageActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_image_grid.view.*

class ImageGridAdapter(val context: Context, val galleryList: List<Gallery>):
    RecyclerView.Adapter<ImageGridAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageGridAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_grid, parent, false))
    }

    override fun getItemCount(): Int = galleryList.size

    override fun onBindViewHolder(holder: ImageGridAdapter.ViewHolder, position: Int) {
        val gallery = galleryList[position]

        Picasso.get().load(galleryList[position].image).placeholder(R.drawable.not_available).into(holder.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailImageActivity::class.java)
            intent.putExtra("image", gallery.image)
            intent.putExtra("desc", gallery.caption)
            context.startActivity(intent)
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image = view.itemimagegrid_image
    }
}