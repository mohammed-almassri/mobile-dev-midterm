package com.example.midtermapp.viewmodel

import com.example.midtermapp.data.FakeImageRepo
import org.junit.Before
import org.junit.Test
import com.example.midtermapp.R


class ImageViewModelTest {
    private lateinit var viewModel: ImageViewModel
    @Before
    fun setup(){
        viewModel = ImageViewModel(FakeImageRepo())
    }


    @Test
    fun testInit(){
        val uiSate = viewModel.imageUiState.value
        assert(uiSate.index==0)
        assert(uiSate.image==R.drawable.img1)
        assert(uiSate.text==R.string.img1)
    }

    @Test
    fun testNextState(){
        viewModel.next()
        val uiSate = viewModel.imageUiState.value
        assert(uiSate.index==1)
        assert(uiSate.image==R.drawable.img2)
        assert(uiSate.text==R.string.img2)
    }

    @Test
    fun testWrapAround(){
        repeat(times = 4){
            viewModel.next()
        }
        val uiSate = viewModel.imageUiState.value
        assert(uiSate.index==0)
        assert(uiSate.image==R.drawable.img1)
        assert(uiSate.text==R.string.img1)
    }

}