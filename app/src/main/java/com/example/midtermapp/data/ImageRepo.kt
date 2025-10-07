package com.example.midtermapp.data

interface ImageRepo {
    fun getImageData(): List<ImageModel>
    fun getNextImage(current: Int): ImageModel
}

