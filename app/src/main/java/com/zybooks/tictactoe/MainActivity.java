package com.zybooks.tictactoe;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private final Button[][] gameGrid = new Button[3][3];
    private boolean player1 = true;


    private int roundCount;
    private TextView messageTextView;

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
        messageTextView = (TextView) findViewById(R.id.textView);
    }

    public void onNewGameClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }
        if (player1) {
            ((Button) v).setText("X");
            messageTextView.setText("Player O's turn");
        }
        else {
            messageTextView.setText("Player X's turn");
            ((Button) v).setText("O");
        }

        roundCount++;


        if (checkWin()) {
            if (player1) {
                player1Wins();
            } else {
                player2Wins();
            }
        }
        else if(roundCount == 9){
            draw();
        } else {
            player1 = !player1;
        }
    }


    private boolean checkWin() {
        String[][] square = new String[3][3];
        for (int x = 0; x < gameGrid.length; x++) {
            for (int y = 0; y < gameGrid[x].length; y++) {
                square[x][y] = gameGrid[x][y].getText().toString();
            }
        }
        for (int x = 0; x < gameGrid.length; x++) {
            if (square[x][0].equals(square[x][1]) && square[x][0].equals(square[x][2]) && !square[x][0].equals("")) {
                return true;
            }
        }
        for (int x = 0; x < gameGrid.length; x++) {
            if (square[0][x].equals(square[1][x]) && square[0][x].equals(square[2][x]) && !square[0][x].equals("")) {
                return true;
            }
        }
        if (square[0][0].equals(square[1][1]) && square[0][0].equals(square[2][2]) && !square[0][0].equals("")) {
            return true;
        }
        return square[0][2].equals(square[1][1]) && square[0][2].equals(square[2][0]) && !square[0][2].equals("");
    }

    private void draw() {
        messageTextView.setText("DRAW!!");
    }

    private void player2Wins() {
        messageTextView.setText("Player O WINS");
    }

    private void player1Wins() {
        messageTextView.setText("Player X WINS");
    }

    @Override
    protected void onSaveInstanceState(@NonNull  Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("player1", player1);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        player1 = savedInstanceState.getBoolean("player1");
    }
}

