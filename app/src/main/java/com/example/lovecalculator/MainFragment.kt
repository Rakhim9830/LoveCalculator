package com.example.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentMainBinding
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.remote.LoveService
import com.example.lovecalculator.viewModel.LoveViewModel
import retrofit2.Call
import retrofit2.Response


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
    }

    private fun initClicker() {
           with(binding){
               btnCalculate.setOnClickListener {
                  viewModel.getLiveLove(firstname = edFirstName.text.toString(), secondName= edSecontdame.text.toString()).observe(viewLifecycleOwner,
                      Observer {
                          LoveModel -> Log.e("raha", "initclicker: $LoveModel")
                      })
               }
           }


    }



}