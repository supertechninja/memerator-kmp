package com.myapplication.di

import com.myapplication.ui.MemesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MemesViewModel(get()) }
}