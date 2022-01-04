package com.myapplication.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import repository.MemesRepositoryInterface

class MemesViewModel(
    private val memesRepository: MemesRepositoryInterface
) : ViewModel() {

    val _memes : MutableLiveData<List<String>> = MutableLiveData(emptyList())
    val memes : LiveData<List<String>> = _memes

    init {
        viewModelScope.launch {
            _memes.postValue(memesRepository.fetchMemes())
            Log.d("TAG", ": ${memes.value}")
        }
    }
}