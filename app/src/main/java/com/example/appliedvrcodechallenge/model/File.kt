package com.example.appliedvrcodechallenge.model

import com.google.gson.annotations.SerializedName

/**
 * Represents the data contained in a item row
 */
data class File(
    @SerializedName("file-type") val fileType: String,
    val url: String,
    @SerializedName("destination_path") val destinationPath: String,
    @SerializedName("friendly_name") val friendlyName: String)