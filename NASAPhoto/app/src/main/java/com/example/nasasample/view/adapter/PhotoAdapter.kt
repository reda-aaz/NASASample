package com.example.nasasample.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nasasample.R
import com.example.nasasample.model.data.Photo
import com.squareup.picasso.Picasso

class PhotoAdapter(private val listener: PhotoItemListener): RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    var listPhoto: List<Photo> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.photo_item, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listPhoto.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listPhoto[position], listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.photo_textView)
        private val photoImageView: ImageView = itemView.findViewById(R.id.photo_imageview)
        fun bind(photo: Photo, listener: PhotoItemListener){
            titleTextView.text = photo.earthDate
            Picasso.get().load(photo.url).into(photoImageView)
            itemView.setOnClickListener(
                View.OnClickListener { listener.onClickItem(photo) }

            )

        }
    }

    interface PhotoItemListener{
        fun onClickItem(photo: Photo)
    }
}