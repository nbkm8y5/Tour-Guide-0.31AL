package presentation_layer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ale.test_layer.R;
import com.example.Team5.logic_layer.appController;


/**
 * Created by Andy. README!!!
 * This class is now fully implemented. DO NOT CHANGE.
 * <p/>
 * IMPORTANT:
 * If you are going to call an appController method that doesn't require to do a database query you do not need
 * to create a new thread. Otherwise android will complaint that you are trying to do it from the main thread.
 * <p/>
 * For a better understanding look at loginButton.setOnClickListener on this class (the login method in appController makes use of database queries)
 * and confirmButton.setOnClickListener in the VerificationActivity class. (verify code method in appController doesn't access data access layer).
 * <p/>
 * Also try to understand how you can start and finish activities correctly for better control flow. For a better understanding look at
 * backToLogin() method in VerificationActivity class.
 */
public class LoginPage extends Activity {
    EditText username;
    EditText password;
    Context context;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        Button loginButton = (Button) (findViewById(R.id.button2));
        Button signupButton = (Button) (findViewById(R.id.signupButt));

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gets info from the text boxes:
                username = (EditText) findViewById(R.id.username);
                password = (EditText) findViewById(R.id.password);
                context = getApplicationContext();
                //why a new thread? Android would crash when you get to DatabaseRead and try to get the connection from DatabaseConnection and executeQuery
                //This exception is thrown when an application attempts to perform a networking operation on its main thread.
                //For more info: http://android-developers.blogspot.in/2009/05/painless-threading.html. Andy
                new Thread(new Runnable() {
                    public void run() {
                        if (appController.login(username.getText().toString(), password.getText().toString()))
                            goToLanding();
                        else
                            fail();
                    }
                }).start();

            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        goToSignUp();
                    }
                }).start();
            }
        });
    }

    /**
     *
     */
    private void goToLanding() {
        /*Notice the use of intent here. This allows you to initialize the java class that is one of your activities.
        /That class which extends activity will then proceed to set its respective ContentView. Note you need to include each java class
        /that you will use as an activity in the AndroidManifest.xml.*/
        Intent landingPage = new Intent(this, Landing_Page.class);
        startActivity(landingPage); //this fires up your activity
    }

    /**
     *
     */
    private void goToSignUp() {
        Intent signupPage = new Intent(this, SignUp_Page.class);
        startActivity(signupPage); //this fires up your activity
    }

    /**
     *
     */
    private void fail() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (username.getText().toString().length() == 0 || password.getText().toString().length() == 0) {
                    Toast.makeText(context, "All fields must be filled", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(context, "Incorrect Username or Password", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
