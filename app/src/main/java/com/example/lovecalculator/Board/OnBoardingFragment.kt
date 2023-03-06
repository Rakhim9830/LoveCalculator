package com.example.lovecalculator.Board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.Pref.Pref

import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentOnBoardingBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Boarding: Fragment() {
    private lateinit var adapter: Adapter
    private lateinit var binding: FragmentOnBoardingBinding
    @Inject
    lateinit var pref: Pref



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = Adapter(this::onCLick)
         if (pref.isUserSeen()){
            findNavController().navigate(R.id.mainFragment)
        }
        dots()
    }
    fun onCLick(){
        pref.userSeen()
        findNavController().navigate(R.id.mainFragment)

    }
    fun dots(){
        val dotsIndicator = binding.dotsIndicator
        val viewPager = binding.pager
        viewPager.adapter = adapter
        dotsIndicator.attachTo(viewPager)
        viewPager.adapter = adapter
        binding.pager.adapter = adapter
    }

}