package com.example.ale.applicaiton_layer_package;

import android.app.Activity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import database_layer_package.DatabaseRead;
import database_layer_package.DatabaseUpdate;
import database_layer_package.databaseConnection;

/**
 * Created by SpeedGrapher on 7/16/2016.
 */
public class appController  {
    static databaseConnection db; //this needs to be static for singleton pattern. Andy
    private static DatabaseRead databaseRead;
    private DatabaseUpdate databaseUpdate;
    private User user;

    static ArrayList <Object> tour = new ArrayList<>(); //datastructure for the query returning a tour by id. Andy
    static ArrayList <Integer> follow = new ArrayList<>(); //data structure for User_Follow_Tours. Andy

    public static boolean connect(String userName, String password) {
        //input validation for a bug that allowed you to access landing page by entering two blank inputs for user and pw.
        if (userName.length() == 0 && password.length() == 0) {
            System.out.println("Why you always lying?");
            return false;
        }
        db = db.getInstance(); //gets the singleton instance. Andy

        //for test purposes: db.execute("admin", "pass");
        db.doInBackground(userName, password);
        if (checkAccount(userName, password)) {
            Log.e("e@@@@@@@@@@@@", "sucessfully logged in!");

            //This here was to test my queries.
            String firstName = databaseRead.getFirstName(userName);
            String lastName = databaseRead.getLastName(userName);
            //String email = databaseRead.getEmail(userName); //need a column in user table for this.
            tour = databaseRead.getTourById(1); //this is a hardcoded value just for test purposes.
            follow = databaseRead.userFollowTours(databaseRead.getUserId(userName));

            //Check console for debugging purposes.
            System.out.println("Username: " + userName);
            System.out.println("FirstName: " + firstName);
            System.out.println("LastName: " + lastName);

            for (int i = 0; i < tour.size(); i++)
                System.out.println("Tour ID = " + 1 + " contains: " + tour.get(i));

            for (int i = 0; i < follow.size(); i++)
                System.out.println(userName + " is following: " + follow.get(i));

            return true;
        } else
            Log.e("e@@@@@@@@@@@@", "error logging! - main log_in.java class");
        return false;
    }
    //authenticate method. gets the password from the given username using databaseRead and checks
    //if its the same as the one given by the user.
    private static boolean checkAccount(String username, String password) {
        databaseRead = new DatabaseRead();
        return databaseRead.getPassword(username).equals(password);
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
    public static void disconnect() {
        db.disconnect();
    }

}
