package com.example.Team5.logic_layer;

import android.app.Activity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import data_access_layer.DatabaseRead;
import data_access_layer.DatabaseUpdate;
import data_access_layer.databaseConnection;

/**
 * Created by SpeedGrapher on 7/16/2016.
 * Note logic_layer and data_access_layer will now work with any IDE and not just on android.
 */
public class appController extends Activity {
    static databaseConnection db; //this needs to be static for singleton pattern. Andy
    private static DatabaseRead databaseRead = new DatabaseRead();
    private static CodeGenerator code = new CodeGenerator();
    private DatabaseUpdate databaseUpdate;
    private User user;

    private static String localUsername;
    private static String localPassword;
    private static String localEmail;
    private static String codeString;

    static ArrayList<Object> tour = new ArrayList<>(); //datastructure for the query returning a tour by id. Andy
    static ArrayList<Integer> follow = new ArrayList<>(); //data structure for User_Follow_Tours. Andy

    //Andy's methods begin here...
    //Login method. Fully functional. Only modify how you want to store the data you get from databaseRead.

    /**
     * @param userName
     * @param password
     * @return
     */
    public static boolean login(String userName, String password) {
        if (connect()) {
            //defensive programming
            if (userName.length() == 0 || password.length() == 0) {
                Log.e("Authentication Process", "Authentication Failed!");
                return false;
            }
            if (authenticate(userName, password)) {
                Log.e("Authentication Process", "Successfully logged in!");

                //This here was to test my queries.
                String firstName = databaseRead.getFirstName(userName);
                String lastName = databaseRead.getLastName(userName);
                String email = databaseRead.getEmail(userName); //need a column in user table for this.
                tour = databaseRead.getTourById(1); //this is a hardcoded value just for test purposes.
                follow = databaseRead.userFollowTours(databaseRead.getUserId(userName));

                //Check console for debugging purposes.
                System.out.println("Username: " + userName);
                System.out.println("FirstName: " + firstName);
                System.out.println("LastName: " + lastName);
                System.out.println("Email Address: " + email);
                for (int i = 0; i < tour.size(); i++)
                    System.out.println("Tour ID = " + 1 + " contains: " + tour.get(i));

                for (int i = 0; i < follow.size(); i++)
                    System.out.println(userName + " is following: " + follow.get(i));

                return true;
            } else {
                Log.e("Authentication Process", "Authentication Failed!");
            }
        }
        return false;
    }

    //authenticate method. gets the password for the given username using databaseRead and checks
    //if its the same as the one that the user initially input. DO NOT CHANGE.

    /**
     * @param username
     * @param password
     * @return
     */
    private static boolean authenticate(String username, String password) {
        return databaseRead.getPassword(username).equals(password);
    }

    /**
     * Method for signup process. DO NOT CHANGE. FULLY FUNCTIONAL.
     * This method verifies if the email given during signup already exists in the database.
     * If it does it will return false and warn the user that account cant be created.
     * If it doesn't, it will send a confirmation code to the given email.
     *
     * @param user     input that comes from signup activity in the interface
     * @param password input
     * @param email    input
     * @return true if email doesn't exist in the database so an account can be created, otherwise false.
     */
    public static boolean verifySignup(String user, String password, String email) {
        //if its connected to the server.
        if (connect()) {

            //defensive programming here.
            if (user.length() == 0 || password.length() == 0 || email.length() == 0) {
                Log.e("Signup Process", "Signup Failed");
                return false;
            }
            //if the given email doesn't exist in the database
            if (databaseRead.checkEmail(email)) {

                //saves input data for confirmation code process.
                localUsername = user;
                localPassword = password;
                localEmail = email;
                codeString = code.getCode();

                //sends code to given email.
                try {
                    GmailSender sender = new GmailSender();
                    sender.sendMail("Toury Authentication Code",
                            "Please enter this code in your app to confirm account creation: " + codeString,
                            "choripandeveloperteam@gmail.com",
                            email);
                } catch (Exception e) {
                    Log.e("SendMail", e.getMessage(), e);
                }
                return true;
            }
        }
        Log.e("Signup Process", "Signup Failed");
        return false;
    }

    /**
     * Verifies that the email and code the user inputs are the same
     * as the one used for the account creation in the signup screen. DO NOT CHANGE
     *
     * @param email input email (verification page)
     * @param code
     * @return true if given email and code were correct and account is created, otherwise false.
     */
    public static boolean verifyCode(String email, String code) {
        if (localEmail.equalsIgnoreCase(email) && code.equalsIgnoreCase(codeString)) {
            //here you do a database update with local user, pw and email to create an account.
            return true;
        }
        return false;
    }

    /**
     * Connects to the server (not database). DO NOT CHANGE
     *
     * @return true if connected or false if it failed to connect.
     */
    private static boolean connect() {
        db = db.getInstance();
        if (db.connect())
            return true;
        return false;
    }
    //Disconnects from the database. DO NOT CHANGE

    /**
     *
     */
    public static void disconnect() {
        db.disconnect();
    }
    //Andy's methods end here...


    /**
     * will return the info for the logged in user
     *
     * @return user
     */
    public User getUser() {
        return user;
    }


    /**
     * will create a new user in the database with the provided information
     *
     * @param password
     * @param userName
     * @param lastName
     * @param emailAddress
     */
    public void createNewUser(String password, String userName, String lastName, String emailAddress) {
//TODO
    }

    /**
     * will create a new tour in the database
     */
    public void createTour() {
//TODO
    }


    /**
     * will display the tours on the list provided
     *
     * @param view
     */
    public void displayTours(ListView view) {
//TODO
        /*depending on the user's  preferences it will load from the
        database the name , description and an image. (won't create objects )*/

    }


    /**
     * will return a specific tour with all the information
     *
     * @return tour
     */
    public Tour LoadTour() {
//TODO
    /*check if the user is the same that created the tour,
    if it is then show a end button & start */
        return null;

    }


    /**
     * will sign up the given user to the given tour (by IDs)
     *
     * @param user_ID
     * @param tour_ID
     */
    public void Signup_To_Tour(int user_ID, int tour_ID) {
//TODO
        /*uses signup_user_to_tour on databaseUpdate class to sign up the user to the tour. */

    }


    /**
     * will remove the following tour from the database
     *
     * @param tour_ID
     */
    public void cancel_Tour(int tour_ID) {

//TODO
    }


    /**
     * with a given list of tour_Ids it will return an arrayList filled with Tour objects
     * with the corresponding IDs
     *
     * @param Tour_Ids
     * @return tours
     */
    public ArrayList display_Given_Tours(ArrayList Tour_Ids) {
//TODO
        return null;

    }


}
