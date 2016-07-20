package presentation_layer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ale.test_layer.R;
import com.example.Team5.logic_layer.appController;

/**
 * Created by Andy
 */
public class Landing_Page extends Activity {

    /**
     *
     * @param savedInstanceState
     */
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
                logoutRedirect();
            }
        });

    }
    /*
    Android activities are stored in the activity stack.
    Since we called this activity (which is LandingPage) using finish function takes you back to the previous activity which is login.
    If you need to go back to a specific activity then use finishActivity() method.
     */
    //TODO
    private void logoutRedirect() {
        finish();
    }
}

