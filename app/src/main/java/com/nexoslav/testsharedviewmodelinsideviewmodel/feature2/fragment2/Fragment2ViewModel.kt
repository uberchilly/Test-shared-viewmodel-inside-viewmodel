package com.nexoslav.testsharedviewmodelinsideviewmodel.feature2.fragment2

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.nexoslav.testsharedviewmodelinsideviewmodel.feature2.SharedNavViewModel
import com.nexoslav.testsharedviewmodelinsideviewmodel.viewModelHelpers.ViewModelAssistedFactory

class Fragment2ViewModelFactory constructor(
    private val sharedNavViewModel: SharedNavViewModel,
) : ViewModelAssistedFactory<Fragment2ViewModel> {
    override fun create(stateHandle: SavedStateHandle): Fragment2ViewModel {
        return Fragment2ViewModel(stateHandle, sharedNavViewModel)
    }
}

class Fragment2ViewModel constructor(
    private val savedStateHandle: SavedStateHandle,
    private val sharedNavViewModel: SharedNavViewModel
) : ViewModel() {

    val someData = Transformations.map(sharedNavViewModel.sharedLiveData) {
        "Fragment 2 view model mapped data -> Original: $it"
    }

    init {
        Log.d("VIEW_MODEL", "Fragment2ViewModel init")
    }

    fun doSomething() {
        Log.d("VIEW_MODEL", "Log something from fragment 2 vm")
//        sharedNavViewModel.doSomething()
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("VIEW_MODEL", "Fragment2ViewModel cleared")
    }
}