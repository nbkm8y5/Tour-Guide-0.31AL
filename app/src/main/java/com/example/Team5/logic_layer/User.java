package com.example.Team5.logic_layer;

import java.util.ArrayList;

/**
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
     *
     * @param un username
     * @param pw password
     */
    public void User(String un, String pw) {
        password = pw;
        userName = un;
    }

    /**
     * constructor using all ivars
     *
     * @param un
     * @param pw
     * @param fn
     * @param ln
     * @param email
     */
    public void User(String un, String pw, String fn, String ln, String email) {
        userName = un;
        password = pw;
        firstName = fn;
        lastName = ln;
        emailAddress = email;
    }

    /**
     * Adds tour ID to list of signed up tours
     *
     * @param id
     */
    public void signUptoTour(int id) {
        signedUpTours.add(id);
    }

    /**
     * Adds tourId to list of tours user has created
     *
     * @param id
     */
    public void createTour(int id) {
        userTours.add(id);
    }


    // Getters

    /**
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @return
     */
    public ArrayList<Integer> getUserTours() {
        return userTours;
    }

    /**
     * @return
     */
    public ArrayList<Integer> getSignedUpTours() {
        return signedUpTours;
    }


    //Setters

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @param userTours
     */
    public void setUserTours(ArrayList<Integer> userTours) {
        this.userTours = userTours;
    }

    /**
     * @param signedUpTours
     */
    public void setSignedUpTours(ArrayList<Integer> signedUpTours) {
        this.signedUpTours = signedUpTours;
    }
}
