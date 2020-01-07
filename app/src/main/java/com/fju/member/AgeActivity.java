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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);

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
                    new Intent(AgeActivity.this, NicknameActivity.class);
                }
            }
        });
    }
}
