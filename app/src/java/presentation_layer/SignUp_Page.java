package presentation_layer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ale.test_layer.R;
import com.example.Team5.logic_layer.appController;

/**
 * Created by Andy.
 * This class is fully implemented. DO NOT CHANGE.
 */
public class SignUp_Page extends Activity {
    EditText username;
    EditText password;
    EditText email;
    Context context;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        Button signupButton = (Button)(findViewById(R.id.signupButton));

        username = (EditText) findViewById(R.id.signupUsername);
        password = (EditText) findViewById(R.id.signupPassword);
        email = (EditText) findViewById(R.id.signupEmail);


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gets info from the text boxes:
                    new Thread(new Runnable() {
                        public void run() {
                            context = getApplicationContext();
                            if (appController.verifySignup(username.getText().toString(),
                                    password.getText().toString(),email.getText().toString())) {
                                goToVerificationPage();
                            }
                            else
                               fail();
                        }
                    }).start();

            }
        });
    }

    /**
     *
     */
    private void goToVerificationPage(){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(context, "A confirmation code has been sent to: " + email.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

        Intent verificationPage = new Intent(this, VerificationActivity.class);
        startActivity(verificationPage); //this fires up your activity
    }

    /**
     *
     */
    private void fail() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (username.getText().toString().length() == 0 || password.getText().toString().length() == 0
                        || email.getText().toString().length() == 0) {
                    Toast.makeText(context, "All fields must be filled", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(context, "An account with email " + email.getText().toString() + " already exists.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
