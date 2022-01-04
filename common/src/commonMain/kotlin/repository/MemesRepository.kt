package repository

import com.rickclephas.kmp.nativecoroutines.NativeCoroutineScope
import kotlinx.coroutines.*
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import remote.MemeApi

interface MemesRepositoryInterface {
    suspend fun fetchMemes(): List<String>
}

class MemesRepository : KoinComponent, MemesRepositoryInterface {
    private val memeApi: MemeApi by inject()

    @NativeCoroutineScope
    private val coroutineScope: CoroutineScope = MainScope()

    init {
        coroutineScope.launch {
            fetchMemes()
        }
    }

    override suspend fun fetchMemes() = memeApi.fetchMemes()
}
