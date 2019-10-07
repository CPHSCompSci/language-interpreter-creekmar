package app;
import java.util.Scanner;

public class Main {
  //Test Comment
  public static void main(String[] args) {
    Lexicon lex = new Lexicon();
    Scanner scan = new Scanner(System.in);

    String newWord = lex.translate("Parky wintertime");
    System.out.println(newWord);
    System.out.println(decode("hoenttingy"));
    System.out.println(decodeMessage("Hoenttingy deentclivityingy."));
  }

  /**
   * This method decodes a single word.
   * 
   * @param word The single word to be decoded.
   */
  public static String decode(String word) {
	  char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
	  int slength = word.length();
	  
	  //removing ingy
	  if(word.indexOf("ingy") != -1)
	  {
		  slength = word.lastIndexOf("ingy");
	  } 
	  
	  
      String output = "";
      for (int i = 0; i < slength; i++) 
      {
          output += word.substring(i, i + 1);
          for (char v : vowels) 
          {
        	  //removing ent
              if (v == word.charAt(i) && word.indexOf("ent") == i+1) 
              {
                  i+=3;
              }
          }
      }
	  return output;
  }

  /**
   * This method should not have code copy/pasted from the decode method.
   * 
   * @param message The sentence (multiple words) to be decoded.
   */
  public static String decodeMessage(String message) {
	  String output = "";
	  while (message.length()>0)
	  {
		  int space = message.indexOf(" ");
		  
		  if(space != -1)
			  output = output + (decode(message.substring(0, space))) + " ";
		  else
			  output = output + decode(message.substring(0)) + " ";
		  
		  if(space != -1 && space != 0)
			  message = message.substring(space+1);
		  else
			  message = "";
	  }
	  
	  return output;
  }

  /**
   * This method uses the decode(String) and a Scanner to decode a word specified
   * by the user.
   */
  public static String decodeInput(String input) {
    return decodeMessage(input);
  }
  
  /**
   * This method uses the Lexicon translate(String) and a Scanner to encode a word specified
   * by the user.
   */
  public static String encodeInput(String input) {
	  Lexicon lex = new Lexicon();
	  return lex.translate(input);
  }
}