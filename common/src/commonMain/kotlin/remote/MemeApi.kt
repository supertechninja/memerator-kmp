package remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import org.koin.core.component.KoinComponent

class MemeApi(
    private val client: HttpClient,
    var baseUrl: String = "https://ronreiter-meme-generator.p.rapidapi.com/",
) : KoinComponent {
    suspend fun fetchMemes() = client.get("$baseUrl/images"){
            this.headers.append("x-rapidapi-key", "3824e2db05msh1063a546c9e7640p1a0547jsn45c69032191c")
            this.headers.append("x-rapidapi-host", "ronreiter-meme-generator.p.rapidapi.com")
        }.body<List<String>>()
}