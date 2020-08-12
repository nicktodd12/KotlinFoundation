package com.example.navigacodechallenge.model

data class Item(val id: Int,
                val image: Image?,
                val title: String,
                val body: String,
                val media: Boolean)