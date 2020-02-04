package com.lab1.seg.simplepracticetestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //initializing the number of questions and percentage to pass to a default one
    int numQuestion = 10;
    int percentageCorrect=50;
    private TextView numOfQuestions;
    private TextView percOfPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);







        //this will check if the default parameters have been changed
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            numQuestion = extras.getInt("numQuestions");
            percentageCorrect = extras.getInt("percentage");
        }

        //we are finding the textviews to show the user the number of questions that will be asked and the percentage to pass
        numOfQuestions = (TextView) findViewById(R.id.textView2);
        percOfPass = (TextView) findViewById(R.id.textView7);


        //we are setting it to the default value
        numOfQuestions.setText("");
        numOfQuestions.setText("Number of questions: "+numQuestion);

        //we are setting it to the default value
        percOfPass.setText("");
        percOfPass.setText("Percentage needed to pass: "+percentageCorrect+"%");
    }


    public void openAdditionPage(View v){


        //We are sending the default number of questions and percentage correct

        Intent i = new Intent(MainActivity.this, AdditionQuestions.class);

        //we are passing the variables here

        i.putExtra("numQuestions", numQuestion );
        i.putExtra("percentage", percentageCorrect);
        startActivity(i);
    }



    public void openMultiplicationPage(View v){



        //We are sending the default number of questions and percentage correct

        Intent i = new Intent(MainActivity.this, MultiplicationQuestions.class);

        //we are passing the variables here

        i.putExtra("numQuestions", numQuestion );
        i.putExtra("percentage", percentageCorrect);
        startActivity(i);
    }

    public void openSettingPage(View v){


        //We are sending the default number of questions and percentage correct

        Intent i = new Intent(MainActivity.this, SettingPage.class);

        //we are passing the variables here

        i.putExtra("numQuestions", numQuestion );
        i.putExtra("percentage", percentageCorrect);
        startActivity(i);
    }




}
