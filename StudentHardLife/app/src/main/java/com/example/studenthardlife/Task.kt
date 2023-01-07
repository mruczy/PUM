package com.example.studenthardlife

data class Task(val subject: String, val task: String) {
    var id: Int = 0

    constructor(id: Int, subject: String, task: String) : this(subject, task) {
        this.id = id
    }
}