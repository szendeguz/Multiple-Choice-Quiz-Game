package com.example.multiplechoicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LosingScreen extends AppCompatActivity {

    //declaring widgets
    TextView tvScoreField, tvGameOver;
    Button btnNewGame, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_losing_screen);

        //linking widgets to xml
        tvScoreField = (TextView)findViewById(R.id.tvScoreField);
        btnNewGame = (Button)findViewById(R.id.btnReset);
        btnExit = (Button)findViewById(R.id.btnClose);

        //calling final score to display the final score
        finalScore();

        //setting onClickListener
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newGame();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeApp();
            }
        });
    }

    //gets the scores from the previous activity
    public void finalScore(){
        int myInt = getIntent().getIntExtra("TOTAL_SCORE", 0);
        tvScoreField.setText("Score: " + myInt);
    }

    //starting new game
    public void newGame(){
        Intent intent = new Intent(this, QuizGame.class);
        startActivity(intent);
        finish();
    }

    //closing app
    public void closeApp(){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
