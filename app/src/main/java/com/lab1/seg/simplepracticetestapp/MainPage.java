package com.lab1.seg.simplepracticetestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {

    //initializing the number of questions and percentage to pass to a default one
    int numQuestion = 10;
    int percentageCorrect=50;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        //this will check if the default parameters have been changed
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            numQuestion = extras.getInt("numQuestions");
            percentageCorrect = extras.getInt("percentage");
            }
    }


    public void openAdditionPage(View v){


        //We are sending the default number of questions and percentage correct

        Intent i = new Intent(MainPage.this, AdditionQuestions.class);

        //we are passing the variables here

        i.putExtra("numQuestions", numQuestion );
        i.putExtra("percentage", percentageCorrect);
        startActivity(i);
    }



    public void openMultiplicationPage(View v){



        //We are sending the default number of questions and percentage correct

        Intent i = new Intent(MainPage.this, MultiplicationQuestions.class);

        //we are passing the variables here

        i.putExtra("numQuestions", numQuestion );
        i.putExtra("percentage", percentageCorrect);
        startActivity(i);
    }

    public void openSettingPage(View v){


        //We are sending the default number of questions and percentage correct

        Intent i = new Intent(MainPage.this, SettingPage.class);

        //we are passing the variables here

        i.putExtra("numQuestions", numQuestion );
        i.putExtra("percentage", percentageCorrect);
        startActivity(i);
    }


}
