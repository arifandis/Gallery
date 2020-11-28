package com.cahstudio.gallery.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.cahstudio.gallery.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_image.*
import kotlinx.android.synthetic.main.toolbar.*

class DetailImageActivity : AppCompatActivity() {
    private lateinit var actionBar: ActionBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_image)

        configureToolbar()

        val image = intent.getStringExtra("image")
        val desc = intent.getStringExtra("desc")

        Picasso.get().load(image).placeholder(R.drawable.not_available).into(detail_image)
        detail_desc.text = desc
    }

    private fun configureToolbar(){
        if (toolbar_toolbar != null) setSupportActionBar(toolbar_toolbar)
        if (supportActionBar != null) {
            actionBar = supportActionBar!!
            actionBar.setDisplayShowTitleEnabled(false)
            toolbar_tvTitle.textSize = 18f
            toolbar_tvTitle.text = "Detail"
        }
    }
}