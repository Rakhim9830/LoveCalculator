package com.example.lovecalculator.viewModel

import android.content.Context
import android.content.SharedPreferences
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.Pref.Pref
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.repository.Repository
import dagger.Provides
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@HiltViewModel
class LoveViewModel @Inject constructor(val repository: Repository)     : ViewModel() {
    fun getLiveLove(firstname: String, secondName:String): LiveData<LoveModel>{
           return  repository.getLove(firstname, secondName)
    }


}