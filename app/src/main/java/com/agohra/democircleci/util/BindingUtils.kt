package com.agohra.democircleci.util

import android.media.Image
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("image")
fun loadImage(view: ImageView, urlString: String) {
    Glide.with(view)
            .load(urlString)
            .into(view)
}