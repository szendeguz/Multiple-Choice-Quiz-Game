package com.example.multiplechoicegame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizGame extends AppCompatActivity {

    //declaring widgets
    TextView questionField, score, healthPoints;
    Button btn1, btn2, btn3, btn4;

    //declaring variables
    private int scorePoints, life=3, answerCount=0;
    private String correctAnswer;

    //making objects
    Questions quizObj = new Questions();
    Random randomNum = new Random();

    //making questionBody - this is going to store the Questions object
    ArrayList<ArrayList<String>> questionBody = new ArrayList<ArrayList<String>>();
    String qData[][] = quizObj.getqData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_game);

        //linking widgets to xml
        score = (TextView)findViewById(R.id.tvScore);
        healthPoints= (TextView)findViewById(R.id.tvLife);
        questionField = (TextView)findViewById(R.id.tvQuestion);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);

        makeQuiz();
        nextQuestion();

        //setting onClickListener
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn1.getText().equals(correctAnswer)){
                    btn1.setBackgroundResource(R.drawable.btncorrect);
                    scorePoints = scorePoints + 100;
                    updateScore(scorePoints);
                    answerCount++;
                    if(answerCount<15){
                        timer();
                    } else {
                        winTimer();
                    }
                } else {
                    btn1.setBackgroundResource(R.drawable.btnwrong);
                    life--;
                    if(life==0){
                        loseTimer();
                    } else {
                        updateLife(life);
                        timer();
                    }
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn2.getText().equals(correctAnswer)){
                    btn2.setBackgroundResource(R.drawable.btncorrect);
                    scorePoints = scorePoints + 100;
                    updateScore(scorePoints);
                    answerCount++;
                    if(answerCount<15){
                        timer();
                    } else {
                        winTimer();
                    }
                } else {
                    btn2.setBackgroundResource(R.drawable.btnwrong);
                    life--;
                    if(life==0){
                        loseTimer();
                    } else {
                        updateLife(life);
                        timer();
                    }
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn3.getText().equals(correctAnswer)){
                    btn3.setBackgroundResource(R.drawable.btncorrect);
                    scorePoints = scorePoints + 100;
                    updateScore(scorePoints);
                    answerCount++;
                    if(answerCount<15){
                        timer();
                    } else {
                        winTimer();
                    }
                } else {
                    btn3.setBackgroundResource(R.drawable.btnwrong);
                    life--;
                    if(life==0){
                        loseTimer();
                    } else {
                        updateLife(life);
                        timer();
                    }
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btn4.getText().equals(correctAnswer)){
                    btn4.setBackgroundResource(R.drawable.btncorrect);
                    scorePoints = scorePoints + 100;
                    updateScore(scorePoints);
                    answerCount++;
                    if(answerCount<15){
                        timer();
                    } else {
                        winTimer();
                    }
                } else {
                    btn4.setBackgroundResource(R.drawable.btnwrong);
                    life--;
                    if(life==0){
                        loseTimer();
                    } else {
                        updateLife(life);
                        timer();
                    }
                }
            }
        });

    }

    //makeQuiz method will add the questions to the questionBody
    public void makeQuiz(){
        for(int i=0;i<qData.length;i++){
            ArrayList<String> tempArr = new ArrayList<String>();
            tempArr.add(qData[i][0]);
            tempArr.add(qData[i][1]);
            tempArr.add(qData[i][2]);
            tempArr.add(qData[i][3]);
            tempArr.add(qData[i][4]);

            questionBody.add(tempArr);
        }
    }

    //nextQuestion method will call a new set of questions
    public void nextQuestion(){
        int random = randomNum.nextInt(questionBody.size());
        //making a new question and answers from getting a random set from questionBody
        ArrayList<String> quiz = new ArrayList<String>();
        quiz = questionBody.get(random);

        //setting the textview of the question
        questionField.setText(quiz.get(0));
        //setting correctAnswer variable to the correct answer
        correctAnswer = quiz.get(1);
        //removing the question from the set
        quiz.remove(0);
        //shuffling the answers
        Collections.shuffle(quiz);

        //setting button text to shuffeled answeres
        btn1.setText(quiz.get(0));
        btn2.setText(quiz.get(1));
        btn3.setText(quiz.get(2));
        btn4.setText(quiz.get(3));

        //removing this set from the questionBody
        questionBody.remove(random);

        //btnOn();
        //resetting the background
        bckgrndReset();
    }

    //opening LosingScreen activity
    public void gameOver(){
        Intent intent = new Intent(QuizGame.this, LosingScreen.class);
        //putting extra to intent to send the final score
        intent.putExtra("TOTAL_SCORE", scorePoints);
        startActivity(intent);
        finish();
    }

    //opening WinningScreen activity
    public void gameWon(){
        Intent intent = new Intent(QuizGame.this, WinningScreen.class);
        startActivity(intent);
        finish();
    }

    //calling a nextQuestion method in 550 milliseconds delay
    public void timer(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                nextQuestion();
            }
        }, 550);
    }

    //calling the winningScreen activity
    public void winTimer(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                gameWon();
            }
        }, 550);
    }

    //calling the LosingScreen activity
    public void loseTimer(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                gameOver();
            }
        }, 550);
    }

    //reseting the background button to the bgbutton
    public void bckgrndReset(){
        btn1.setBackgroundResource(R.drawable.bgbutton);
        btn2.setBackgroundResource(R.drawable.bgbutton);
        btn3.setBackgroundResource(R.drawable.bgbutton);
        btn4.setBackgroundResource(R.drawable.bgbutton);
    }

    //updating score
    public void updateScore(int x){
        score.setText("Score: " + x);
    }

    //updating health
    public void updateLife(int x){
        healthPoints.setText("Health: " + x + "/3");
    }
}
