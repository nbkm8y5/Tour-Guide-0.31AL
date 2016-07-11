package client_layer_package;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.ale.applicaiton_layer_package.R;

import java.util.concurrent.ExecutionException;

import database_layer_package.databaseConnection;

/**
 * Created by Ale on 7/10/2016.
 */
public class LogIn_Page extends Activity {


    EditText username;
    EditText password;

    /**
     *  If successfully logged in it will redirect to another interface, otherwise display
     * a message
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
