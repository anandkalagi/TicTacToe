package com.droidrank.tictactoe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    Button restart;
    TextView result;
    private boolean isPlayerOne = true;
    Button [][] block = new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        block[0][0] = (Button) findViewById(R.id.bt_block1);
        block[0][1] = (Button) findViewById(R.id.bt_block2);
        block[0][2] = (Button) findViewById(R.id.bt_block3);
        block[1][0] = (Button) findViewById(R.id.bt_block4);
        block[1][1] = (Button) findViewById(R.id.bt_block5);
        block[1][2] = (Button) findViewById(R.id.bt_block6);
        block[2][0] = (Button) findViewById(R.id.bt_block7);
        block[2][1] = (Button) findViewById(R.id.bt_block8);
        block[2][2] = (Button) findViewById(R.id.bt_block9);
        result = (TextView) findViewById(R.id.tv_show_result);
        restart = (Button) findViewById(R.id.bt_restart_game);

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                block[i][j].setText(" ");
            }
        }
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                block[i][j].setOnClickListener(this);
            }
        }

        /**
         * Restarts the game
         */
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(restart.getText().toString().equals("Restart Game")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this)
                            .setTitle(R.string.app_name)
                            .setMessage(R.string.restart_message).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                }
                            })
                            .setPositiveButton("OK", new DialogInterface.OnClickListener(){

                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    restartGame();
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });

    }

    private void restartGame() {
        isPlayerOne = true;
        result.setText("");
        restart.setText(R.string.restart_button_text_initially);

        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                block[i][j].setEnabled(true);
            }
        }
        for(int i = 0; i<3; i++){
            for(int j = 0; j<3; j++){
                block[i][j].setText(" ");
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_block1:{
                onclickBlock(block[0][0]);
                restart.setText(R.string.restart_button_text_in_middle_of_game);
                block[0][0].setEnabled(false);
                winner();
                break;
            }
            case R.id.bt_block2:{
                onclickBlock(block[0][1]);
                restart.setText(R.string.restart_button_text_in_middle_of_game);
                block[0][1].setEnabled(false);
                winner();
                break;
            }
            case R.id.bt_block3:{
                onclickBlock(block[0][2]);
                restart.setText(R.string.restart_button_text_in_middle_of_game);
                block[0][2].setEnabled(false);
                winner();
                break;
            }
            case R.id.bt_block4:{
                onclickBlock(block[1][0]);
                restart.setText(R.string.restart_button_text_in_middle_of_game);
                block[1][0].setEnabled(false);
                winner();
                break;
            }
            case R.id.bt_block5:{
                 onclickBlock(block[1][1]);
                restart.setText(R.string.restart_button_text_in_middle_of_game);
                block[1][1].setEnabled(false);
                winner();
                break;
            }
            case R.id.bt_block6:{
                onclickBlock(block[1][2]);
                restart.setText(R.string.restart_button_text_in_middle_of_game);
                block[1][2].setEnabled(false);
                winner();
                break;
            }
            case R.id.bt_block7:{
                onclickBlock(block[2][0]);
                restart.setText(R.string.restart_button_text_in_middle_of_game);
                block[2][0].setEnabled(false);
                winner();
                break;
            }
            case R.id.bt_block8:{
                onclickBlock(block[2][1] );
                restart.setText(R.string.restart_button_text_in_middle_of_game);
                block[2][1].setEnabled(false);
                winner();
                break;
            }
            case R.id.bt_block9:{
                onclickBlock(block[2][2]);
                restart.setText(R.string.restart_button_text_in_middle_of_game);
                block[2][2].setEnabled(false);
                winner();
                break;
            }

        }
    }

    private String onclickBlock(Button block) {
        if(isPlayerOne){
            block.setText(R.string.player_1_move);
            isPlayerOne = false;
        }else{
            block.setText(R.string.player_2_move);
            isPlayerOne = true;
        }
        return block.getText().toString();
    }

     String getBtnString(Button btn){
        return btn.getText().toString();
    }
    void winner(){
            for (int i = 0; i < 3; i++) {
                if ((getBtnString(block[0][i]).equals("O") || getBtnString(block[0][i]).equals("X")) && getBtnString(block[0][i]).equalsIgnoreCase(getBtnString(block[1][i])) && getBtnString(block[1][i]).equalsIgnoreCase(getBtnString(block[2][i]))) {
                    if (getBtnString(block[0][i]).equalsIgnoreCase(getString(R.string.player_2_move))) {
                        result.setText(R.string.player_2_wins);
                    } else {
                        result.setText(R.string.player_1_wins);
                    }
                } else if ((getBtnString(block[i][0]).equals("O") || getBtnString(block[i][0]).equals("X")) && getBtnString(block[i][0]).equalsIgnoreCase(getBtnString(block[i][1])) && getBtnString(block[i][1]).equalsIgnoreCase(getBtnString(block[i][2]))) {
                    if (getBtnString(block[i][0]).equalsIgnoreCase(getString(R.string.player_1_move))) {
                        result.setText(R.string.player_1_wins);
                    } else {
                        result.setText(R.string.player_2_wins);
                    }
                } else if ((getBtnString(block[0][0]).equals("O") || getBtnString(block[0][0]).equals("X")) && getBtnString(block[0][0]).equals(getBtnString(block[1][1])) && getBtnString(block[1][1]).equals(getBtnString(block[2][2]))) {
                    if (getBtnString(block[0][0]).equalsIgnoreCase(getString(R.string.player_1_move))) {
                        result.setText(R.string.player_1_wins);
                    } else {
                        result.setText(R.string.player_2_wins);
                    }

                } else if ((getBtnString(block[2][0]).equals("O") || getBtnString(block[2][0]).equals("X")) && getBtnString(block[2][0]).equals(getBtnString(block[1][1])) && getBtnString(block[1][1]).equals(getBtnString(block[0][2]))) {
                    if (getBtnString(block[2][0]).equalsIgnoreCase(getString(R.string.player_1_move))) {
                        result.setText(R.string.player_1_wins);
                    } else {
                        result.setText(R.string.player_2_wins);
                    }
                }
            }
        }

}
