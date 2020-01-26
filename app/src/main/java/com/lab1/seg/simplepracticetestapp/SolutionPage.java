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
            turn = extras.getInt("turn");        }
        mLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mButton = (Button) findViewById(R.id.button7);
        text = (TextView) findViewById(R.id.textView46);


        text.setText("");
        String ans = percentage();
        text.setText("" + ans);

        mButton.setOnClickListener(onClick());
    }

    public String percentage(){
        int perc = correct/turn*100;

        if(perc>50){
            String ans = "Congratulations you passed with a grade of "+ perc;
            return ans;
        }else{

            String ans = "Unfortunately you failed with a grade of "+ correct+ ". You just need more practice!";
            return ans;

        }
    }

    private View.OnClickListener onClick() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(SolutionPage.this, MainPage.class));

            }
        };
    }


}
