import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.initKoin
import remote.MemeApi

private val koin = initKoin(enableNetworkLogs = true).koin

fun main() = application {
    var memes by remember { mutableStateOf(emptyList<String>()) }

    val memeApi = koin.get<MemeApi>()

    LaunchedEffect(true) {
        memes = memeApi.fetchMemes()
    }

    Window(onCloseRequest = ::exitApplication) {
        Column {
            App()

            LazyColumn {
                items(memes){
                    Text(it)
                }
            }
        }
    }
}