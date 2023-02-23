package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentMainBinding
import com.example.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Response


class MainFragment : Fragment() {
 private lateinit var binding: FragmentMainBinding
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
                   LoveService().api.calculatePercentage(firstname = edFirstName.text.toString(), secondName = edSecontdame.text.toString()).enqueue(object: retrofit2.Callback<LoveModel>{
                       override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                           if (response.isSuccessful) {
                               findNavController().navigate(
                                   R.id.resultLoveCalculator,
                                   bundleOf("result" to response.body()))
                           }
                       }
                       override fun onFailure(call: Call<LoveModel>, t: Throwable) {

                       }

                   })
               }
           }


    }



}