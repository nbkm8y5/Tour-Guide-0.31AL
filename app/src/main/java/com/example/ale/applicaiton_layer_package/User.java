package com.example.ale.applicaiton_layer_package;

import java.util.ArrayList;

/**
 *
 * @author adrianbureu
 */
public class User {

    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String emailAddress;


    /**
     * array of tour IDs that user has created
     */
    private ArrayList<Integer> userTours;

    /**
     * array of tour IDs that user has signed up for
     */
    private ArrayList<Integer> signedUpTours;


    /**
     * Constructor using username and password
     * @param un username
     * @param pw password
     */
    public void User(String un, String pw)
    {
        password = pw;
        userName = un;
    }

    /**
     * constructor using all ivars
     * @param un
     * @param pw
     * @param fn
     * @param ln
     * @param email
     */
    public void User(String un, String pw, String fn, String ln, String email)
    {
        userName = un;
        password = pw;
        firstName = fn;
        lastName = ln;
        emailAddress = email;
    }

    /**
     * Adds tour ID to list of signed up tours
     * @param id
     */
    public void signUptoTour(int id)
    {
        signedUpTours.add(id);
    }

    /**
     * Adds tourId to tour array
     * @param id
     */
    public void createTour(int id)
    {
        userTours.add(id);
    }




    // Getters

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public ArrayList<Integer> getUserTours() {
        return userTours;
    }

    public ArrayList<Integer> getSignedUpTours() {
        return signedUpTours;
    }


    //Setters

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setUserTours(ArrayList<Integer> userTours) {
        this.userTours = userTours;
    }

    public void setSignedUpTours(ArrayList<Integer> signedUpTours) {
        this.signedUpTours = signedUpTours;
    }
}