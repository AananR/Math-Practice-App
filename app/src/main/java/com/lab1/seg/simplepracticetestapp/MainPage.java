package com.lab1.seg.simplepracticetestapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }


    public void openAdditionPage(View v){
        startActivity(new Intent(MainPage.this, AdditionQuestions.class));
    }

    public void openSubtractionPage(View v){
        startActivity(new Intent(MainPage.this, SubtractionQuestions.class));
    }

    public void openMultiplicationPage(View v){
        startActivity(new Intent(MainPage.this, MultiplicationQuestions.class));
    }

    public void openDivisionPage(View v){
        startActivity(new Intent(MainPage.this, DivisionQuestions.class));
    }
}
