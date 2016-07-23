package presentation_layer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ale.test_layer.R;

/**
 * Developed by Camilo on 7/21/2016
 */
public class Create_Tour extends Activity {

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_tour);

        EditText tourNameInput;
        EditText tourDescInput;
        EditText cityInput;
        EditText stateInput;
        EditText zipcodeInput;
        EditText dateInput;
        EditText address1Input;
        EditText address2Input;
        EditText timeInput;

        Button homeButton = (Button) (findViewById(R.id.homeButton));
        Button createTourbutton = (Button) (findViewById(R.id.createTourButton));

        tourNameInput = (EditText) (findViewById(R.id.tourName));
        tourDescInput = (EditText) (findViewById(R.id.tourDesc));
        cityInput = (EditText) (findViewById(R.id.city));
        stateInput = (EditText) (findViewById(R.id.state));
        zipcodeInput = (EditText) (findViewById(R.id.zipcode));
        address1Input = (EditText) (findViewById(R.id.address1));
        address2Input = (EditText) (findViewById(R.id.address2));
        timeInput = (EditText) (findViewById(R.id.time));


        createTourbutton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {

                    }
                }
        );

        homeButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        goToLanding();
                    }
                }
        );


    }

    /**
     *
     */
    private void goToLanding() {

        Intent landingPage = new Intent(this, Landing_Page.class);
        startActivity(landingPage);
    }
}
