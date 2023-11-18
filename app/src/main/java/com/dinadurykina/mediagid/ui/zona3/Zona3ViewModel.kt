package com.dinadurykina.mediagid.ui.zona3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Zona3ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is zona3 Fragment"
    }
    val text: LiveData<String> = _text
}