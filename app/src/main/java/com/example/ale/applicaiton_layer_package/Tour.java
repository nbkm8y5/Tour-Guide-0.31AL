package com.example.ale.applicaiton_layer_package;

/**
 * A Tour class to represent a tour.
 * @author Kathryn Bello - 6/30/2016
 */
public class Tour {
    private int id;
    private String name;
    private String desc;
    private String city;
    private String state;
    private String date;
    private boolean full;
    
    /**
     * Creates a Tour object.
     * @author Kathryn Bello - 6/30/2016
     * @param id
     * @param name
     * @param desc
     * @param city
     * @param state
     * @param date 
     */
    public Tour(int id, String name, String desc, String city, String state, String date) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.city = city;
        this.state = state;
        this.date = date;
        this.full = false;
    }
    
    // getter methods

    /**
     * Gets the id number for this tour.
     * @author Kathryn Bello - 6/30/2016
     * @return id
     */
    public int getID() {
        return id;
    }

    /**
     * Gets the tour name.
     * @author Kathryn Bello - 6/30/2016
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description for this tour.
     * @return description
     */
    public String getDescription() {
        return desc;
    }

    /**
     * Gets the city for this tour.
     * @author Kathryn Bello - 6/30/2016
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets the state for this tour.
     * @author Kathryn Bello - 6/30/2016
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Gets the date for this tour.
     * @author Kathryn Bello - 6/30/2016
     * @return date
     */
    public String getDate() {
        return date;
    }

    // setter methods

    /**
     * Sets an id number for this tour. 
     * @author Kathryn Bello - 6/30/2016
     * @param id 
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Sets a name for this tour.
     * @author Kathryn Bello - 6/30/2016
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets a description for this tour.
     * @author Kathryn Bello - 6/30/2016
     * @param desc 
     */
    public void setDescription(String desc) {
        this.desc = desc;
    }

    /**
     * Sets a city for this tour.
     * @author Kathryn Bello - 6/30/2016
     * @param city 
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets a state for this tour.
     * @author Kathryn Bello - 6/30/2016
     * @param state 
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets a date for this tour.
     * @author Kathryn Bello - 6/30/2016
     * @param date 
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * A string containing all the information for the tour.
     * @author Kathryn Bello - 6/30/2016
     * @return tour information
     */
    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + desc +
                ", city=" + city +
                ", state=" + state +
                ", date=" + date +
                '}';
    }
}
