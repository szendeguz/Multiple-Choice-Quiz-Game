package com.example.multiplechoicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartScreen extends AppCompatActivity {

    //declaring widgets
    private TextView tvDemo;
    private Button btnStart, btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);

        //linking widgets to xml
        tvDemo = (TextView)findViewById(R.id.tvDemo);
        btnStart = (Button)findViewById(R.id.btnStart);
        btnExit = (Button)findViewById(R.id.btnExit);

        //setting onClickListener
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGame();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeApp();
            }
        });
    }

    //opening quiz game
    public void openGame(){
        Intent intent = new Intent(this, QuizGame.class);
        startActivity(intent);
        finish();
    }


    //close application method
    public void closeApp(){
        moveTaskToBack(true);
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(1);
    }
}
