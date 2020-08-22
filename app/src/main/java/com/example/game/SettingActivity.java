package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SettingActivity extends AppCompatActivity {

    public static final String PLAYER_1_NAME = "Player1Name";
    public static final String PLAYER_2_NAME = "Player2Name";
    private EditText mPlayer1;
    private EditText mPlayer2;
    private Button mButtonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        findView();
        setListeners();
        Intent intent = getIntent();
    }

    private void findView(){
        mPlayer1 = findViewById(R.id.editText_player1);
        mPlayer2 = findViewById(R.id.editText_player2);
        mButtonSave = findViewById(R.id.btn_save);
    }

    private void setListeners(){
        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setShownAnswerResult();
            }
        });
    }

    private void setShownAnswerResult(){
        Intent intent = new Intent();
        intent.putExtra(PLAYER_1_NAME,mPlayer1.getText().toString());
        intent.putExtra(PLAYER_2_NAME,mPlayer2.getText().toString());
        setResult(RESULT_OK, intent);
        finish();
    }
}