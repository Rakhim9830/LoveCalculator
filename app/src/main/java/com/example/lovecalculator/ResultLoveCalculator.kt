package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentResultLoveCalculatorBinding
import com.example.lovecalculator.remote.LoveModel

class ResultLoveCalculator : Fragment() {
    private lateinit var binding: FragmentResultLoveCalculatorBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,

        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultLoveCalculatorBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            with(binding){
                val resultLove = arguments?.getSerializable("result") as LoveModel
                youResult.text = resultLove.firstName
                meResult.text = resultLove.secondName
                precentage.text = resultLove.percentage + "%"
                score.text = resultLove.result
                btnTryAgain.setOnClickListener {
                    findNavController().navigateUp()
                }

            }



        }
    }

