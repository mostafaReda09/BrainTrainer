package com.example.mostafa.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {
     Button goButton,button1,button2,button3,button4,playAgain;
     TextView sumTextView,resultTextView,numberOfPointsTextView,timerTextView;
    RelativeLayout relativeLayout;
    int answers []=new int [4];
    int correctAnswerLocation;
    int numberOfQuestion=0;
    int score=0;
    boolean gameIsActive=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton=(Button)findViewById(R.id.go_button);
        relativeLayout=(RelativeLayout)findViewById(R.id.relative_layout);
        sumTextView =(TextView)findViewById(R.id.sum_textview);
        resultTextView=(TextView)findViewById(R.id.result_text_view);
        numberOfPointsTextView=(TextView)findViewById(R.id.number_of_points);
        timerTextView=(TextView)findViewById(R.id.timer_tectview);
        button1=(Button)findViewById(R.id.choise1);
        button2=(Button)findViewById(R.id.choise2);
        button3=(Button)findViewById(R.id.choise3);
        button4=(Button)findViewById(R.id.choise4);
        playAgain=(Button)findViewById(R.id.play_again_button);




        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameIsActive){
                if(v.getTag().toString().equals(Integer.toString(correctAnswerLocation))){

                    resultTextView.setText("Correct!");
                    score++;
                }else{
                    resultTextView.setText("Wrong!");
                }
                createQuestion();
            }}
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gameIsActive){
                if(v.getTag().toString().equals(Integer.toString(correctAnswerLocation))){

                    resultTextView.setText("Correct!");
                    score++;
                }else{
                    resultTextView.setText("Wrong!");
                }
                createQuestion();

            }}
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameIsActive){
                if(v.getTag().toString().equals(Integer.toString(correctAnswerLocation))){

                    resultTextView.setText("Correct!");
                    score++;
                }else{
                    resultTextView.setText("Wrong!");
                }
                createQuestion();

            }}
        });
        button4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(gameIsActive){
                if(v.getTag().toString().equals(Integer.toString(correctAnswerLocation))){

                    resultTextView.setText("Correct!");
                    score++;
                }else{
                    resultTextView.setText("Wrong!");
                }
                createQuestion();
            }}
        });


        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameIsActive=true;
                goButton.setVisibility(View.INVISIBLE);
                relativeLayout.setVisibility(View.VISIBLE);
                createQuestion();
                startCountDownTimer();

            }
        });

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameIsActive=true;
                score=0;
                numberOfQuestion=0;
                playAgain.setVisibility(View.INVISIBLE);
                resultTextView.setText("");
                resultTextView.setTextSize(50);
                timerTextView.setText("30s");
                numberOfPointsTextView.setText("0/0");
                createQuestion();
                startCountDownTimer();


            }
        });
    }
    public void createQuestion(){
        if(gameIsActive){
        numberOfPointsTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestion));
        Random random=new Random();
        int a=random.nextInt(21);
        int b=random.nextInt(21);
        correctAnswerLocation=random.nextInt(4);
        int incorrectAnswer;
        for(int i=0;i<4;i++)
        {
            if (i==correctAnswerLocation)
                answers[i]=a+b;
            else {
                incorrectAnswer=random.nextInt(41);
                while (incorrectAnswer==a+b)
                    incorrectAnswer=random.nextInt(41);
                answers[i] = incorrectAnswer;
            }
        }
        sumTextView.setText(Integer.toString(a)+"+"+Integer.toString(b));
        button1.setText(Integer.toString(answers[0]));
        button2.setText(Integer.toString(answers[1]));
        button3.setText(Integer.toString(answers[2]));
        button4.setText(Integer.toString(answers[3]));
        numberOfQuestion++;

    }}
    public void startCountDownTimer(){
        new CountDownTimer(30100,1000){


            @Override
            public void onTick(long millisUntilFinished) {

                timerTextView.setText(Long.toString(millisUntilFinished/1000)+"s");

            }

            @Override
            public void onFinish() {
                timerTextView.setText("0s");
                resultTextView.setTextSize(30 );
                resultTextView.setText("your score is "+Integer.toString(score)+"/"+Integer.toString(numberOfQuestion));
                playAgain.setVisibility(View.VISIBLE);
                gameIsActive=false;

            }
        }.start();

    }
}
