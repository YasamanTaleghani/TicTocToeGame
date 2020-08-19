package com.example.game;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.snackbar.Snackbar;

public class FourInRowFragment extends Fragment {

    public static final String BUNDLE_PLAYERS_TURN = "BundlePlayersTurn";
    public static final String BUNDLE_IS_PLAYED = "BundleIsPlayed";
    private Button[] mButtons = new Button[25];
    private int[] IsPlayed = {5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 ,
                              5 , 5 , 5 , 5 , 5 , 5 , 5 , 5};
    private int playersTurn = 0;

    public FourInRowFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_four_in_row,container,false);
        findView(view);
        setListers();
        return view;

    }

    private void findView(View view){

        mButtons = new Button[]{view.findViewById(R.id.btn0),
                view.findViewById(R.id.btn1), view.findViewById(R.id.btn2),
                view.findViewById(R.id.btn3), view.findViewById(R.id.btn4),
                view.findViewById(R.id.btn5), view.findViewById(R.id.btn6),
                view.findViewById(R.id.btn7), view.findViewById(R.id.btn8),
                view.findViewById(R.id.btn9), view.findViewById(R.id.btn10),
                view.findViewById(R.id.btn11), view.findViewById(R.id.btn12),
                view.findViewById(R.id.btn13), view.findViewById(R.id.btn14),
                view.findViewById(R.id.btn15), view.findViewById(R.id.btn16),
                view.findViewById(R.id.btn17), view.findViewById(R.id.btn18),
                view.findViewById(R.id.btn19), view.findViewById(R.id.btn20),
                view.findViewById(R.id.btn21), view.findViewById(R.id.btn22),
                view.findViewById(R.id.btn23), view.findViewById(R.id.btn24)};

    }

    private void setListers(){

        for (int i = 0; i < 25 ; i++) {
            final int finalI = i;
            mButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mButtons[finalI].isEnabled()){

                        if (playersTurn%2==0){
                            mButtons[finalI].setBackgroundColor(Color.RED);
                        } else {
                            mButtons[finalI].setBackgroundColor(Color.BLUE);
                        }

                        IsPlayed[finalI] = playersTurn%2;
                        playersTurn++;
                        mButtons[finalI].setEnabled(false);
                        isGameOver();

                    }
                }
            });
        }
    }

    private void isGameOver(){

        for (int i = 0; i < 25 ; i++) {
            if ( (i+3) < 5 && IsPlayed[i]+IsPlayed[i+1]+IsPlayed[i+2]+IsPlayed[i+3] == 4 ||
                 (i+15) < 25 && IsPlayed[i]+IsPlayed[i+5]+IsPlayed[i+10]+IsPlayed[i+15] == 4){
                Snackbar.make(getActivity().findViewById(android.R.id.content),"Player 2 wins",
                        Snackbar.LENGTH_LONG).setActionTextColor(getResources().
                        getColor(android.R.color.holo_green_light )).show();

                for (int j = 0; j < 25 ; i++) {
                    mButtons[j].setEnabled(false);
                }

            } else if ((i+3) < 5 && IsPlayed[i]+IsPlayed[i+1]+IsPlayed[i+2]+IsPlayed[i+3] == 0 ||
                    (i+15) < 25 && IsPlayed[i]+IsPlayed[i+5]+IsPlayed[i+10]+IsPlayed[i+15] == 0) {
                Snackbar.make(getActivity().findViewById(android.R.id.content),"Player 1 wins",
                        Snackbar.LENGTH_LONG).setActionTextColor(getResources().
                        getColor(android.R.color.holo_green_light)).show();

                for (int j = 0; j < 25; i++) {
                    mButtons[j].setEnabled(false);
                }

            }
        }
    }


}