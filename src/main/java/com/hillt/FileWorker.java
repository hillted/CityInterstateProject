package com.hillt;

import java.io.*;

/**
 * Created by thill on 5/3/16.
 */
public class FileWorker {

    public String gCityInputFilename = "src/main/resources/Sample_Cities.txt";
    public String gCityOutputFilename = "Cities_By_Population.txt";
    public String gInterstateOutputFilename = "Interstates_By_Cities.txt";

    public String getCityInputFilename() {
        return gCityInputFilename;
    }

    public void setCityInputFilename(String aCityInputFilename) {
        this.gCityInputFilename = aCityInputFilename;
    }

    CityWorker cityWorker = new CityWorker();
    InterstateWorker interstateWorker = new InterstateWorker();

    /**
     * Generic Constructor that'll pickup default resource filename.
     */
    public FileWorker(){
        parseFile(getCityInputFilename());
        createOutput();
    }

    /**
     * Constructor for passing in filename.
     *
     * @param aInputFileName    The String with the filename.
     */
    public FileWorker(String aInputFileName) {
        setCityInputFilename(aInputFileName);
        parseFile(getCityInputFilename());
        createOutput();
    }

    /**
     * Old timey parsing input file, and creating a City, then adding it to static city-list.
     *
     * @param aFileName     The String with the filename.
     */
    public void parseFile(String aFileName) {
        double count = 0;
        String line;
        BufferedReader fBufferedReader = null;
        try  {
            fBufferedReader = new BufferedReader(new FileReader(aFileName));
            while ((line = fBufferedReader.readLine()) != null) {
                City fCity = cityWorker.createCity(line);
                CityWorker.addCities(fCity);
                count++;
            }
            fBufferedReader.close();
            System.out.println("Lines--" + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (fBufferedReader!=null) try {fBufferedReader.close();} catch(Exception ignored) {}
        }
    }

    /**
     * Quick and dirty way to create a text file and add content to it (after aggregating it)
     */
    public void createOutput() {
        try {
            Utilities utils = new Utilities();
            utils.createTextFile(gCityOutputFilename, cityWorker.aggregateCitiesByPopulation());
            utils.createTextFile(gInterstateOutputFilename, interstateWorker.aggregateInterstatesByCity());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}