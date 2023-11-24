package com.dinadurykina.mediagid.ui.package3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel3 : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is p_3 Fragment"
    }
    val text: LiveData<String> = _text
}