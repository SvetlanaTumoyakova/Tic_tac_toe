package com.example.tic_tac_toe;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PlayingField extends AppCompatActivity {
    private int activePlayer = 1;
    private int[] boxPositions = {0,0,0,0,0,0,0,0,0};
    private int totalSelectedBoxes = 1;

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;
    private ImageView image7;
    private ImageView image8;
    private ImageView image9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_field);

        TextView playerOneName = findViewById(R.id.playerOneName);
        TextView playerTwo = findViewById(R.id.playerTwoName);

        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");

        playerOneName.setText(getPlayerOneName);
        playerTwo.setText(getPlayerTwoName);

        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        image6 = findViewById(R.id.image6);
        image7 = findViewById(R.id.image7);
        image8 = findViewById(R.id.image8);
        image9 = findViewById(R.id.image9);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAction((ImageView) v, 0 );
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAction((ImageView) v, 1 );
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAction((ImageView) v, 2 );
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAction((ImageView) v, 3 );
            }
        });

        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAction((ImageView) v, 4 );
            }
        });

        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAction((ImageView) v, 5 );
            }
        });

        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAction((ImageView) v, 6 );
            }
        });

        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAction((ImageView) v, 7 );
            }
        });

        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performAction((ImageView) v, 8 );
            }
        });



    }

    private void performAction(ImageView imageView, int selectedBoxPosition){
        boxPositions[selectedBoxPosition] = activePlayer;
        imageView.setBackgroundResource(R.drawable.white_box);
        imageView.setScaleType(ImageView.ScaleType.CENTER);

        if(activePlayer == 1){
            imageView.setImageResource(R.drawable.ximage);
            changePlayerTurn(2);
            totalSelectedBoxes++;
        }else{
            imageView.setImageResource(R.drawable.oimage);
            changePlayerTurn(1);
            totalSelectedBoxes++;
        }
    }

    private void changePlayerTurn(int currentPlayerTurn){
        activePlayer = currentPlayerTurn;
        LinearLayout playerOneLayoutOuter = findViewById(R.id.playerOneLinearLayout);
        LinearLayout playerTwoLayoutOuter = findViewById(R.id.playerTwoLinearLayout);

        if(activePlayer == 1){
            playerOneLayoutOuter.setBackgroundResource(R.drawable.black_border);
            playerTwoLayoutOuter.setBackgroundResource(R.drawable.white_box);
        }else{
            playerTwoLayoutOuter.setBackgroundResource(R.drawable.black_border);
            playerOneLayoutOuter.setBackgroundResource(R.drawable.white_box);
        }
    }
}