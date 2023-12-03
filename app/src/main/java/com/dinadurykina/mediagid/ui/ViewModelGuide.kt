package com.dinadurykina.mediagid.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelGuide : ViewModel() {

    private val _navPageTo = MutableLiveData<String>().apply {
        value = "NONE"
    }
    val navPageTo: LiveData<String> = _navPageTo
    fun navNew(page:String) { _navPageTo.value = page }
}