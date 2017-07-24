package com.example.android.crudphpmysql;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuLogout:
                SharedPreferencesManager.getInstance(this).logout();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.menuSeting:
                Toast.makeText(this,"You clicked settings",Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }
}
