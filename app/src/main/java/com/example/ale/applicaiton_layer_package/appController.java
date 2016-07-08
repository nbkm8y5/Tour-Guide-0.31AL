package com.example.ale.applicaiton_layer_package;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;

import database_layer_package.databaseConnection;

import java.util.concurrent.ExecutionException;


public class appController extends Activity {

    EditText username;
    EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

    }


    /**
     * If successfully logged in it will redirect to another interface, otherwise display
     * a message
     *
     * @param view
     */
    public void log_in_button(View view) {

        //gets info from the text boxes:
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);


        databaseConnection db = new databaseConnection();


        //for test purposes: db.execute("admin", "pass");
        db.execute(username.getText().toString(), password.getText().toString());

        try {
            if (db.get()) {
                Log.e("e@@@@@@@@@@@@", "sucessfully logged in!");
                this.setContentView(R.layout.place_holder);

            } else {
                Log.e("e@@@@@@@@@@@@", "error logging! - main log_in.java class");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }//end log_in_button


}
