package com.example.midtermapp.data

class ImageRepoImpl(imageData: List<ImageModel>): ImageRepo {
    val list = imageData
    override fun getImageData(): List<ImageModel> {
        return list
    }

    override fun getNextImage(current: Int): ImageModel {
        return list[if (current == list.size - 1) 0 else current + 1]
    }
}