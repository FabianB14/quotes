/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class App {

  public static void main(String[] args) throws FileNotFoundException {
      getQuoteFromAPI();
  }
//This is to get quotes from API and write it to a class
  public static String  getQuoteFromAPI() throws FileNotFoundException {
    try {
      URL url = new URL("http://swquotesapi.digitaljedi.dk/api/SWQuote/RandomStarWarsQuote");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      System.out.println(con.getResponseCode());
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      Gson gson = new Gson();
      QuoteApi apiQuote = gson.fromJson(in, QuoteApi.class);
      write(apiQuote);
      in.close();
      System.out.println(apiQuote);
      return apiQuote.toString();
    } catch (IOException e) {
      e.printStackTrace();
      Quote[] quotes = getQuotesFromFile();
      getRandomQuote(quotes);
    }
      return "not found";
  }

//This is to write quotes to file
  public static void write(QuoteApi quote) {
    BufferedWriter writer = null;
    try {
      Gson gson = new Gson();
      String makeJson = gson.toJson(quote);
      writer = new BufferedWriter(new FileWriter("src/main/resources/apiquotes.json", true));
      writer.newLine();
      writer.append(makeJson);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
//This is to get quotes from the file
  public static Quote[] getQuotesFromFile() throws FileNotFoundException {
    Gson gson = new Gson();
    Quote[] quotes = gson.fromJson(new FileReader("src/main/resources/recentquotes.json"), Quote[].class);
    return quotes;
  }
//This will pull a random quote
  public static Quote getRandomQuote(Quote[] quotes) {
    int random = (int)(Math.random() * quotes.length);
    return quotes[random];
  }
}
