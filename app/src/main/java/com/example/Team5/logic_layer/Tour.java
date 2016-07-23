package com.example.Team5.logic_layer;

/**
 * A Tour class to represent a tour.
 *
 * @author Kathryn Bello - 6/30/2016
 */
public class Tour {
    private int id;
    private String name;
    private String desc;
    private String addr;
    private String apt;
    private String city;
    private String state;
    private String zip;
    private String date;
    private String time;

    /**
     * Creates a Tour object.
     *
     * @param name
     * @param desc
     * @param addr
     * @param apt
     * @param city
     * @param state
     * @param zip
     * @param date
     * @param time
     */
    public Tour( String name, String desc, String addr, String apt, String city,
                String state, String zip, String date, String time) {
        //this.id = id;
        this.name = name;
        this.desc = desc;
        this.addr = addr;
        this.apt = apt;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.date = date;
        this.time = time;
    }




    // getter methods


    /**
     * @return id
     */
    public int getID() {
        return id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return desc;
    }

    /**
     * @return address line 1
     */
    public String getAddressLine() {
        return addr;
    }

    /**
     * @return address line 2
     */
    public String getAptLine() {
        return apt;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @return zip code
     */
    public String getZip() {
        return zip;
    }

    /**
     * @return date of tour
     */
    public String getDate() {
        return date;
    }

    /**
     * @return time of tour
     */
    public String getTime() {
        return time;
    }


    // setter methods


    /**
     * @param id
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param desc
     */
    public void setDescription(String desc) {
        this.desc = desc;
    }

    /**
     * @param addr
     */
    public void setAddressLine(String addr) {
        this.addr = addr;
    }

    /**
     * @param apt
     */
    public void setAptLine(String apt) {
        this.apt = apt;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @param zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @param time
     */
    public void setTime(String time) {
        this.time = time;
    }
}