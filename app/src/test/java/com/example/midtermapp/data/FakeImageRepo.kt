package com.example.midtermapp.data

class FakeImageRepo(imageData: List<ImageModel> = ImageData.data
    ): ImageRepo by ImageRepoImpl(imageData)