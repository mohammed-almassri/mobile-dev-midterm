package com.example.midtermapp.ui

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.midtermapp.data.ImageData
import com.example.midtermapp.data.ImageModel
import com.example.midtermapp.data.ImageRepoImpl
import com.example.midtermapp.viewmodel.ImageViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlin.math.log

@Composable
fun Explorer(modifier: Modifier = Modifier) {
    val viewModel: ImageViewModel = viewModel{
        ImageViewModel(ImageRepoImpl(ImageData.data))
    }
    val uiState by viewModel.imageUiState.collectAsState()


    Column(modifier=modifier,horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(uiState.image),
            contentDescription = stringResource(uiState.text),
            modifier = Modifier
                .aspectRatio(1f),
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(uiState.text),
            fontSize = 24.sp,
            fontWeight = FontWeight.Black,
            textAlign = TextAlign.Center,
            color = Color.Black

        )
        Spacer(Modifier.padding(top = 45.dp))
        Button(onClick = {
            //log
            Log.d("button", "button clicked")
            viewModel.next()
        }) {
            Text("Next")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ExplorerPreview(modifier: Modifier = Modifier) {
    Explorer(modifier)
}