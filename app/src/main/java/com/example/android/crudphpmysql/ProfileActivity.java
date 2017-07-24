package com.example.android.crudphpmysql;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView textViewUsername, textViewUserEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        if (!SharedPreferencesManager.getInstance(this).isLoggedin()){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        textViewUsername=(TextView) findViewById(R.id.tV_Username);
        textViewUserEmail=(TextView) findViewById(R.id.tV_UserEmail);

        textViewUsername.setText(SharedPreferencesManager.getInstance(this).getUsername());
        textViewUserEmail.setText(SharedPreferencesManager.getInstance(this).getUserEmail());

    }
}
