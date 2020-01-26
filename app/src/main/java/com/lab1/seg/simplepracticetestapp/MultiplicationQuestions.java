package com.lab1.seg.simplepracticetestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class MultiplicationQuestions extends AppCompatActivity {

    private LinearLayout mLayout;
    private EditText mEditText;
    private Button mButton;
    private TextView text;



    //This will keep track of whats correct
    int correct = 0;
    int answer = 0;

    int numQuestion = 0;
    int percentageCorrect=50;

    int counter= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_questions);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            numQuestion = extras.getInt("numQuestions");
            percentageCorrect = extras.getInt("percentage");
            counter = numQuestion;}

        //We are just fetching the components for the xml
        mLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button6);
        text = (TextView) findViewById(R.id.textView45);


        mEditText.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    mButton.performClick();
                    return true;
                }
                return false;
            }
        });

        mButton.setOnClickListener(onClick());

        //we call the math function on the on create for the first question
        math();
    }

    //the onclick decrements the counter for turns as well as keeps track of the number of correct
    private View.OnClickListener onClick() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //my validation that the user is actually inputting an integer and positive

                if( mEditText.getText().toString().length() == 0 ){
                    mEditText.setError( "A positive integer is required!" );}else{

                    try{

                        counter = counter-1;


                        int userAns =  Integer.parseInt(mEditText.getText().toString());

                        if(userAns == answer){
                            correct=correct+1;
                        }

                        //resetting the text box so it is empty
                        mEditText.setText("");
                        if(counter>0){
                            math();
                        }else{

                            //if the number of questions is complete we open a new activity that will show the user how they did

                            Intent i = new Intent(MultiplicationQuestions.this, SolutionPage.class);

                            //we are passing the variables here
                            i.putExtra("correct", correct);
                            i.putExtra("numQuestion", numQuestion );
                            i.putExtra("percentageCorrect", percentageCorrect);
                            startActivity(i);

                        }}catch (NumberFormatException e){
                        //have to increment again because of the try
                        counter = counter+1;
                        mEditText.setError( "A positive integer is required!" );
                    }}

            }
        };
    }



    //this function will set the question

    public void math(){

        //final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //final TextView textView = new TextView(this);
        //textView.setLayoutParams(lparams);
        text.setText("");
        String question = MultiplicationQuestion();
        text.setText("" + question);
        //mLayout.addView(text);

    }


    //this function creates the questions
    public String MultiplicationQuestion(){
        int firstInt = (int) ((Math.random()*100)+1);
        int secondInt = (int) ((Math.random()*100)+1);

        answer = firstInt*secondInt;

        String question = firstInt+" x "+secondInt+"=";

        return question;

    }




}

