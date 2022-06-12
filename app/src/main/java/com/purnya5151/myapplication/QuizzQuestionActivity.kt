package com.purnya5151.myapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

class QuizzQuestionActivity : AppCompatActivity() , View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mUserName:String?=null
    private var mCorrectAns : Int= 0


    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion: TextView? = null
    private var ivimage: ImageView? = null

    private var tvoption1: TextView? = null
    private var tvoption2: TextView? = null
    private var tvoption3: TextView? = null
    private var tvoption4: TextView? = null

    private var btn_Submit: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quizz_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        progressBar = findViewById(R.id.progressbar)
        tvProgress = findViewById(R.id.tv_progress)
        tvQuestion = findViewById(R.id.tv_question)
        ivimage = findViewById(R.id.iv_image)

        tvoption1 = findViewById(R.id.tv_option1)
        tvoption2 = findViewById(R.id.tv_option2)
        tvoption3 = findViewById(R.id.tv_option3)
        tvoption4 = findViewById(R.id.tv_option4)

        btn_Submit = findViewById(R.id.SUBMIT)

        tvoption1?.setOnClickListener(this)
        tvoption2?.setOnClickListener(this)
        tvoption3?.setOnClickListener(this)
        tvoption4?.setOnClickListener(this)
        btn_Submit?.setOnClickListener(this)


        mQuestionList = Constants.getQuestion()

        setQuestion()


    }

    private fun setQuestion() {
        // val questionList = Constants.getQuestion()
        defaultOptionsView()
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        ivimage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.questions
        tvoption1?.text = question.optionOne
        tvoption2?.text = question.optionTwo
        tvoption3?.text = question.optionThree
        tvoption4?.text = question.optionFour


        if (mCurrentPosition == mQuestionList!!.size) {
            btn_Submit?.text = "FINISH"
        } else {
            btn_Submit?.text = "SUBMIT"
        }

    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()
        tvoption1?.let {
            options.add(0, it)

        }
        tvoption2?.let {
            options.add(1, it)

        }
        tvoption3?.let {
            options.add(2, it)

        }

        tvoption4?.let {
            options.add(3, it)

        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_background_bg

            )
        }

    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg

        )

    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tv_option1 -> {

                tvoption1?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.tv_option2 -> {

                tvoption2?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.tv_option3 -> {

                tvoption3?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.tv_option4 -> {

                tvoption4?.let {
                    selectedOptionView(it, 4)
                }
            }
            R.id.SUBMIT ->{
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            setQuestion()
                        }

                        else ->{
                            Snackbar.make(this,view,"Congrats! You made it to the End", Snackbar.LENGTH_LONG).show()
                            val intent = Intent(this, Result::class.java)
                            intent.putExtra(Constants.USER_NAME , mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER , mCorrectAns)
                            intent.putExtra(Constants.TOTAL_QUESTIONS , mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }

                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.correctAns != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_background_bg)
                    }else{
                        mCorrectAns++
                    }
                    answerView(question.correctAns, R.drawable.correct_option_background_bg)


                    if (mCurrentPosition == mQuestionList!!.size) {
                        btn_Submit?.text = "FINISH"
                    } else {
                        btn_Submit?.text = "GO TO NEXT QUESTION"
                    }

                    mSelectedOptionPosition = 0

                }

            }

        }
    }

    private fun answerView(answer :Int, drawableView: Int){
        when(answer){
            1 -> {
                tvoption1?.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                tvoption2?.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                tvoption3?.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                tvoption4?.background = ContextCompat.getDrawable(this, drawableView)
            }

        }
    }
}