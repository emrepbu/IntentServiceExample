package com.example.intentserviceexample

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    init {
        Log.d(TAG, "Service is init.")
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.getStringExtra(EXTRA_DATA_STRING_NAME)?.let { dataString ->
            Log.d(TAG, dataString)
        }
        return START_STICKY // super.onStartCommand(intent, flags, startId)
    }

    companion object {
        const val TAG = "MyService"
        const val EXTRA_DATA_STRING_NAME = "ExtraDataStringName"
    }
}

//        binding.btStart.setOnClickListener {
//            Intent(this, MyService::class.java).also {
//                startService(it)
//                binding.tvState.text = "Service is running"
//            }
//        }
//
//        binding.btStop.setOnClickListener {
//            Intent(this, MyService::class.java).also {
//                stopService(it)
//                binding.tvState.text = "Service is stopped"
//            }
//        }
//
//        binding.btSendData.setOnClickListener {
//            Intent(this, MyService::class.java).also { intent ->
//                binding.etData.text?.let { text ->
//                    intent.putExtra(MyService.EXTRA_DATA_STRING_NAME, text.toString())
//                }
//                startService(intent)
//            }
//        }