package repository

import org.koin.dsl.module
import io.ktor.client.engine.android.*


actual fun platformModule() = module {
    single { Android.create() }
}
