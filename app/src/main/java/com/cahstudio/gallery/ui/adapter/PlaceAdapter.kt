package com.cahstudio.gallery.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cahstudio.gallery.R
import com.cahstudio.gallery.datasource.model.Place
import com.cahstudio.gallery.ui.DetailImageActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_place.view.*

class PlaceAdapter(val context: Context, val placeList: List<Place>):
    RecyclerView.Adapter<PlaceAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_place, parent, false))
    }

    override fun getItemCount(): Int = placeList.size

    override fun onBindViewHolder(holder: PlaceAdapter.ViewHolder, position: Int) {
        val place = placeList[position]

        holder.title.text = place.title
        holder.desc.text = place.content
        if (place.type == "image"){
            holder.recyclerview.visibility = View.GONE
            Picasso.get().load(place.image).into(holder.image)

            holder.itemView.setOnClickListener {
                val intent = Intent(context, DetailImageActivity::class.java)
                intent.putExtra("image", place.image)
                intent.putExtra("desc", place.content)
                context.startActivity(intent)
            }
        }else{
            holder.recyclerview.visibility = View.VISIBLE
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            val adapter = ImageAdapter(context, place.media)
            holder.recyclerview.layoutManager = layoutManager
            holder.recyclerview.adapter = adapter
            adapter.notifyDataSetChanged()

            holder.itemView.setOnClickListener {
                val intent = Intent(context, DetailImageActivity::class.java)
                intent.putExtra("image", place.media[0])
                intent.putExtra("desc", place.content)
                context.startActivity(intent)
            }
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image = view.itemplace_image
        val title = view.itemplace_title
        val desc = view.itemplace_desc
        val recyclerview = view.itemplace_recyclerview
    }
}