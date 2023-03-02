package com.example.lovecalculator.viewModel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.repository.Repository

class LoveViewModel: ViewModel() {
    private val repository = Repository()
    fun getLiveLove(firstname: String, secondName:String): LiveData<LoveModel>{
           return  repository.getLove(firstname, secondName)
    }
}