package com.example.lovecalculator

import android.content.ContentValues.TAG
import android.net.DnsResolver
import android.net.DnsResolver.Callback
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
    }


