package com.hillt;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by thill on 5/3/16.
 */
public class CityWorker {

    private static List<City> gCityList = new ArrayList<>();

    public static List<City> getCities() {return gCityList; }

    /**
     * Add a City to the static-global-city-list.
     *
     * @param aCity     City to add to the City-List.
     */
    public static void addCities(City aCity) {
        if (gCityList != null && aCity != null) gCityList.add(aCity);
    }

    /**
     * Create a City object from a String (line in file).
     *
     * @param aString   The String from the line.
     * @return City
     */
    public City createCity(String aString) {
        String[] fields = aString.split("\\|");
        InterstateWorker interstateWorker = new InterstateWorker();
        return new City(Integer.parseInt(fields[0]), fields[1], fields[2],interstateWorker.createInterstates(fields[3]));
    }

    /**
     * Go thru static-global-city-list, group by the Population and put into a map sorted by population (in descending order)
     *
     * @return String
     */
    public String aggregateCitiesByPopulation() {
        StringBuilder fString = new StringBuilder();
        Stream<City> cityStream = gCityList.stream();
        Map<Integer, List<City>> cityMap = new TreeMap<>(cityStream.sorted(comparing(City::getCityName)).collect(groupingBy(City::getPop))).descendingMap();
        for (Map.Entry<Integer, List<City>> integerListEntry : cityMap.entrySet()) {
            Map.Entry entry = (Map.Entry) integerListEntry;
            Object key = entry.getKey();
            Object value = entry.getValue();
            fString.append(key).append("\n").append("\n").append(value).append("\n").append("\n");
        }
        return fString.toString().replaceAll("\\[","").replaceAll("\\]","").replaceAll("(?m)(?<=^ *), ", "\n");
    }
}