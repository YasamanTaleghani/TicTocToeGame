package com.example.game;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class TicTacToeFragment extends Fragment {

    private ImageButton[] mImageButtons = new ImageButton[9];
    private int[] IsPlayed = new int[9];
    private int playersTurn = 0;

    public TicTacToeFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tic_tac_toe,container,false);
        findView(view);
        setListers();
        return view;
    }

    private void findView(View view){

        mImageButtons = new ImageButton[]{view.findViewById(R.id.btn1), view.findViewById(R.id.btn2) ,
                                view.findViewById(R.id.btn3), view.findViewById(R.id.btn4) ,
                                view.findViewById(R.id.btn5), view.findViewById(R.id.btn6) ,
                                view.findViewById(R.id.btn7), view.findViewById(R.id.btn8) ,
                                view.findViewById(R.id.btn9)};

    }

    private void setListers(){

        for (int i = 0; i < 9 ; i++) {
            final int finalI = i;
            mImageButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mImageButtons[finalI].isEnabled()){

                        if (playersTurn%2==0){
                            mImageButtons[finalI].setBackgroundResource(R.drawable.cirle_icon);
                        } else {
                            mImageButtons[finalI].setBackgroundResource(R.drawable.close_icon);
                        }

                        IsPlayed[finalI] = playersTurn%2;
                        playersTurn++;
                        mImageButtons[finalI].setEnabled(false);
                    }
                }
            });
        }


    }

    private boolean isGameOver(){
        boolean result = false;

        //To do

        return result;
    }
}