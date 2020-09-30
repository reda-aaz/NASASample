package com.example.nasasample.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.nasasample.R
import com.example.nasasample.model.data.Photo
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    lateinit var titleTextView: TextView
    lateinit var photoImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        titleTextView = findViewById(R.id.detail_textView)
        photoImageView = findViewById(R.id.detail_imageView)
        val photo = intent.getParcelableExtra<Photo>("key")
        photo?.let {
            titleTextView.text = it.earthDate
            Picasso.get().load(photo.url).into(photoImageView)
        }
    }
}