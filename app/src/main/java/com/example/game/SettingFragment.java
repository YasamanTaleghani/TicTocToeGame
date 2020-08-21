package com.example.game;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class SettingFragment extends Fragment {

    private EditText mPlayer1;
    private EditText mPlayer2;
    private Button mButtonSave;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting,container,false);
        findView(view);
        setListeners();
        return view;
    }

    private void findView(View view){
        mPlayer1 = view.findViewById(R.id.editText_player1);
        mPlayer2 = view.findViewById(R.id.editText_player2);
        mButtonSave = view.findViewById(R.id.btn_save);
    }

    private void setListeners(){
        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String p1 = mPlayer1.getText().toString();
                final String p2 = mPlayer2.getText().toString();
            }
        });
    }
}