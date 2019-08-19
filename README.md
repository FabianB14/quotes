# Get Random Quote
This app will make an Api call for a random Star Wars quote, add it to a Json file and print out the random Star
 Wars quote. If offline, it will print out a random quote from the 'recentquotes' Json file instead. This app use
  Gson to
  convert
 Json objects into class
 objects. 

## App.java
* getQuoteFromAPI()
* writeToApiFile()
* makeQuotesFromFile()
* getRandomQuoteFromFile()

## To use
* Install dependencies:
    * ensure this is listed in build.gradle: implementation 'com.google.code.gson:gson:2.8.5'
    * Run Build Project

* Run: 
    * ./gradlew run

