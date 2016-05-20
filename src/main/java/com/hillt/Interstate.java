package com.hillt;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by thill on 5/3/16.
 */

@SuppressWarnings("unchecked")
public class Interstate implements Comparable<Interstate> {

    private String interstateName = "";

    private int interstateNumber = 0;

    public int getInterstateNumber() {
        return interstateNumber;
    }

    public void setInterstateNumber(int aInterstateNumber) {
        this.interstateNumber = aInterstateNumber;
    }

    private Map<String, Long> uniqueCityMap = new TreeMap<>();

    public Interstate(String aInterstateName, Map aUniqueCityMap) {
        setInterstateName(aInterstateName);
        setInterstateNumber(Integer.parseInt(aInterstateName.substring(aInterstateName.indexOf("-")+1)));
        setUniqueCityMap(aUniqueCityMap);
    }

    public void setInterstateName(String aInterstateName) {
        this.interstateName = aInterstateName;
    }

    public void setUniqueCityMap(Map<String, Long> aUniqueCityMap) {
        this.uniqueCityMap = aUniqueCityMap;
    }

    @Override
    public int compareTo(Interstate otherInterstate) {
        if (this.getInterstateNumber() < otherInterstate.getInterstateNumber()) {
            return this.getInterstateNumber();
        }
        else {
            return otherInterstate.getInterstateNumber();
        }
    }

    @Override
    public String toString() {
        return "Interstate{" +
                "interstateName='" + interstateName + '\'' +
                ", interstateNumber=" + interstateNumber +
                ", uniqueCityMap=" + uniqueCityMap +
                '}';
    }
}
