package quotes;

public class QuoteApi {
  String starWarsQuote;

  public QuoteApi(String starWarsQuote){
    this.starWarsQuote = starWarsQuote;
  }

  public String toString(){
    return String.format(this.starWarsQuote);
  }
}
