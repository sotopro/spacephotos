package com.danielsoto.spacephotos.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielsoto.spacephotos.network.Api
import com.danielsoto.spacephotos.network.Photo
import kotlinx.coroutines.launch
import java.lang.Exception


enum class  ApiStatus { LOADING, ERROR, DONE}

class OverviewViewModel : ViewModel() {
    private val _status = MutableLiveData<ApiStatus>()
    val  status: LiveData<ApiStatus> =  _status

    private val _photos = MutableLiveData<List<Photo>>()

    val photos: LiveData<List<Photo>> = _photos

    init {
        getPhotos()
    }

    private fun getPhotos(){
        viewModelScope.launch {
            _status.value = ApiStatus.LOADING
            try {
                _photos.value = Api.retrofitService.getPhotos()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                _photos.value = listOf()
            }
        }
    }
}