package com.fju.member;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class AgeActivity extends AppCompatActivity {
    ImageView arrow = findViewById(R.id.arrow);
    EditText agebox = findViewById(R.id.age);
    String userid;
    int ageid;
    String genderid;
    String agestring = Integer.toString(ageid);
    MainActivity main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);
        main.getInfo();
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(agebox.getText())) {
                    new AlertDialog.Builder(AgeActivity.this)
                            .setTitle("Empty Information")
                            .setMessage("Please input age info")
                            .show();
                } else {
                    String age = agebox.getEditableText().toString();
                    SharedPreferences pref = getSharedPreferences("age", MODE_PRIVATE);
                    pref.edit()
                            .putString("AGE", age)
                            .commit();
                    if(TextUtils.isEmpty(agestring))
                        startActivity(new Intent(AgeActivity.this, GenderActivity.class));
                    else
                        startActivity(new Intent(AgeActivity.this, NicknameActivity.class));
                }
            }
        });
    }
}
