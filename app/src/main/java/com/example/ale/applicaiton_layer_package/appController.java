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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

    }




}
