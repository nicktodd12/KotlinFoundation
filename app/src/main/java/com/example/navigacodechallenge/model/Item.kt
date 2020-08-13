package com.example.navigacodechallenge.model

/**
 * Represents the data contained in a item row
 */
data class Item(val id: Int,
                val image: Image?,
                val title: String,
                val body: String,
                val media: Boolean)