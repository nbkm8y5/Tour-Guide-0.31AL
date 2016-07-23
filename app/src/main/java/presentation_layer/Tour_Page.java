package presentation_layer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.Team5.logic_layer.appController;
import com.example.ale.test_layer.R;

/**
 * Created by Ale on 7/10/2016.
 */
public class Tour_Page extends Activity {
    /**
     * TODO
     * Modified by: Rolando Moreno - 7/22/2016
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tour_details);
        Button signUpForTour = (Button) (findViewById(R.id.sign_up_for_tour_button));


        signUpForTour.setOnClickListener(new View.OnClickListener() {
            /**
             * TODO
             * @param v
             */
            public void onClick(View v) {
//                Sign up tourist to tour
                goToCreateTour();
            }
        });

    }


    /**
     * TODO
     * sends tour id to be paired with user id?  help alex
     */
    private void goToCreateTour() {
        Intent browseToursPage = new Intent(this, Browse_Tours.class);
        startActivity(browseToursPage);
    }
}
