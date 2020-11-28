package com.cahstudio.gallery.ui.adapter

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cahstudio.gallery.R
import com.cahstudio.gallery.ui.DetailImageActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_image.view.*

class ImageAdapter(val context: Context, val imageList: List<String>):
    RecyclerView.Adapter<ImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image, parent, false))
    }

    override fun getItemCount(): Int = imageList.size

    override fun onBindViewHolder(holder: ImageAdapter.ViewHolder, position: Int) {

        Picasso.get().load(imageList[position]).placeholder(R.drawable.not_available).into(holder.image)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image = view.itemimage_image
    }
}