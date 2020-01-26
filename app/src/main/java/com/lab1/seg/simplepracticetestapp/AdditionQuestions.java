package com.lab1.seg.simplepracticetestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class AdditionQuestions extends AppCompatActivity {

    private LinearLayout mLayout;
    private EditText mEditText;
    private Button mButton;
    private TextView text;

    int rando = (int) ((Math.random()*10)+1);
    int correct = 0;
    int answer = 0;
    int turns = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition_questions);

        mLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button6);
        text = (TextView) findViewById(R.id.textView45);

        mButton.setOnClickListener(onClick());
        math();
    }

    private View.OnClickListener onClick() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                turns = turns-1;

                int userAns =  Integer.parseInt(mEditText.getText().toString());

                if(userAns == answer){
                    correct=correct+1;
                }
                mEditText.setText("");
                if(turns>0){
                    math();
                }else{

                    Intent i = new Intent(AdditionQuestions.this, SolutionPage.class);
                    i.putExtra("correct", correct);
                    i.putExtra("turn", 3);
                    startActivity(i);

                }

            }
        };
    }


    public void math(){

        //final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        //final TextView textView = new TextView(this);
        //textView.setLayoutParams(lparams);
        text.setText("");
        String question = additionQuestion();
        text.setText("" + question);
        //mLayout.addView(text);

    }

    public String additionQuestion(){
        int firstInt = (int) ((Math.random()*100)+1);
        int secondInt = (int) ((Math.random()*100)+1);

        answer = firstInt+secondInt;

        String question = firstInt+" + "+secondInt+"=";

        return question;

    }




    }

