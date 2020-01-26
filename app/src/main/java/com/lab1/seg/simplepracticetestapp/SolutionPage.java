package com.lab1.seg.simplepracticetestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SolutionPage extends AppCompatActivity {

    int correct = 0;
    int turn = 0;
    int percentageCorrect =0;

    private LinearLayout mLayout;
    private Button mButton;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution_page);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            correct = extras.getInt("correct");
            turn = extras.getInt("numQuestion");
            percentageCorrect = extras.getInt("percentageCorrect");}
        mLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mButton = (Button) findViewById(R.id.button7);
        text = (TextView) findViewById(R.id.textView46);


        text.setText("");
        String ans = percentage();
        text.setText("" + ans);

        mButton.setOnClickListener(onClick());
    }

    public String percentage(){
        //have to make the two values a double or else we are returning 0 when we do correct/turns
        double cor = correct;
        double turnTwo = turn;

        double perc = ((cor/turnTwo)*100);

        //changing it to int so easier to read
        int value = (int) perc;

        if(value>=percentageCorrect){
            String ans = "Congratulations you passed with a grade of "+ value+"%! You got "+correct+"/"+turn+" correct! ";
            return ans;
        }else{

            String ans = "Unfortunately you failed with a grade of "+value+ "%. You only got "+correct+"/"+turn+" correct!";
            return ans;

        }
    }

    private View.OnClickListener onClick() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(SolutionPage.this, MainPage.class);

                //we are passing the variables here

                i.putExtra("numQuestions", turn );
                i.putExtra("percentage", percentageCorrect);
                startActivity(i);

            }
        };
    }


}
