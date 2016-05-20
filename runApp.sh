#!/bin/bash

FILE_NAME=$1
cd ~/IdeaProjects/CityInterstateProject
java -classpath com.hillt.RunApp -jar target/CityInterstate-*-dependencies.jar ${FILE_NAME}