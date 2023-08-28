package com.ramo.example.customview.core

import android.content.res.Resources

/**
 * Created by ramazanogunc
 * Created at 20.08.2023
 */

fun Int.toDp(): Int = (this / Resources.getSystem().displayMetrics.density).toInt()
fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()