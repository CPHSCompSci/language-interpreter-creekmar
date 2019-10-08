package app;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    //test comment I think I'm done
  public static void main(String[] args) {
    Lexicon lex = new Lexicon();

    String newWord = lex.transword("Parky wintertime");
    System.out.println(newWord + lex.translate("Parky") + " " + lex.translate("wintertime")); //testing both translate methods
    System.out.println(decode("hoenttingy")); //decoding string method
    System.out.println(decodeMessage(lex.getSample(5))); //decoding message method
    
    //testing input methods
    System.out.println(decodeInput()); //decoding input message method
    System.out.println(encodeInput());  //encoding input method
  }

  /**
   * This method decodes a single word.
   * 
   * @param word The single word to be decoded.
   */
  public static String decode(String word) {
	  char[] vowels = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
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
  //decoding other language stuff
  public static String decodeInput() {
	System.out.print("Type in sentence to decode: ");
    return decodeMessage(scan.nextLine());
  }
  
  /**
   * This method uses the Lexicon translate(String) and a Scanner to encode a word specified
   * by the user.
   */
  //encoding english input
  public static String encodeInput() {
	  Lexicon lex = new Lexicon();
	  System.out.print("Type in sentence to encode: ");
	  return lex.transword(scan.nextLine());
  }
}