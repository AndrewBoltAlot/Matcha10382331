package com.example.matcha10382331

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)
        setSupportActionBar(findViewById(R.id.toolbar))

        val title = intent.getStringExtra("title")
        val photoUrl = intent.getStringExtra("photo_url")

        product_title.text = title
        Picasso.get().load(photoUrl).into(product_photo)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_keyboard_backspace)
        }

    }
}