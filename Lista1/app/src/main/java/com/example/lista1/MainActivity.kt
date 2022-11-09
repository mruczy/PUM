package com.example.lista1

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var currentPosition = 1
    private var points = 0
    private var correctNumber = 0
    private var cheatNumber = 0
    private val questions: List<Question> = Questions.questions

    val tak: Button by lazy { findViewById(R.id.buttonTAK) }
    val nie: Button by lazy { findViewById(R.id.buttonNIE) }
    val oszukuj: Button by lazy { findViewById(R.id.buttonOSZUKUJ) }
    val questionText: TextView by lazy { findViewById(R.id.textPytanie) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setQuestion()

        tak.setOnClickListener {setAnswer(1)}
        nie.setOnClickListener {setAnswer(2)}
        oszukuj.setOnClickListener { cheatAnswer() }
    }

    private fun setQuestion(){
        println(currentPosition)
        val question = questions[currentPosition - 1]
        questionText.text = question.question
    }

    private fun setAnswer(answer: Int)
    {
        if (currentPosition <= questions.size - 1)
        {
            val question = questions[currentPosition - 1]
            if(answer == question.correctAnswer)
            {
                points += 10
                correctNumber++
            }

            if (currentPosition <= questions.size - 1)
            {
                currentPosition++
                setQuestion()
            }
        }
        else
        {
            questionText.text = "Punktów = $points " +
                    "\n Poprawne odpowiedzi = $correctNumber " +
                    "\n Oszustwa = $cheatNumber"
        }
    }

    private fun cheatAnswer()
    {
        points -= 15
        cheatNumber++

        val question = questions[currentPosition - 1]
        questionText.text = question.question

        val intent = Intent(this, Activity2::class.java)
        intent.putExtra("question",question.question)
        intent.putExtra("answer",question.correctAnswer.toString())
        var b = Bundle()
        b.putBoolean("isActive", true)
        intent.putExtras(b)
        startActivity(intent)

        currentPosition++
        setQuestion()
    }
}