package com.android.spcollege.checkexc;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.android.spcollege.checkexc.R.layout.fragment_session;

public class CheckActivity extends AppCompatActivity {
    ExerciseBaseHelper mExercisebaseHelper;

    private EditText fullName, address, height, weight;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        fullName = (EditText)findViewById(R.id.full_name);
        address = (EditText)findViewById(R.id.address);
        height = (EditText)findViewById(R.id.height);
        weight = (EditText)findViewById(R.id.weight);
        btnSave = (Button)findViewById(R.id.save_button);
        mExercisebaseHelper = new ExerciseBaseHelper(this);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtFullname = fullName.getText().toString();
                String txtAddress = address.getText().toString();
                String txtHeight = height.getText().toString();
                String txtWeight = weight.getText().toString();
/*                if (txtFullname.length() !=0 | txtAddress.length()!=0 | txtHeight.length() != 0 |
                        txtWeight.length() !=0) {
                    AddData(txtFullname);
                    AddData(txtAddress);
                    AddData(txtHeight);
                    AddData(txtWeight);

                } else {
                    toastMessage("Please put something in the text field");
                }*/
                if(txtFullname.length() ==0 | txtAddress.length()==0 | txtHeight.length() == 0 |
                        txtWeight.length() ==0) {
                    fullName.setText("");
                    address.setText("");
                    height.setText("");
                    weight.setText("");
                    toastMessage("Please put something in the text field");
                }

                if (mExercisebaseHelper.createCustomer(txtFullname,txtAddress,txtHeight,txtWeight) != -1){
                    toastMessage("Successful");
                }
            }
        });
    }

/*    public void AddData(String newEntry){
        boolean insertData = mExercisebaseHelper.createCustomer(newEntry);
        if (insertData) {
            toastMessage("Successful");
        }else {
            toastMessage("Unsuccessful. Please Check Again");
        }
    }*/
    //Toast Message
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
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
        } if (id == R.id.add_customer){
            startActivity(new Intent(CheckActivity.this, ListDataActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }



}

