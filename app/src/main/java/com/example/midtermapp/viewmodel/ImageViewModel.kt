package com.example.midtermapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.midtermapp.data.ImageRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ImageViewModel(private val imageRepo: ImageRepo) : ViewModel() {
    private val _imageData = imageRepo.getImageData()
    private val _imageUiState =
        MutableStateFlow(ImageUiState(_imageData[0].image, _imageData[0].text, 0))
    val imageUiState = _imageUiState.asStateFlow()

    fun next() {
        val nextImageModel = imageRepo.getNextImage(_imageUiState.value.index)
        _imageUiState.update {
            it.copy(
                image = nextImageModel.image,
                text = nextImageModel.text,
                index = if (_imageUiState.value.index == _imageData.size - 1) 0 else _imageUiState.value.index+1
            )
        }
    }
}