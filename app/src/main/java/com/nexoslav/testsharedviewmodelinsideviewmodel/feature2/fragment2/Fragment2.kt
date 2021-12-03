package com.nexoslav.testsharedviewmodelinsideviewmodel.feature2.fragment2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.nexoslav.testsharedviewmodelinsideviewmodel.R
import com.nexoslav.testsharedviewmodelinsideviewmodel.feature2.SharedNavViewModel
import com.nexoslav.testsharedviewmodelinsideviewmodel.viewModelHelpers.ViewModelFactory

class Fragment2 : Fragment() {
    private val sharedViewModel: SharedNavViewModel by navGraphViewModels(R.id.navigation)

    private lateinit var factory: Fragment2ViewModelFactory

    private val viewModel: Fragment2ViewModel by viewModels {
        ViewModelFactory(factory, this, arguments)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        factory = Fragment2ViewModelFactory(sharedViewModel)
        view.findViewById<View>(R.id.textLabel).setOnClickListener {
            findNavController().navigate(R.id.action_fragment2_to_fragment3)
        }

        viewModel.someData.observe(viewLifecycleOwner) { data ->
            Log.d("Fragment2", data)
        }
    }
}