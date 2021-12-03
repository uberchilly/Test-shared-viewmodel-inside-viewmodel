package com.nexoslav.testsharedviewmodelinsideviewmodel.feature1

import android.util.Log
import androidx.lifecycle.ViewModel

class Fragment1ViewModel : ViewModel() {
    fun doSomething() {
        Log.d("VIEW_MODEL", "Log something from fragment 1 vm")
    }
}

