Idea Project, built with Java8 on Mac osx. The following will create the files in the root directory of the project...

To Build And Run Tests...will create files.
--------------------------------------------
 cd ~/IdeaProjects/CityInterstateProject  #or wherever the project is installed.
 mvn clean install

fyi, tests are more integration/regression type tests.


To Run By Commandline...will create files.
--------------------------------------------
This was created on osx.
So to run it on osx, assuming java8 is on classpath:
 cd ~/IdeaProjects/CityInterstateProject
 ./runApp.sh src/main/resources/Sample_Cities.txt


If on pc, and java8 is on classpath:
 cd ~/IdeaProjects/CityInterstateProject
 java -classpath com.hillt.RunApp -jar target/CityInterstate-*-dependencies.jar src/main/resources/Sample_Cities.txt


Doc
---------
cd ~/IdeaProjects/CityInterstateProject
 mvn javadoc:javadoc && mvn site

open link up in browser:
 ~/IdeaProjects/CityInterstateProject/target/site/apidocs/index.html
 ~/IdeaProjects/CityInterstateProject/target/site/index.html