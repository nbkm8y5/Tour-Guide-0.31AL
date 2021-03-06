package presentation_layer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ale.test_layer.R;
import com.example.Team5.logic_layer.appController;

/**
 * @author Andy
 */
public class Landing_Page extends Activity {

    /**
     * @param savedInstanceState
     * @ Modified by Kathryn Bello - 6/23/2016
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.landing);

        Button logoutButton = (Button) (findViewById(R.id.logoutButton));
        Button createToursButton = (Button) (findViewById(R.id.createToursButton));
        Button browseToursButton = (Button) (findViewById(R.id.browseToursButton));


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appController.disconnect();
                logoutRedirect();
            }
        });

        createToursButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        goCreateTours();
                    }
                }).start();

            }
        });

        browseToursButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    public void run() {
                        goBrowseTours();
                    }
                }).start();

            }
        });


    }
    /*
    Android activities are stored in the activity stack.
    Since we called this activity (which is LandingPage) using finish function takes you back to the previous activity which is login.
    If you need to go back to a specific activity then use finishActivity() method.
     */

    /**
     * @author Kathryn Bello - 6/23/2016
     */
    public void logoutRedirect() {
        Intent loginpage = new Intent(this, LoginPage.class);
        loginpage.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        loginpage.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(loginpage);
    }

    /**
     * @author Kathryn Bello - 6/23/2016
     */
    private void goCreateTours() {
        Intent createToursPage = new Intent(this, Create_Tour.class);
        startActivity(createToursPage); //this fires up your activity
    }

    /**
     * @author Kathryn Bello - 6/23/2016
     */
    private void goBrowseTours() {
        Intent browseToursPage = new Intent(this, Browse_Tours.class);
        startActivity(browseToursPage); //this fires up your activity
    }
}
