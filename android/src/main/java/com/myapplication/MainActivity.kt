package com.myapplication

import App
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import com.myapplication.ui.MemesViewModel
import org.koin.androidx.compose.getViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Scaffold(
                    topBar = {
                        TopAppBar(title = { Text("Memes") })
                    }
                ) {
                    MemesContent(it)
                }
            }
        }
    }
}

@Composable
fun MemesContent(
    paddingValues: PaddingValues = PaddingValues(),
    memesViewModel: MemesViewModel = getViewModel()
) {
    val memes by memesViewModel.memes.observeAsState()

    Column {
        App()

        memes?.let { memeList ->
            LazyColumn {
                items(memeList){
                    Text(it)
                }
            }
        }
    }

}