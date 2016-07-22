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
 * Created by SpeedGrapher on 7/17/2016.
 * Class is fully implemented. DO NOT CHANGE.
 */
public class VerificationActivity extends Activity {
    EditText email;
    EditText code;
    Context context;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_verification);
        Button confirmButton = (Button) (findViewById(R.id.confirmCodeButton));
        code = (EditText) findViewById(R.id.codeField);
        email = (EditText) findViewById(R.id.verificationEmailField);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context = getApplicationContext();
                if (appController.verifyCode(email.getText().toString(), code.getText().toString())) {
                    Toast.makeText(context, "Account was succesfully created", Toast.LENGTH_LONG).show();
                    //adds the user into the database:
                    appController.createNewUser();
                    backToLogin();
                }
                else
                    Toast.makeText(context, "Don't be such a choripan and input the right stuff", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     *
     */
    private void backToLogin() {
        Intent loginpage = new Intent(this, LoginPage.class);
        //Note the flag inclusion. This means the new instance of loginpage is not added to the activity stack.
        //Use this for redirection if the activity you wish to go back to is more than one activities away on the stack.
        //Otherwise use finish(), since this finishes the current one and takes you back to previous activity.
        loginpage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(loginpage);
    }
}
