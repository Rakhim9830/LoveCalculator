package com.example.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp
import com.example.lovecalculator.databinding.FragmentMainBinding
import com.example.lovecalculator.viewModel.LoveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
 private lateinit var binding: FragmentMainBinding
 private val viewModel:LoveViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentMainBinding.inflate(layoutInflater, container,false)
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
        findNavController().navigate(R.id.onBoardingFragment)
    }

    private fun initClicker() {
           with(binding){
               btnCalculate.setOnClickListener {
                  viewModel.getLiveLove(firstname = edFirstName.text.toString(), secondName= edSecontdame.text.toString()).observe(viewLifecycleOwner,
                      Observer {
                          LoveModel -> findNavController().navigate(R.id.resultLoveCalculator)
                      })
               }
           }


    }



}