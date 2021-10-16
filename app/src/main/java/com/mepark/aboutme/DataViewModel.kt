package com.mepark.aboutme

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel() : ViewModel() {

    var person = MutableLiveData<Person>(Person())

    init{
        person.value?.name = "Moon Family"
    }
    //var person = ObservableField<Person>(p)
}