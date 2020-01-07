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

public class GenderActivity extends AppCompatActivity {
    ImageView done = findViewById(R.id.done);
    EditText genderbox = findViewById(R.id.gender);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);

        done.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(TextUtils.isEmpty(genderbox.getText())) {
                    new AlertDialog.Builder(GenderActivity.this)
                            .setTitle("Empty Information")
                            .setMessage("Please input gender info")
                            .show();
                }
                else{
                    if(genderbox.getEditableText().toString() == "male"){
                        String gender = genderbox.getEditableText().toString();
                        SharedPreferences pref = getSharedPreferences("gender", MODE_PRIVATE);
                        pref.edit()
                                .putString("GENDER", gender)
                                .commit();
                        startActivity(new Intent(GenderActivity.this, AgeActivity.class));
                    }
                    else if(genderbox.getEditableText().toString() == "female"){
                        String gender = genderbox.getEditableText().toString();
                        SharedPreferences pref = getSharedPreferences("gender", MODE_PRIVATE);
                        pref.edit()
                                .putString("GENDER", gender)
                                .commit();
                        startActivity(new Intent(GenderActivity.this, AgeActivity.class));
                    }
                    else{
                        new AlertDialog.Builder(GenderActivity.this)
                                .setTitle("Invaild Information")
                                .setMessage("Please input correct gender info")
                                .show();
                    }
                }
            }
        });


    }
}
