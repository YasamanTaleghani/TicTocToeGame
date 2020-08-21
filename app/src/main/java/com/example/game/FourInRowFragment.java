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
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class FourInRowFragment extends Fragment {

    public static final String BUNDLE_PLAYERS_TURN = "BundlePlayersTurn";
    public static final String BUNDLE_IS_PLAYED = "BundleIsPlayed";
    public static final String BUNDLE_ISPLAYED = "BundleIsplayed";
    public static final String BUNDLE_PLAYERSTURN = "BundlePlayersturn";
    private Button[] mButtons = new Button[25];
    private Button mButtonSetting;
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

        if (savedInstanceState!=null){
            playersTurn = savedInstanceState.getInt(BUNDLE_PLAYERSTURN);
            IsPlayed = savedInstanceState.getIntArray(BUNDLE_ISPLAYED);
            for (int i = 0; i < 25 ; i++) {
                if (IsPlayed[i]==0) {
                    mButtons[i].setBackgroundColor(Color.RED);
                    mButtons[i].setEnabled(false);
                } else if (IsPlayed[i]==1){
                    mButtons[i].setBackgroundColor(Color.BLUE);
                    mButtons[i].setEnabled(false);
                }
            }
        }
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

        mButtonSetting = view.findViewById(R.id.btn_setting);
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

                        IsPlayed[finalI] = playersTurn % 2;
                        playersTurn++;
                        mButtons[finalI].setEnabled(false);
                        isGameOver();

                    }
                }
            });
        }

        mButtonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Todo
            }
        });

    }

    private void isGameOver(){

        int[] check = new int[]{IsPlayed[0]+IsPlayed[1]+IsPlayed[2]+IsPlayed[3],
                                IsPlayed[1]+IsPlayed[2]+IsPlayed[3]+IsPlayed[4],
                                IsPlayed[5]+IsPlayed[6]+IsPlayed[7]+IsPlayed[8],
                                IsPlayed[6]+IsPlayed[7]+IsPlayed[8]+IsPlayed[9],
                                IsPlayed[10]+IsPlayed[11]+IsPlayed[12]+IsPlayed[13],
                                IsPlayed[11]+IsPlayed[12]+ IsPlayed[13]+IsPlayed[14],
                                IsPlayed[15]+IsPlayed[16]+ IsPlayed[17]+IsPlayed[18],
                                IsPlayed[16]+IsPlayed[17]+IsPlayed[18]+IsPlayed[19],
                                IsPlayed[20]+IsPlayed[21]+IsPlayed[22]+IsPlayed[23],
                                IsPlayed[21]+IsPlayed[22]+IsPlayed[23]+IsPlayed[24],
                                IsPlayed[0]+IsPlayed[5]+IsPlayed[10]+IsPlayed[15],
                                IsPlayed[5]+IsPlayed[10]+IsPlayed[15]+IsPlayed[20],
                                IsPlayed[1]+IsPlayed[6]+IsPlayed[11]+IsPlayed[16],
                                IsPlayed[6]+IsPlayed[11]+IsPlayed[16]+IsPlayed[21],
                                IsPlayed[2]+IsPlayed[7]+IsPlayed[12]+IsPlayed[17],
                                IsPlayed[7]+IsPlayed[12]+IsPlayed[17]+IsPlayed[22],
                                IsPlayed[3]+IsPlayed[8]+IsPlayed[13]+IsPlayed[18],
                                IsPlayed[8]+IsPlayed[13]+IsPlayed[18]+IsPlayed[23],
                                IsPlayed[4]+IsPlayed[9]+IsPlayed[14]+IsPlayed[19],
                                IsPlayed[9]+IsPlayed[14]+IsPlayed[19]+IsPlayed[24],
                                IsPlayed[1]+IsPlayed[7]+IsPlayed[13]+IsPlayed[19],
                                IsPlayed[0]+IsPlayed[6]+IsPlayed[12]+IsPlayed[18],
                                IsPlayed[6]+IsPlayed[12]+IsPlayed[18]+IsPlayed[24],
                                IsPlayed[5]+IsPlayed[11]+IsPlayed[17]+IsPlayed[23],
                                IsPlayed[3]+IsPlayed[7]+IsPlayed[11]+IsPlayed[15],
                                IsPlayed[4]+IsPlayed[8]+IsPlayed[12]+IsPlayed[16],
                                IsPlayed[8]+IsPlayed[12]+IsPlayed[16]+IsPlayed[20],
                                IsPlayed[9]+IsPlayed[13]+IsPlayed[17]+IsPlayed[21]};

        for (int i = 0; i < check.length ; i++) {
            if ( check[i] == 0 ){

                Snackbar.make(getActivity().findViewById(android.R.id.content)
                        ,"Player 1 wins", Snackbar.LENGTH_LONG).setActionTextColor(getResources
                        ().getColor(android.R.color.holo_green_light )).show();

                for (int j = 0; j < 25 ; j++) {
                    mButtons[j].setEnabled(false);
                }
                break;

            } else if ( check[i] == 1 ) {
                Snackbar.make(getActivity().findViewById(android.R.id.content)
                        ,"Player 1 wins", Snackbar.LENGTH_LONG).setActionTextColor(getResources
                        ().getColor(android.R.color.holo_green_light)).show();

                for (int j = 0; j < 25; j++) {
                    mButtons[j].setEnabled(false);
                }
                break;
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray(BUNDLE_ISPLAYED,IsPlayed);
        outState.putInt(BUNDLE_PLAYERSTURN,playersTurn);
    }
}