package com.example.apptest.util

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("titleMovements")
fun concatTitle(view: TextView, emial: String) {
    val title = "Movimeintos de: $emial"
    view.text = title
}