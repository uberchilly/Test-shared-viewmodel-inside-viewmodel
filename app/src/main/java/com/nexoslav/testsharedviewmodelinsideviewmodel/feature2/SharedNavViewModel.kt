package com.nexoslav.testsharedviewmodelinsideviewmodel.feature2

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedNavViewModel @Inject constructor(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    private val _sharedLiveData = MutableLiveData("")
    val sharedLiveData: LiveData<String>
        get() = _sharedLiveData

    init {
        Log.d("VIEW_MODEL", "SharedNavViewModel init")
        viewModelScope.launch {
            while (true) {
                _sharedLiveData.value = (1..5)
                    .map { kotlin.random.Random.nextInt(0, charPool.size) }
                    .map(charPool::get)
                    .joinToString("")

                delay(2_000)
            }
        }
    }

    fun doSomething() {
        Log.d("VIEW_MODEL", "Log something from shared nav vm")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("VIEW_MODEL", "SharedNavViewModel cleared")
    }
}