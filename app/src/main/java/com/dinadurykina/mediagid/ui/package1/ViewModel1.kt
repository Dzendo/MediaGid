package com.dinadurykina.mediagid.ui.package1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel1 : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is p_1 Fragment"
    }
    val text: LiveData<String> = _text
}