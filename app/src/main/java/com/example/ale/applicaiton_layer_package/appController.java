package com.example.ale.applicaiton_layer_package;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ListView;

import database_layer_package.DatabaseRead;
import database_layer_package.DatabaseUpdate;
import database_layer_package.databaseConnection;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


/**
 * This class controls the logic of the application, as well any code executed on launch.
 * alex 7/11/16
 */
public class appController extends Activity {


    private databaseConnection databaseConn;
    private DatabaseRead databaseRead;
    private DatabaseUpdate databaseUpdate;
    private User user;


    /**
     * on application launch this method will set the content view to the log in(main page)
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

    }

    /**
     * takes in a username and password and returns if they match to the database
     *
     *returns a boolean     *
     * @param userName
     * @param password
     */
    public boolean authenticate(String userName , String password){
    /*Will get an object of databaseConnection will call getUser and getPassword
    from Database Read and provide some logic against the parameters.*/

        return true;
    }


    /**
     * will return the info for the logged in user
     * @return user
     */
    public User getUser(){
        return user;
    }


    /**
     * will create a new user in the database with the provided information
     * @param password
     * @param userName
     * @param lastName
     * @param emailAddress
     */
    public void createNewUser(String password, String userName, String lastName, String emailAddress){

    }

    /**
     * will create a new tour in the database
     */
    public void createTour(){
        //logic here
    }


    /**
     * will display the tours on the list provided
     * @param view
     */
    public void displayTours(ListView view){

        /*depending on the user's  preferences it will load from the
        database the name , description and an image. (won't create objects )*/

    }


    /**
     * will return a specific tour with all the information
     * @return tour
     */
    public Tour LoadTour(){

    /*check if the user is the same that created the tour,
    if it is then show a end button & start */
        return null;

    }


    /**
     * will sign up the given user to the given tour (by IDs)
     * @param user_ID
     * @param tour_ID
     */
    public void Signup_To_Tour(int user_ID, int tour_ID){

        /*uses signup_user_to_tour on databaseUpdate class to sign up the user to the tour. */

    }


    /**
     * will remove the following tour from the database
     * @param tour_ID
     */
    public void cancel_Tour(int tour_ID){


    }


    /**
     * with a given list of tour_Ids it will return an arrayList filled with Tour objects
     * with the corresponding IDs
     * @param Tour_Ids
     * @return tours
     */
    public ArrayList display_Given_Tours(ArrayList Tour_Ids){

        return null;

    }


}
