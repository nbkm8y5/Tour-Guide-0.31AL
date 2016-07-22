package presentation_layer;

import android.app.Activity;
import android.content.Intent;
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
     * Modified by: Kathryn Bello - 7/21/2016
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("YAY!!!!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing);
        Button logoutButton = (Button) (findViewById(R.id.logoutButton));
        Button createTourButton = (Button) findViewById(R.id.createTourButton);
        Button browseToursButton = (Button) findViewById(R.id.browseToursButton);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appController.disconnect();
                logoutRedirect();
            }
        });

        createTourButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToCreateTour();
            }
        });

        browseToursButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToBrowseTours();
            }
        });
    }


    /**
     * Android activities are stored in the activity stack.
     * Since we called this activity (which is LandingPage) using finish function takes you back to the previous activity which is login.
     * If you need to go back to a specific activity then use finishActivity() method.
     * TODO
     */
    private void logoutRedirect() {
        finish();
    }

    /**
     *
     */
    private void goToCreateTour() {
        Intent createTourPage = new Intent(this, Create_Tour.class);
        startActivity(createTourPage);
    }

    /**
     *
     */
    private void goToBrowseTours() {
        Intent browseToursPage = new Intent(this, Browse_Tours.class);
        startActivity(browseToursPage);
    }
}