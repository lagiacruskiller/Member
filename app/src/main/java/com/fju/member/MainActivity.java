package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView arrow;
    TextView namebox, age, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
        arrow.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                String userid = getSharedPreferences("name", MODE_PRIVATE)
                        .getString("USER", "");
                int ageid = Integer.parseInt(getSharedPreferences("age", MODE_PRIVATE)
                        .getString("AGE", ""));
                String genderid = getSharedPreferences("gender", MODE_PRIVATE)
                        .getString("GENDER", "");
                namebox.setText(userid);
                age.setText(ageid);
                gender.setText(genderid);

                if(TextUtils.isEmpty(namebox.getText())) {
                    startActivity(new Intent(MainActivity.this, NicknameActivity.class));
                }
                else{
                    namebox.setText(userid);
                    age.setText(ageid);
                    gender.setText(genderid);
                }
            }
        });
    }

    public void findviews(){
        arrow = findViewById(R.id.arrow);
        namebox = findViewById(R.id.namebox);
        age = findViewById(R.id.agebox);
        gender = findViewById(R.id.genderbox);
    }
}
