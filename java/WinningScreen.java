package com.example.multiplechoicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WinningScreen extends AppCompatActivity {

    //declaring widgets
    Button btnNewGame, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_screen);

        //linking widgets to xml
        btnNewGame = (Button)findViewById(R.id.btnReset);
        btnExit = (Button)findViewById(R.id.btnClose);

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

    //starting new game with
    public void newGame(){
        Intent intent = new Intent(this, QuizGame.class);
        startActivity(intent);
        finish();
    }

    //closing the app
    public void closeApp(){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
