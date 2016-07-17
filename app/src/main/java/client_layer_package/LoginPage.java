package client_layer_package;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import com.example.ale.applicaiton_layer_package.R;
import com.example.ale.applicaiton_layer_package.appController;



/**
 * created by Andy
 * So after some reading it was obvious that it was not a good idea to have your appController fire up your activities.
 * WHY? Because your appController would need the onCreate method and esentially extend Activity making your java classes in the interface subsystem,
 * extremely dependable of a class that is part of the logic subsystem, hence defeating the whole purpose of having subsystems which is encapsulation.
 * So essentially any class that fires up an activity must be in the interface layer.
 * More info: https://developer.android.com/reference/android/app/Activity.
 *
 * What did i do?
 * I completely recreated the LogIn Page. (It was accessing the database subsystem directly, rather than going through appController).
 * I added the methods needed to connect to database and authenticate in appController.
 * I implemented the singleton pattern in DBConnection. added getConnection method which is needed by databaseRead and databaseUpdate for query executions.
 * I created the databaseRead with most of the queries needed to fetch information from the database. When you run the application look at the console to
 * see some test query outputs.
 * I created a mock landing page with the logout button implementation (see Landing_Page comments).
 * I tested it using two possible usernames: admin and a new one i created for myself. (user = andy, password = chori) Also added some input validation.
 * I tested some rainy day scenarios for authentication and everything seems to be working perfect on my end.
 *
 * Since android is a bitch for certain things because it is very thread reliant there might be cases in which the appController may return some variable
 * to the interface so an activity in the interface subsystem can do some programming by contract in order to start another activity.
 * 3-Tier architecture has many implementations and in some cases, such as for server sided application the appController does send some value back to the interface
 * for some small precondition statement, just like the database layer sends values it fetches from database back to logic for rule checking.
 *
 * If you think there is a better way of implementation feel free to do it your way. DatabaseConnection and DatabaseRead wouldn't change regardless.
 * Those are already fully implemented with the methods you need. Read method comments for better understanding.
 *
 * Add your own profile to database. Run program, test for correct authentication. Tell me what you think. Peace
 */
public class LoginPage extends Activity  {
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        Button loginButton = (Button)(findViewById(R.id.button2));

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //gets info from the text boxes:
                username = (EditText) findViewById(R.id.username);
                password = (EditText) findViewById(R.id.password);

                //why a new thread? Android would crash when you get to DatabaseRead and try to get the connection from DatabaseConnection and executeQuery
                //This exception is thrown when an application attempts to perform a networking operation on its main thread.
                //For more info: http://android-developers.blogspot.in/2009/05/painless-threading.html. Andy
                new Thread(new Runnable() {
                    public void run() {
                        if (appController.connect(username.getText().toString(), password.getText().toString()))
                            goToLanding();
                    }
                }).start();

            }
        });
    }
    private void goToLanding() {
        /*Notice the use of intent here. This allows you to initialize the java class that is one of your activities.
        /That class which extends activity will then proceed to set its respective ContentView. Note you need to include each java class
        /that you will use as an activity in the AndroidManifest.xml.*/
        Intent landingPage = new Intent(this, Landing_Page.class);
        startActivity(landingPage); //this fires up your activity
    }
}
