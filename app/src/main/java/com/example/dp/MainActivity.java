package com.example.dp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.math.BigInteger;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public TextView[][] textViews;
    public String[][] textViewName;
    public CardView[][] cView;
    public int[][] isClicked;
    public ImageView hint;
    public TextView score;
    public Model[][] models;
    public int sum = 0;
    public int result;
    public Button button;
    public Button reset;
    public int isPlayed = 0;
    public Button buton_1;
    public int max2 = 0;
    public int[][] data;
    public TextView difficulty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViews = new TextView[5][5];
        textViewName = new String[5][5];
        cView = new CardView[5][5];
        isClicked = new int[5][5];
        models = new Model[5][5];
        int i;
        int k;
        reset = findViewById(R.id.reset);
        data = new int[5][5];
        difficulty = findViewById(R.id.difficulty);
        difficulty.setText("Level: "+Model.difficulty1);
        buton_1 = findViewById(R.id.button_1);
        reset = findViewById(R.id.reset);
        reset.setVisibility(View.VISIBLE);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i1;
                int k1;
                CardView cardView;
                for(i1 = 0; i1 <= 4; i1++)
                {
                    for(k1 = 0; k1 <= 4; k1++)
                    {
                        isClicked[i1][k1] = 0;
                        cardView = cView[i1][k1];
                        cardView.setCardBackgroundColor(Color.parseColor("#ffffff"));
                        sum = 0;
                        Log.d("Reset_result", ""+isClicked[i1][k1]+"click");
                        score.setText("0");
                        Log.d("Reset_result", i1+" "+k1);
                    }
                }
            }
        });
        buton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });
        hint = findViewById(R.id.hint);
        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHint();
            }
        });
        button = findViewById(R.id.submit);
        Log.d("LogD", "getId");
        textViews[0][0] = findViewById(R.id.e00);
        textViews[0][1] = findViewById(R.id.e01);
        textViews[0][2] = findViewById(R.id.e02);
        textViews[0][3] = findViewById(R.id.e03);
        textViews[0][4] = findViewById(R.id.e04);
        textViews[1][0] = findViewById(R.id.e10);
        textViews[1][1] = findViewById(R.id.e11);
        textViews[1][2] = findViewById(R.id.e12);
        textViews[1][3] = findViewById(R.id.e13);
        textViews[1][4] = findViewById(R.id.e14);
        textViews[2][0] = findViewById(R.id.e20);
        textViews[2][1] = findViewById(R.id.e21);
        textViews[2][2] = findViewById(R.id.e22);
        textViews[2][3] = findViewById(R.id.e23);
        textViews[2][4] = findViewById(R.id.e24);
        textViews[3][0] = findViewById(R.id.e30);
        textViews[3][1] = findViewById(R.id.e31);
        textViews[3][2] = findViewById(R.id.e32);
        textViews[3][3] = findViewById(R.id.e33);
        textViews[3][4] = findViewById(R.id.e34);
        textViews[4][0] = findViewById(R.id.e40);
        textViews[4][1] = findViewById(R.id.e41);
        textViews[4][2] = findViewById(R.id.e42);
        textViews[4][3] = findViewById(R.id.e43);
        textViews[4][4] = findViewById(R.id.e44);

        cView[0][0] = findViewById(R.id.c00);
        cView[0][1] = findViewById(R.id.c01);
        cView[0][2] = findViewById(R.id.c02);
        cView[0][3] = findViewById(R.id.c03);
        cView[0][4] = findViewById(R.id.c04);
        cView[1][0] = findViewById(R.id.c10);
        cView[1][1] = findViewById(R.id.c11);
        cView[1][2] = findViewById(R.id.c12);
        cView[1][3] = findViewById(R.id.c13);
        cView[1][4] = findViewById(R.id.c14);
        cView[2][0] = findViewById(R.id.c20);
        cView[2][1] = findViewById(R.id.c21);
        cView[2][2] = findViewById(R.id.c22);
        cView[2][3] = findViewById(R.id.c23);
        cView[2][4] = findViewById(R.id.c24);
        cView[3][0] = findViewById(R.id.c30);
        cView[3][1] = findViewById(R.id.c31);
        cView[3][2] = findViewById(R.id.c32);
        cView[3][3] = findViewById(R.id.c33);
        cView[3][4] = findViewById(R.id.c34);
        cView[4][0] = findViewById(R.id.c40);
        cView[4][1] = findViewById(R.id.c41);
        cView[4][2] = findViewById(R.id.c42);
        cView[4][3] = findViewById(R.id.c43);
        cView[4][4] = findViewById(R.id.c44);
        generateRandomNumbers();
        score = findViewById(R.id.score);
        for (i = 0; i <= 4; i++) {
            for (k = 0; k <= 4; k++) {
                cView[i][k].setOnClickListener(this);
            }
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int max1 = getResult();
                Log.d("sum=max", sum+" "+max1);
                if(max1 == sum)
                {
                    Model.difficulty1++;
                    difficulty.setText("Level: "+Model.difficulty1);
                    Log.d("sum=max", "sum");
                    score.setText("You won !!");
                    sum = 0;
                    Model.difficulty = Model.difficulty + 42;
                    button.setText("Next level");
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
                else
                {
                    reset.setVisibility(View.INVISIBLE);
                    Model.difficulty = 10;
                    Model.difficulty1 = 1;
                    difficulty.setText("Level: "+Model.difficulty1);
                    Snackbar snackbar = Snackbar.make(v, "Hard luck !!", Snackbar.LENGTH_SHORT);
                    snackbar.show();
                    max2 = 0;
                    max1 = 0;
                    int i;
                    int k;
                    int max = -1;
                    int row_of_max = 0;
                    int row;
                    int column;
                    result = getResult();
                    Model model = new Model();
                    for(i = 0; i <= 4; i++)
                    {
                        if(max < models[i][0].data)
                        {
                            max = models[i][0].data;
                            model = models[i][0];
                            row_of_max = i;
                        }
                    }
                    cView[row_of_max][0].setCardBackgroundColor(Color.parseColor("#7EED0F"));
                    for(i = 0; i <= 3; i++)
                    {
                        row = model.getRow();
                        column = model.getColumn();
                        cView[row][column].setCardBackgroundColor(Color.parseColor("#7EED0F"));
                        Log.d("reuse", row + " "+ column);
                        model = models[row][column];
                    }

                }
                max1 = 0;
                max2 = 0;
                }
        });
    }

    public void getHint()
    {
        int i;
        int k;
        int max = -1;
        int row = 0;
        int column = 0;
        for (k = 3; k >= 0; k--) {
            for (i = 0; i <= 4; i++) {
                if (i != 4) {
                    int x = data[i][k + 1];
                    int y = data[i + 1][k + 1];
                    if (x > y) {
                        data[i][k]= data[i][k] + data[i][k + 1];
                    } else {
                        data[i][k] = data[i][k] + data[i + 1][k + 1];
                    }
                } else {
                    data[i][k] = data[i][k] + data[i][k + 1];
                }
            }
        }
        for(i = 0; i <= 4; i++)
        {
            if(data[i][0] > max)
            {
                max = data[i][0];
                row = i;
                column = 0;
            }
        }
        cView[row][0].setCardBackgroundColor(Color.parseColor("#C3ED770F"));
    }

    public int getResult()
    {
        if(isPlayed == 0)
        {

            isPlayed = 1;
            int i;
            int k;
            for (k = 3; k >= 0; k--) {
                for (i = 0; i <= 4; i++) {
                    if (i != 4) {
                        int x = models[i][k + 1].data;
                        int y = models[i + 1][k + 1].data;
                        if (x > y) {
                            models[i][k].column = k + 1;
                            models[i][k].row = i;
                            models[i][k].data = models[i][k].data + models[i][k + 1].data;
                        } else {
                            models[i][k].column = k + 1;
                            models[i][k].row = i + 1;
                            models[i][k].data = models[i][k].data + models[i + 1][k + 1].data;
                        }
                    } else {
                        models[i][k].column = k + 1;
                        models[i][k].row = i;
                        models[i][k].data = models[i][k].data + models[i][k + 1].data;
                    }
                }
            }
        }
        else
        {
            Toast.makeText(MainActivity.this, "Click replay to play again !!", Toast.LENGTH_SHORT).show();
        }
        int i;
        for(i = 0; i <= 4; i++)
        {
            if(max2 < models[i][0].data)
            {
                max2 = models[i][0].data;
            }
        }
        return max2;
    }

    public void generateRandomNumbers() {
        Random random = new Random();
        int i;
        int k;
        for (i = 0; i <= 4; i++) {
            for (k = 0; k <= 4; k++) {
                textViewName[i][k] = String.valueOf(random.nextInt(Model.difficulty));
                Log.d("android", textViewName[i][k]);
                //models[i][k] = new Model(Integer.parseInt(textViewName[i][k]), 0, 0);
                Model model = new Model();
                data[i][k] = Integer.parseInt(textViewName[i][k]);
                model.setData(Integer.parseInt(textViewName[i][k]));
                models[i][k] = model;
                textViews[i][k].setText(textViewName[i][k]);
            }
        }
    }

    public int determineTheClick(int row, int column, View view)
    {
        int count = 0;
        if(row == 0)
        {
            if(isClicked[0][column-1] == 0)
            {
                Snackbar snackbar = Snackbar.make(view, "INVALID", Snackbar.LENGTH_SHORT);
                snackbar.show();
                count = 1;
            }
        }
        else
        {
            if(isClicked[row-1][column-1] == 0 && isClicked[row][column-1] == 0)
            {
                Snackbar snackbar = Snackbar.make(view, "INVALID", Snackbar.LENGTH_SHORT);
                snackbar.show();
                count = 1;
            }
        }
        return count;
    }

    public void changeColor(CardView view, String value, int row, int column)
    {

        if(isClicked[row][column] == 1)
        {
            sum = sum - Integer.parseInt(value);
            view.setCardBackgroundColor(Color.parseColor("#ffffff"));
            score.setText(""+sum);
            isClicked[row][column] = 0;
        }
        else
        {
            sum = sum + Integer.parseInt(value);
            score.setText(""+sum);
            isClicked[row][column] = 1;
            view.setCardBackgroundColor(Color.parseColor("#FF71C4DC"));
        }
    }

    public int isDelete(int row, int column, View view)
    {
        int count = 0;
        if(row == 4)
        {
            if(isClicked[row][column+1] == 1)
            {
                Snackbar snackbar = Snackbar.make(view, "Delete from last point", Snackbar.LENGTH_SHORT);
                snackbar.show();
                count = 1;
            }
        }
        else
        {
            if(isClicked[row+1][column+1] == 1 || isClicked[row][column+1] == 1)
            {
                Snackbar snackbar = Snackbar.make(view, "Delete from last point", Snackbar.LENGTH_SHORT);
                snackbar.show();
                count = 1;
            }
        }
        return count;
    }

    @Override
    public void onClick(View v)
    {
        CardView cardView;
        switch(v.getId()) {
            case R.id.c00:
                cardView = cView[0][0];
                if(isClicked[0][0] == 1 && isDelete(0, 0, v) == 1)
                {
                    break;
                }
                changeColor(cardView, textViewName[0][0], 0, 0);
                break;

            case R.id.c01:
                if(isClicked[0][1] == 1 && isDelete(0, 1, v) == 1)
                {
                    break;
                }
                if (determineTheClick(0, 1, v) == 0) {
                    cardView = cView[0][1];
                    changeColor(cardView, textViewName[0][1], 0, 1);
                }
                break;

            case R.id.c02:
                if(isClicked[0][2] == 1 && isDelete(0, 2, v) == 1)
                {
                    break;
                }
                if (determineTheClick(0, 2, v) == 0) {
                    cardView = cView[0][2];
                    changeColor(cardView, textViewName[0][2], 0, 2);
                }
                break;

            case R.id.c03:
                if(isClicked[0][3] == 1 && isDelete(0, 3, v) == 1)
                {
                    break;
                }
                if (determineTheClick(0, 3, v) == 0) {
                    cardView = cView[0][3];
                    changeColor(cardView, textViewName[0][3], 0, 3);
                }
                break;

            case R.id.c04:
                if (determineTheClick(0, 4, v) == 0) {
                    cardView = cView[0][4];
                    changeColor(cardView, textViewName[0][4], 0, 4);
                }
                break;

            case R.id.c10:
                if(isClicked[1][0] == 1 && isDelete(1, 0, v) == 1)
                {
                    break;
                }
                cardView = cView[1][0];
                changeColor(cardView, textViewName[1][0], 1, 0);
                break;

            case R.id.c11:
                if(isClicked[1][1] == 1 && isDelete(1, 1, v) == 1)
                {
                    break;
                }
                if (determineTheClick(1, 1, v) == 0) {
                    cardView = cView[1][1];
                    changeColor(cardView, textViewName[1][1], 1, 1);
                }
                break;

            case R.id.c12:
                if(isClicked[1][2] == 1 && isDelete(1, 2, v) == 1)
                {
                    break;
                }
                if (determineTheClick(1, 2, v) == 0) {
                    cardView = cView[1][2];
                    changeColor(cardView, textViewName[1][2], 1, 2);
                }
                break;

            case R.id.c13:
                if(isClicked[1][3] == 1 && isDelete(1, 3, v) == 1)
                {
                    break;
                }
                if (determineTheClick(1, 3, v) == 0) {
                    cardView = cView[1][3];
                    changeColor(cardView, textViewName[1][3], 1, 3);
                }
                break;

            case R.id.c14:
                if (determineTheClick(1, 4, v) == 0) {
                    cardView = cView[1][4];
                    changeColor(cardView, textViewName[1][4], 1, 4);
                }
                break;

            case R.id.c20:
                if(isClicked[2][0] == 1 && isDelete(2, 0, v) == 1)
                {
                    break;
                }
                cardView = cView[2][0];
                changeColor(cardView, textViewName[2][0], 2, 0);
                break;

            case R.id.c21:
                if(isClicked[2][1] == 1 && isDelete(2, 1, v) == 1)
                {
                    break;
                }
                if (determineTheClick(2, 1, v) == 0) {
                    cardView = cView[2][1];
                    changeColor(cardView, textViewName[2][1], 2, 1);
                }
                break;

            case R.id.c22:
                if(isClicked[2][2] == 1 && isDelete(2, 2, v) == 1)
                {
                    break;
                }
                if (determineTheClick(2, 2, v) == 0) {
                    cardView = cView[2][2];
                    changeColor(cardView, textViewName[2][2], 2, 2);
                }
                break;


            case R.id.c23:
                if(isClicked[2][3] == 1 && isDelete(2, 3, v) == 1)
                {
                    break;
                }
                if (determineTheClick(2, 3, v) == 0) {
                    cardView = cView[2][3];
                    changeColor(cardView, textViewName[2][3], 2, 3);
                }
                break;

            case R.id.c24:
                if (determineTheClick(2, 4, v) == 0)
                {
                    cardView = cView[2][4];
                    changeColor(cardView, textViewName[2][4], 2, 4);
                }
                   break;

            case R.id.c30:
                if(isClicked[3][0] == 1 && isDelete(3, 0, v) == 1)
                {
                    break;
                }
                cardView = cView[3][0];
                   changeColor(cardView, textViewName[3][0], 3, 0);
                   break;

            case R.id.c31:
                if(isClicked[3][1] == 1 && isDelete(3, 1, v) == 1)
                {
                    break;
                }
                if(determineTheClick(3, 1, v) == 0)
                {
                    cardView = cView[3][1];
                    changeColor(cardView, textViewName[3][1], 3, 1);
                }
                   break;

            case R.id.c32:
                if(isClicked[3][2] == 1 && isDelete(3, 2, v) == 1)
                {
                    break;
                }
                if(determineTheClick(3, 2, v) == 0)
                {
                    cardView = cView[3][2];
                    changeColor(cardView, textViewName[3][2], 3, 2);
                }
                   break;

            case R.id.c33:
                if(isClicked[3][3] == 1 && isDelete(3, 3, v) == 1)
                {
                    break;
                }
                if(determineTheClick(3, 3, v) == 0)
                {
                    cardView = cView[3][3];
                    changeColor(cardView, textViewName[3][3], 3, 3);
                }
                   break;

            case R.id.c34:
                if(determineTheClick(3, 4, v) == 0)
                {
                    cardView = cView[3][4];
                    changeColor(cardView, textViewName[3][4], 3, 4);
                }
                   break;

            case R.id.c40:
                if(isClicked[4][0] == 1 && isDelete(4, 0, v) == 1)
                {
                    break;
                }
                cardView = cView[4][0];
                   changeColor(cardView, textViewName[4][0], 4, 0);
                   break;

            case R.id.c41:
                if(isClicked[4][1] == 1 && isDelete(4, 1, v) == 1)
                {
                    break;
                }
                if(determineTheClick(4, 1, v) == 0)
                {
                    cardView = cView[4][1];
                    changeColor(cardView, textViewName[4][1], 4, 1);
                }
                   break;

            case R.id.c42:
                if(isClicked[4][2] == 1 && isDelete(4, 2, v) == 1)
                {
                    break;
                }
                if(determineTheClick(4, 2, v) == 0)
                {
                    cardView = cView[4][2];
                    changeColor(cardView, textViewName[4][2], 4, 2);
                }
                   break;

            case R.id.c43:
                if(isClicked[4][3] == 1 && isDelete(4, 3, v) == 1)
                {
                    break;
                }
                if(determineTheClick(4, 3, v) == 0)
                {
                    cardView = cView[4][3];
                    changeColor(cardView, textViewName[4][3], 4, 3);
                }
                   break;

            case R.id.c44:
                if(determineTheClick(4, 4, v) == 0)
                {
                    cardView = cView[4][4];
                    changeColor(cardView, textViewName[4][4], 4, 4);
                }
                   break;
        }
    }
}
