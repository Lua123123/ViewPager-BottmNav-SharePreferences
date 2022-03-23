package com.example.retrofitgetkotlin.model;

public class Weather {

    private String title;
    private String location_type;
    private Integer woeid;
    private String latt_long;

    public Weather(String title, String locationType, Integer woeid, String lattLong) {
        this.title = title;
        this.location_type = locationType;
        this.woeid = woeid;
        this.latt_long = lattLong;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getLocationType() {
        return location_type;
    }
    public void setLocationType(String locationType) {
        this.location_type = locationType;
    }
    public Integer getWoeid() {
        return woeid;
    }
    public void setWoeid(Integer woeid) {
        this.woeid = woeid;
    }
    public String getLattLong() {
        return latt_long;
    }
    public void setLattLong(String lattLong) {
        this.latt_long = lattLong;
    }


}