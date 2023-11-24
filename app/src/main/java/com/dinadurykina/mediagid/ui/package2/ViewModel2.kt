package com.dinadurykina.mediagid.ui.package2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel2 : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is p_2 Fragment"
    }
    val text: LiveData<String> = _text
}