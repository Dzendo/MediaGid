package com.dinadurykina.mediagid.ui.package4

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel4 : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is p_4 Fragment"
    }
    val text: LiveData<String> = _text
}