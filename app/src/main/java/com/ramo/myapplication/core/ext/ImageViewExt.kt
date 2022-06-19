package com.ramo.myapplication.core.ext

import android.annotation.SuppressLint
import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@SuppressLint("CheckResult")
fun ImageView.loadImage(
    url: String,
    @DrawableRes placeHolder: Int? = null,
    @DrawableRes error: Int? = null
) {
    val options = RequestOptions()
    if (placeHolder != null)
        options.placeholder(placeHolder)
    if (error != null)
        options.error(error)

    Glide
        .with(this)
        .load(url)
        .apply(options)
        .into(this)
}