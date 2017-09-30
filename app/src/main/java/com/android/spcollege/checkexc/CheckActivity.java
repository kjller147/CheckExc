package com.android.spcollege.checkexc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import static com.android.spcollege.checkexc.R.layout.fragment_session;

public class CheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.logout,m);
        return true;
    }
    //LogOff button
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_settings){
            startActivity(new Intent(CheckActivity.this, LoginActivity.class));
        } if (id == R.id.camera_setting) {
            startActivity(new Intent(this, CameraActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

}

