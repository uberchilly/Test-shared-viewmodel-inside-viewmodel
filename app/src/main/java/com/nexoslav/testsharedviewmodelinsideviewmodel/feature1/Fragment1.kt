package com.nexoslav.testsharedviewmodelinsideviewmodel.feature1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.nexoslav.testsharedviewmodelinsideviewmodel.R

class Fragment1 : Fragment() {

    private val viewModel: Fragment1ViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<View>(R.id.textLabel).setOnClickListener {
            findNavController().navigate(R.id.action_fragment1_to_navigation)
        }

        viewModel.doSomething()
    }
}