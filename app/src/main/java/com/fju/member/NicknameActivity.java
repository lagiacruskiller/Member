package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class NicknameActivity extends AppCompatActivity {
    ImageView arrow = findViewById(R.id.arrow);
    EditText nickname = findViewById(R.id.nickname);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);

        arrow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(TextUtils.isEmpty(nickname.getText())) {
                    new AlertDialog.Builder(NicknameActivity.this)
                            .setTitle("Empty Information")
                            .setMessage("Please input nickname info")
                            .show();
                }
                else{
                    String user = nickname.getEditableText().toString();
                    SharedPreferences pref = getSharedPreferences("name", MODE_PRIVATE);
                    pref.edit()
                            .putString("USER", user)
                            .commit();
                }
            }
        });


    }
}
