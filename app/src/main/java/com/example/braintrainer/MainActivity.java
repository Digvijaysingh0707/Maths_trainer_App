package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;



public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView resultTextView;
    TextView pointsTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgainButton;
    RelativeLayout gameRelativeLayout;
    int locarionOfCorrrectAnswer;
    int numberOfQuestion =0;

    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    int score = 0;
    int numberOfQuestions = 0;


    public void playAgain(View view) {

        score = 0;
        numberOfQuestions = 0;

        timerTextView.setText("30s");
        pointsTextView.setText("0/0");
        resultTextView.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);

        generateQuestion();

        new CountDownTimer(30100, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000+"s ")) ;

            }

            @Override
            public void onFinish() {
                playAgainButton.setVisibility(View.VISIBLE);
                timerTextView.setText("0s");
                resultTextView.setText("Your scoe"+Integer.toString(score)+"/"+Integer.toString(numberOfQuestion));

            }
        }.start();


    }

    public void generateQuestion(){
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b =rand.nextInt(21);

        sumTextView.setText(Integer.toString(a)+" + "+Integer.toString(b));

        locarionOfCorrrectAnswer =rand.nextInt(4);
        answers.clear();

        int incorrectAnswer;

        for(int i=0;i<4;i++){
            if(i==locarionOfCorrrectAnswer){
                answers.add(a+b);
            }
            incorrectAnswer = rand.nextInt(41);
            while(incorrectAnswer==a+b){
                incorrectAnswer=rand.nextInt(41);
            }
            answers.add(incorrectAnswer);
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));


    }

    public void chooseAnswer(View view){
        if(view.getTag().toString().equals(Integer.toString(locarionOfCorrrectAnswer))){
            score++;
            resultTextView.setText("Correct!");
        }
        else{
            resultTextView.setText("Wrong!");
        }
        numberOfQuestion++;
        pointsTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestion));
        generateQuestion();
    }
    public void Start(View view){
        startButton.setVisibility(view.INVISIBLE);
        gameRelativeLayout.setVisibility(RelativeLayout.VISIBLE);
        playAgain(findViewById(R.id.playAgainButton));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button)findViewById(R.id.startButton);
        sumTextView =(TextView)findViewById(R.id.sumTextView);
        button0 =(Button)findViewById(R.id.button0);
        button1 =(Button)findViewById(R.id.button1);
        button2 =(Button)findViewById(R.id.button2);
        button3 =(Button)findViewById(R.id.button3);
        resultTextView =(TextView)findViewById(R.id.resultTextView);
        pointsTextView =(TextView)findViewById(R.id.pointsTextView);
        timerTextView =(TextView)findViewById(R.id.TimerTextView);
        playAgainButton=(Button)findViewById(R.id.playAgainButton);
        gameRelativeLayout=(RelativeLayout)findViewById(R.id.gameRelativeLayout);




    }
}

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        //getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        //int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        //if (id == R.id.action_settings) {
//            return true;
//
//
//        //return super.onOptionsItemSelected(item);
//    }
//}
