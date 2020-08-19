package com.example.game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mButtonTicTocToe;
    private Button mButton4InaRow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListeners();
    }

    private void findViews(){
        mButtonTicTocToe = findViewById(R.id.btn_TicTocToe);
        mButton4InaRow = findViewById(R.id.btn_4InRow);
    }

    private void setListeners(){

        mButtonTicTocToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment fragment = fragmentManager.findFragmentById(R.id.Container);

                if (fragment == null) {
                    TicTacToeFragment ticTacToeFragment = new TicTacToeFragment();
                    fragmentManager.beginTransaction().add(R.id.Container, ticTacToeFragment).
                            commit();
                } else{
                    Fragment fragment1 = fragmentManager.findFragmentById(R.id.Container);
                    fragmentManager.beginTransaction().remove(fragment1).
                            commit();

                    TicTacToeFragment ticTacToeFragment = new TicTacToeFragment();
                    fragmentManager.beginTransaction().add(R.id.Container, ticTacToeFragment).
                            commit();
                }
            }
        });

        mButton4InaRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment fragment = fragmentManager.findFragmentById(R.id.Container);

                if (fragment == null) {
                    FourInRowFragment fourInRowFragment = new FourInRowFragment();
                    fragmentManager.beginTransaction().add(R.id.Container, fourInRowFragment).
                            commit();
                }else{
                    Fragment fragment1 = fragmentManager.findFragmentById(R.id.Container);
                    fragmentManager.beginTransaction().remove(fragment1).
                            commit();

                    FourInRowFragment fourInRowFragment = new FourInRowFragment();
                    fragmentManager.beginTransaction().add(R.id.Container, fourInRowFragment).
                            commit();
                }
            }
        });
    }
}