package com.example.lista1

import kotlin.random.Random
import kotlin.random.nextInt

object Questions {
    val questions: List<Question>
        get() = (0 until 10).map { Question(
            "Question $it",
            Random.nextInt(IntRange(1,2))
        ) }
}