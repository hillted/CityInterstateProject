package com.hillt;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by thill on 5/3/16.
 */
public class InterstateWorker {

    private Set<String> gInterstateSet = new LinkedHashSet<>();

    /**
     * A hack to create an Interstate-Set (for a City) ordered by the Interstate number.
     *
     * @param aInterstateString     The String with the Interstate.
     * @return Set                  The Set of Interstates
     */
    public Set<String> createInterstates(String aInterstateString) {
        //Make a Set-sorted-by-Integer
        String[] interstateArrayBefore = aInterstateString.split(";");
        Set<Integer> interstateIntSet = new TreeSet<>();

        //Parse out original String[] and parse interstate-Integer, put into Set-sorted-by-Integer
        Arrays.sort(interstateArrayBefore);
        for(String s: interstateArrayBefore){
            interstateIntSet.add(Integer.parseInt(s.substring(s.indexOf("-")+1)));
        }

        //Take Set-sorted-by-Integer, stream.map-each element, and pre-pend with "I-" and throw into a List<String>
        List<String> interstateList = interstateIntSet.stream().map(val -> "I-" + val).collect(Collectors.toList());

        //iterate thru the new list that's sorted by Integer, and put into a new String[]
        String[] interstateArrayAfter = new String[interstateArrayBefore.length];
        for (int i = 0; i < interstateList.size(); i++) {
            interstateArrayAfter[i] = interstateList.get(i);
        }

        //put into a Set that'll preserve the insert order
        Collections.addAll(gInterstateSet, interstateArrayAfter);
        return gInterstateSet;
    }

    /**
     * Gets the City-List, iterates it for City-Name, and the Interstate-Set.
     * Makes a String-Set, puts each City's Interstate-Set into it.
     * Iterates the String-Set from the City, makes an ordered-unique-City-Map (just with the City-name and a timestamp).
     * Creates an Interstate, (with name, and the ordered-unique-City-Map)
     * Creates and Interstate-List and adds the Interstate to it.
     * Sorts the Interstate-List using compareTo override, that'll sort it by Interstate number.
     * Change Interstate-List into a Stream,  sort and group it by Interstate number, and put into a sorted-map(int,Interstate-List)
     * iterate thru the sorted-map, grabbing it's keys and values, work with those to create the ou
     *
     * @return String
     */
    public String aggregateInterstatesByCity() {
        StringBuilder fString = new StringBuilder();
        List<Interstate> interstateList = new ArrayList<>();
        for (City c : CityWorker.getCities()) {
            String cityName = c.getCityName();
            System.out.println(cityName);
            Set<String> interstateSet = c.getInterstateSet();
            for(String interStateName: interstateSet) {
                Map<String, Long> uniqueCityMap = new TreeMap<>();
                uniqueCityMap.put(cityName, System.currentTimeMillis());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Interstate interstate = new Interstate(interStateName,uniqueCityMap);
                interstateList.add(interstate);
                System.out.println("aggregateInterstatesByCity: "+interstate);
            }
        }

        Collections.sort(interstateList);
        interstateList.forEach(System.out::println);

        Stream<Interstate> interstateStream = interstateList.stream();
        Map<Integer, List<Interstate>> anotherMap = new TreeMap<>(interstateStream.sorted(comparing(Interstate::getInterstateNumber)).collect(groupingBy(Interstate::getInterstateNumber)));

        for (Map.Entry<Integer, List<Interstate>> stringListEntry : anotherMap.entrySet()) {
            Map.Entry entry = (Map.Entry) stringListEntry;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int listSize = 0;
            if (value instanceof List) {
                listSize = ((List) value).size();
            }
            fString.append("I-").append(key).append(" ").append(listSize).append("\n");
        }
        return fString.toString();
    }
}