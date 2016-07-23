package presentation_layer;

import android.app.Activity;
import android.os.Bundle;

import com.example.Team5.logic_layer.appController;
import com.example.ale.test_layer.R;

import android.view.View;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;


/**
 * Created by Adrian Bureu - 7/23/2016
 */
public class Browse_Tours extends Activity {

    private static ArrayList<Object> tourArray; // array of tour data from db (name and description)
    private static ArrayList<String> formattedTourArray; //formatted tour data to be displayed

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_tours); //setup


        Button homeButton = (Button) findViewById(R.id.homeButton); // UI elements
        View listOfTours = (View) findViewById(R.id.listOfTours);


        new Thread(new Runnable() { // populate the tours array, new thread since it queries db
            public void run() {

//                IS THIS THE CORRECT NAME OF THE STATIC METHOD IN APPCONTROLLER?
                tourArray = appController.displayAllTours();
                formattedTourArray = new ArrayList<String>();

                for (int i = 0; i < tourArray.size(); i++) {
                    formattedTourArray.add(tourArray.get(i).toString() + " -- " + tourArray.get(++i).toString());
                }

                populateListView();
            }

        }).start();


        homeButton.setOnClickListener(new View.OnClickListener() { // home button
            public void onClick(View v) {
                goToHome();
            }
        });

    }

    /**
     *
     */
    private void populateListView() { // setup the listView with tour info

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.tour_item, formattedTourArray);

        ListView listOfTours = (ListView) findViewById(R.id.listOfTours);

        listOfTours.setAdapter(adapter);
    }


    /**
     *
     */
    private void goToHome() {
        finish();
    }

}