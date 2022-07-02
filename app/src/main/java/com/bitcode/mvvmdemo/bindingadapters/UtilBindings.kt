package com.bitcode.mvvmdemo.bindingadapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bitcode.mvvmdemo.R
import com.squareup.picasso.Picasso

@BindingAdapter("url")
fun loadUrlToImageView(imageView: ImageView, url: String) {

    Picasso.get().load(url)
        .placeholder(R.mipmap.ic_launcher)
        .into(imageView)

}