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
    String userid;
    int ageid;
    String genderid;

    ImageView arrow;
    TextView namebox, agebox, genderbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        findviews();
        arrow.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                getInfo();
                namebox.setText(userid);
                agebox.setText(ageid);
                genderbox.setText(genderid);

                if(TextUtils.isEmpty(namebox.getText())) {
                    startActivity(new Intent(MainActivity.this, NicknameActivity.class));
                }
                else{
                    namebox.setText(userid);
                    agebox.setText(ageid);
                    genderbox.setText(genderid);
                }
            }
        });
    }

    public void findviews(){
        arrow = findViewById(R.id.arrow);
        namebox = findViewById(R.id.namebox);
        agebox = findViewById(R.id.agebox);
        genderbox = findViewById(R.id.genderbox);
    }
    public void getInfo(){
        String userid = getSharedPreferences("name", MODE_PRIVATE)
                .getString("USER", "");
        int ageid = Integer.parseInt(getSharedPreferences("age", MODE_PRIVATE)
                .getString("AGE", ""));
        String genderid = getSharedPreferences("gender", MODE_PRIVATE)
                .getString("GENDER", "");
    }
}
