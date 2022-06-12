package com.purnya5151.myapplication

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS:String = "total_questions"
    const val CORRECT_ANSWER:String = "correct_answer"



    fun getQuestion(): ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(
            1,"Which Country does this flag belong?", R.drawable.img_1,
            "Argentina","Australia","Armenia", "Austria",1

        )
        questionList.add(que1)
        //2 Australia
        val que2 = Question(
            2,"Which Country does this flag belong?", R.drawable.img_2,
            "Russia","Australia","Oman", "New zealand",2

        )
        questionList.add(que2)

        //3 Belgium
        val que3 = Question(
            3,"Which Country does this flag belong?", R.drawable.img_3,
            "Romania","Zimbabwe","Kenya", "Belgium ",4

        )
        questionList.add(que3)

        //4 Brazil
        val que4 = Question(
            4,"Which Country does this flag belong?", R.drawable.img_4,
                "Afghanistan","Brazil","Algeria", "Andorra",2

        )
        questionList.add(que4)

        //5 Denmark
        val que5 = Question(
            5,"Which Country does this flag belong?", R.drawable.img_5,
                "Botswana","Bhutan","Denmark", "Burundi",3

        )
        questionList.add(que5)

        // 6 Fiji
        val que6 = Question(
            6,"Which Country does this flag belong?", R.drawable.img_6,
                "Kazakhstan","Jordan","Libya", "Fiji",4

        )
        questionList.add(que6)

        //7 Germany
        val que7 = Question(
            7,"Which Country does this flag belong?", R.drawable.img_7,
                "Nauru","Germany","Poland", "Qatar",2

        )
        questionList.add(que7)
        //8 Jordan
        val que8 = Question(
            8,"Which Country does this flag belong?", R.drawable.img_8,
            "South Africa","Samoa","Jordan", "Somalia",3

        )
        questionList.add(que8)

        //9
        val que9 = Question(
            9,"Which Country does this flag belong?", R.drawable.img_9,
            "India","Tunisia","Uganda", "Vietnam",1

        )
        questionList.add(que9)

        //7 Germany
        val que10 = Question(
            10,"Which Country does this flag belong?", R.drawable.img_10,
            "Nauru","Uruguay","New Zealand", "Tuvalu",3

        )
        questionList.add(que10)

        return questionList
    }

}