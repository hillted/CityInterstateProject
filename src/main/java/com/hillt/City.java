package com.hillt;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by thill on 5/3/16.
 */
public class City {

    private int pop = 0;
    private String cityName = "";
    private String stateName = "";
    private Set<String> interstateSet = new TreeSet<>();

    public City(int aPop, String aCityName, String aStateName, Set<String> aList) {
        setPop(aPop);
        setCityName(aCityName);
        setStateName(aStateName);
        setInterstateSet(aList);
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int aPop) {
        this.pop = aPop;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String aCityName) {
        this.cityName = aCityName;
    }

    public void setStateName(String aStateName) {
        this.stateName = aStateName;
    }

    public Set<String> getInterstateSet() {
        return interstateSet;
    }

    public void setInterstateSet(Set<String> aInterstateSet) {
        this.interstateSet = aInterstateSet;
    }

    @Override
    public String toString() {
        return cityName + ", " + stateName + "\n"
                + "Interstates: " + interstateSet + "\n";
    }
}
