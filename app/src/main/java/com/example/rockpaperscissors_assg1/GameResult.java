package com.example.rockpaperscissors_assg1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.Random;

public class GameResult extends AppCompatActivity {
    ImageButton rockBtn;
    ImageButton paperBtn;
    ImageButton scissorsBtn;
    ImageButton rockBtn1;
    ImageButton paperBtn1;
    ImageButton scissorsBtn1;
    String result;
    RelativeLayout choiceLayout;
    GridLayout resultLayout;
    TextView resultPrompt;
    Button replayBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_result);
    }

    //method if user selects rock
    public void selectRock(View view) {
        switch (computer()){ //get randomized choice as computer's choice
            case "rock":
                result= "It's a tie!"; //rock vs rock results a tie
                break;
            case "paper":
                result= "You have lost."; //rock loses to paper
                break;
            case "scissors":
                result= "You have won."; //rock wins over scissors
                break;
        }
        showResult(result); //display result of game
        rockBtn = (ImageButton)findViewById(R.id.rockBtn);
        rockBtn.setVisibility(View.VISIBLE); //display rock as user's choice in result layout
    }

    //method if user selects paper
    public void selectPaper(View view) {
        switch (computer()){
            case "rock":
                result= "You have won.";
                break;
            case "paper":
                result= "It's a tie!";
                break;
            case "scissors":
                result= "You have lost.";
                break;
        }
        showResult(result);
        paperBtn = (ImageButton)findViewById(R.id.paperBtn);
        paperBtn.setVisibility(View.VISIBLE);
    }

    //method if user selects scissors
    public void selectScissors(View view) {
        switch (computer()){
            case "rock":
                result= "You have lost.";
                break;
            case "paper":
                result= "You have won.";
                break;
            case "scissors":
                result= "It's a tie!";
                break;
        }
        showResult(result);
        scissorsBtn = (ImageButton)findViewById(R.id.scissorsBtn);
        scissorsBtn.setVisibility(View.VISIBLE);
    }

    //method to randomize either rock, paper or scissors
    public String computer() {
        Random rand = new Random();
        int a = rand.nextInt(4);
        if (a==1) {
            rockBtn1 = (ImageButton)findViewById(R.id.rockBtn1);
            rockBtn1.setVisibility(View.VISIBLE);
            return "rock";
        }
        else if (a==2){
            paperBtn1 = (ImageButton)findViewById(R.id.paperBtn1);
            paperBtn1.setVisibility(View.VISIBLE);
            return "paper";
        }
        else {
            scissorsBtn1 = (ImageButton)findViewById(R.id.scissorsBtn1);
            scissorsBtn1.setVisibility(View.VISIBLE);
            return "scissors";
        }
    }

    //method to switch to result layout
    public void showResult(String result){
        choiceLayout = (RelativeLayout)findViewById(R.id.choiceLayout);
        choiceLayout.setVisibility(View.INVISIBLE); //hide layout that let user's select action
        resultLayout = (GridLayout)findViewById(R.id.resultLayout);
        resultLayout.setVisibility(View.VISIBLE); //display layout that shows result of game
        resultPrompt = (TextView)findViewById(R.id.resultPrompt);
        resultPrompt.setText(result); //display result text
        replayBtn = (Button)findViewById(R.id.replayBtn);
        replayBtn.setVisibility(View.VISIBLE); //display replay button

        //when user clicks on replay button, return to home page to replay
        replayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameResult.this, MainActivity.class));
            }
        });
    }
}