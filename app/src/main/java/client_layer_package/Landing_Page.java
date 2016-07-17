package client_layer_package;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ale.applicaiton_layer_package.R;
import com.example.ale.applicaiton_layer_package.appController;

/**
 * Created by Andy
 */
public class Landing_Page extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("YAY!!!!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing);
        Button logoutButton = (Button) (findViewById(R.id.logoutButton));

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appController.disconnect();
                System.out.println("Succesfully disconnected");
                logoutRedirect();
            }
        });

    }
    /*
    Android activities are stored in the activity stack.
    Since we called this activity (which is LandingPage) using finish function takes you back to the previous activity which is login.
    If you need to go back to a specific activity then use finishActivity() method.
     */
    private void logoutRedirect() {
        finish();
    }
}

