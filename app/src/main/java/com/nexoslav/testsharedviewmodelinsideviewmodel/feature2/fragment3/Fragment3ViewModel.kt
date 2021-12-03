package com.nexoslav.testsharedviewmodelinsideviewmodel.feature2.fragment3

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.nexoslav.testsharedviewmodelinsideviewmodel.feature2.SharedNavViewModel
import com.nexoslav.testsharedviewmodelinsideviewmodel.viewModelHelpers.ViewModelAssistedFactory

class Fragment3ViewModelFactory constructor(
    private val sharedNavViewModel: SharedNavViewModel,
) : ViewModelAssistedFactory<Fragment3ViewModel> {
    override fun create(stateHandle: SavedStateHandle): Fragment3ViewModel {
        return Fragment3ViewModel(stateHandle, sharedNavViewModel)
    }
}

class Fragment3ViewModel constructor(
    savedStateHandle: SavedStateHandle,
    private val sharedViewModel: SharedNavViewModel
) :
    ViewModel() {
    init {
        Log.d("VIEW_MODEL", "Fragment3ViewModel init")
    }

    fun doSomething() {
        Log.d("VIEW_MODEL", "Log something from fragment 3 vm")
        sharedViewModel.doSomething()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("VIEW_MODEL", "Fragment3ViewModel cleared")
    }
}