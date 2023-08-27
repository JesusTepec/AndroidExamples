package com.example.apptest.model

data class Category(
    val color: String,
    val id: String,
    val name: String,
    val parent: Parent,
    val textColor: String
)