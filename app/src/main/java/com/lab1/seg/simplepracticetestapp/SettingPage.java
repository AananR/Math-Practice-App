package com.lab1.seg.simplepracticetestapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SettingPage extends AppCompatActivity {

    private EditText mEditText;
    private EditText pEditText;
    private int numQuestion;
    private int percentageCorrect;
    private Button qButton;
    private Button pButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page);
        mEditText = (EditText) findViewById(R.id.editText2);
        pEditText = (EditText) findViewById(R.id.editText3);

        qButton = (Button) findViewById(R.id.button3);
        pButton = (Button) findViewById(R.id.button8);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            numQuestion = extras.getInt("numQuestions");
            percentageCorrect = extras.getInt("percentage");}




        mEditText.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    qButton.performClick();
                    return true;
                }
                return false;
            }
        });

        pEditText.setOnKeyListener(new View.OnKeyListener()
        {
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                    pButton.performClick();
                    return true;
                }
                return false;
            }
        });



    }


    //This is the onclick function that will change the number of questions asked
    public void updateNumQuestions(View v){


        //my validation that the user is actually inputting an integer and positive
       try{
        if( mEditText.getText().toString().length() == 0 ){
            mEditText.setError( "A positive integer is required!" );}
        else if(Integer.parseInt(mEditText.getText().toString())<=0){
            mEditText.setError( "A positive integer greater than 0 is required!" );
        }else{

        numQuestion =  Integer.parseInt(mEditText.getText().toString());
            new AlertDialog.Builder(this)
                    .setTitle("Number of Questions")
                    .setMessage("You have updated the number of questions to be asked to: "+ numQuestion)

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Continue with delete operation
                        }
                    })


                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

       }}catch (NumberFormatException e){

           mEditText.setError( "A positive integer is required!" );
       }


        //resetting the text box so it is empty
        mEditText.setText("");








    }


    //This is the onclick function that will change the Percentage to pass
    public void updatepercentageCorrect(View v){
        try{
        //my validation that the user is actually inputting an integer and positive

        if( pEditText.getText().toString().length() == 0 ){
            pEditText.setError( "A positive integer is required!" );}
        else if(Integer.parseInt(pEditText.getText().toString())<=0){
            pEditText.setError( "A positive integer greater than 0 is required!" );
        }else{

            percentageCorrect =  Integer.parseInt(pEditText.getText().toString());
            new AlertDialog.Builder(this)
                    .setTitle("Percentage to Pass")
                    .setMessage("You will now need "+ percentageCorrect+"% or above to pass.")

                    // Specifying a listener allows you to take an action before dismissing the dialog.
                    // The dialog is automatically dismissed when a dialog button is clicked.
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })


                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

        }}catch (NumberFormatException e){

            pEditText.setError( "A positive integer is required!" );
        }




        //resetting the text box so it is empty
        pEditText.setText("");




    }

    //This is the onclick function that will change the Percentage to pass
    public void goHome(View v){

        //We are sending the default number of questions and percentage correct

        Intent i = new Intent(SettingPage.this, MainPage.class);

        //we are passing the variables here

        i.putExtra("numQuestions", numQuestion );
        i.putExtra("percentage", percentageCorrect);
        startActivity(i);






    }



}
