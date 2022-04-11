package com.gb.stopwatch.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gb.stopwatch.R
import com.gb.stopwatch.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val textView = findViewById<TextView>(R.id.text_time)
//        CoroutineScope(
//            Dispatchers.Main
//                    + SupervisorJob()
//        ).launch {
//            stopwatchListOrchestrator.ticker.collect {
//                textView.text = it
//            }
//        }

        viewModel.getLiveData().observe(this, {
            binding.textTime.text = it
        })

        binding.buttonStart.setOnClickListener {
            viewModel.start()
        }

        binding.buttonPause.setOnClickListener {
            viewModel.pause()
        }

        binding.buttonStop.setOnClickListener {
            viewModel.stop()
        }


    }

}












