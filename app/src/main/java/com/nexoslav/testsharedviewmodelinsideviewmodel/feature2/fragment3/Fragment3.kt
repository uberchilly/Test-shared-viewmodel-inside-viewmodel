package com.nexoslav.testsharedviewmodelinsideviewmodel.feature2.fragment3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.navGraphViewModels
import com.nexoslav.testsharedviewmodelinsideviewmodel.R
import com.nexoslav.testsharedviewmodelinsideviewmodel.feature2.SharedNavViewModel
import com.nexoslav.testsharedviewmodelinsideviewmodel.viewModelHelpers.ViewModelFactory

class Fragment3 : Fragment() {
    private val sharedViewModel: SharedNavViewModel by navGraphViewModels(R.id.navigation)

    private lateinit var factory: Fragment3ViewModelFactory
    private val viewModel: Fragment3ViewModel by viewModels {
        ViewModelFactory(factory, this, arguments)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = Fragment3ViewModelFactory(sharedViewModel)
        viewModel.doSomething()
        sharedViewModel.doSomething()
    }
}