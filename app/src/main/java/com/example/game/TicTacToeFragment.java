package com.example.game;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.snackbar.Snackbar;


public class TicTacToeFragment extends Fragment {

    private ImageButton[] mImageButtons = new ImageButton[9];
    private int[] IsPlayed = {5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5};
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
            final int finalI1 = i;
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
                        isGameOver();

                    }
                }
            });
        }
    }

    private void isGameOver(){
        boolean result = false;

        if (IsPlayed[0]+IsPlayed[1]+IsPlayed[2] == 3 || IsPlayed[3]+IsPlayed[4]+IsPlayed[5] == 3
        || IsPlayed[6]+IsPlayed[7]+IsPlayed[8] == 3 || IsPlayed[0]+IsPlayed[3]+IsPlayed[6] == 3 ||
        IsPlayed[1]+IsPlayed[4]+IsPlayed[7] == 3 || IsPlayed[2]+IsPlayed[5]+IsPlayed[8] == 3 ||
        IsPlayed[0]+IsPlayed[4]+IsPlayed[8] == 3 || IsPlayed[2]+IsPlayed[4]+IsPlayed[8] == 3){
            Snackbar.make(getActivity().findViewById(android.R.id.content), "Player 2 wins",
                    Snackbar.LENGTH_LONG).setActionTextColor(getResources().
                    getColor(android.R.color.holo_green_light )).show();

            for (int i = 0; i < 9 ; i++) {
                mImageButtons[i].setEnabled(false);
            }
        } else if (IsPlayed[0]+IsPlayed[1]+IsPlayed[2] == 0 ||
                IsPlayed[3]+IsPlayed[4]+IsPlayed[5] == 0
                || IsPlayed[6]+IsPlayed[7]+IsPlayed[8] == 0 ||
                IsPlayed[0]+IsPlayed[3]+IsPlayed[6] == 0 ||
                IsPlayed[1]+IsPlayed[4]+IsPlayed[7] == 0 ||
                IsPlayed[2]+IsPlayed[5]+IsPlayed[8] == 0 ||
                IsPlayed[0]+IsPlayed[4]+IsPlayed[8] == 0 ||
                IsPlayed[2]+IsPlayed[4]+IsPlayed[8] == 0) {
            Snackbar.make(getActivity().findViewById(android.R.id.content), "Player 1 wins",
                    Snackbar.LENGTH_LONG).setActionTextColor(getResources().
                    getColor(android.R.color.holo_green_light )).show();

            for (int i = 0; i < 9 ; i++) {
                mImageButtons[i].setEnabled(false);
            }
        }

    }

}