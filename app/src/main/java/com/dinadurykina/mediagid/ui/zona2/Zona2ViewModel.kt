package com.dinadurykina.mediagid.ui.zona2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Zona2ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is zona2 Fragment"
    }
    val text: LiveData<String> = _text
}