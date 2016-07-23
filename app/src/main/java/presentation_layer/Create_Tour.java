package presentation_layer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.Team5.logic_layer.Tour;
import com.example.Team5.logic_layer.appController;
import com.example.ale.test_layer.R;

/**
 * Developed by Camilo on 7/21/2016
 */
public class Create_Tour extends Activity {

    private EditText tourNameInput;
    private EditText tourDescInput;
    private EditText cityInput;
    private EditText stateInput;
    private EditText zipcodeInput;
    private EditText dateInput;
    private EditText address1Input;
    private EditText address2Input;
    private EditText timeInput;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_tour);

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
        dateInput = (EditText) (findViewById(R.id.date));


        createTourbutton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        createTour();
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


    /**
     * when createTour button is clicked:
     * helper method to create a tour and call a method in appcontroller to run the query.
     * last edit: Alex 7/23/16
     */
    public void createTour() {

        /*
        params for create a Tour object

                * @param name
                * @param desc
                * @param addr
                * @param apt
                * @param city
                * @param state
                * @param zip
                * @param date
                * @param time*/
        Tour temp = new Tour(tourNameInput.getText().toString(), tourDescInput.getText().toString()
                , address1Input.getText().toString(), address2Input.getText().toString(),
                cityInput.getText().toString(), stateInput.getText().toString(),
                zipcodeInput.getText().toString(), dateInput.getText().toString(),
                timeInput.getText().toString());

        appController.setCreatingTour(temp);//pass info to appcontroller
        appController.createTour();//this method will call query and perform the logic.
        goToLanding();

    }//end createTour
}
