package com.zybooks.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button newGameButton;
    private TextView messageTextView;
    private String gameString;
    private Button[][] gameGrid = new Button[3][3];
    private boolean playerXTurn = true;
    private int roundCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




// get references to widgets
        gameGrid[0][0] = (Button) findViewById(R.id.square1);
        gameGrid[0][1] = (Button) findViewById(R.id.square2);
        gameGrid[0][2] = (Button) findViewById(R.id.square3);
        gameGrid[1][0] = (Button) findViewById(R.id.square4);
        gameGrid[1][1] = (Button) findViewById(R.id.square5);
        gameGrid[1][2] = (Button) findViewById(R.id.square6);
        gameGrid[2][0] = (Button) findViewById(R.id.square7);
        gameGrid[2][1] = (Button) findViewById(R.id.square8);
        gameGrid[2][2] = (Button) findViewById(R.id.square9);
        newGameButton = (Button) findViewById(R.id.newGameButton);
        messageTextView = (TextView) findViewById(R.id.messageTextView);
    }



    public void onTicButtonClick(View view) {

    }




        public void onNewGameClick (View view){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
