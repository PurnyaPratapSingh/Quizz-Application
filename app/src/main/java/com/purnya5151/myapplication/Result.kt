package com.purnya5151.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tv_name : TextView = findViewById(R.id.tv_name)
        val score : TextView = findViewById(R.id.tv_score)
        val congo : TextView = findViewById(R.id.congo)
        val result: TextView = findViewById(R.id.tv_result)
        val trophy : ImageView = findViewById(R.id.iv_trophy)
        val btnFin : Button = findViewById(R.id.btn_finish)

        tv_name . text = intent.getStringExtra(Constants.USER_NAME)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val corretAnswers = intent.getIntExtra(Constants.CORRECT_ANSWER, 0)

        score .text ="Your Score is $corretAnswers out of $totalQuestions"

        btnFin.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))


        }



    }
}