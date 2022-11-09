package com.example.lista1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.Timer
import kotlin.concurrent.schedule

class Activity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val question = intent.getStringExtra("question")
        val answer = intent.getStringExtra("answer")
        var helper =""
        val textView2: TextView by lazy { findViewById(R.id.textView2) }

        helper = if(answer == "1") {
            "TAK"
        } else {
            "NIE"
        }

        textView2.text = "$question\nOdpowiedz: $helper"

        Timer("SettingUp", false).schedule(5000) {
            finish()
        }
    }
}