package com.example.intentserviceexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentserviceexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btStart.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                binding.tvState.text = "Service is running"
            }
        }

        binding.btStop.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                binding.tvState.text = "Service is stopped"
            }
        }

        binding.btSendData.setOnClickListener {
            Intent(this, MyService::class.java).also { intent ->
                binding.etData.text?.let { text ->
                    intent.putExtra(MyService.EXTRA_DATA_STRING_NAME, text.toString())
                }
                startService(intent)
            }
        }
    }
}