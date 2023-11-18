package com.dinadurykina.mediagid.ui.zona1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Zona1ViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is zona1 Fragment"
    }
    val text: LiveData<String> = _text
}