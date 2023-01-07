package com.example.studenthardlife

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.studenthardlife.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val dbHandler by lazy { DBHandler(this,) }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}