/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.indexOf("no") >= 0)
        {
            response = "Excuse yourself? Who taught you manners?";
        }
        else if (statement.indexOf("my mother") >= 0)
        {
            response = "Mmhm...";
        }
        else if (statement.indexOf("goooba") >= 0)
        {
            response = "gooooba? goooooba!";
        }
        else if (statement.indexOf("food") >= 0)
        {
            response = "What's your favorite type";

        }
        else if (statement.indexOf("quit") >= 0)
        {
            response = "no, I decided when we are done";
        }
        else if (statement.indexOf("Comp-Sci") >= 0)
        {
            response = "It is quite interesting isn't it?";
        }
        else if (statement.indexOf("I'm tired") >= 0)
        {
            response = "Here you go: https://www.youtube.com/watch?v=WOuI4OqJfQc";
        }
        else if (statement.indexOf("Nathan Lin") >= 0)
        {
            response = "Nathan is the best teacher ever";
        }
        else if (statement.indexOf("Nathan Lin") >= 0)
        {
            response = "Nathan is the best teacher ever";
        }
        else if (statement.indexOf("dog") >= 0)
        {
            response = "Tell me more about your pets";
        }
        else if (statement.indexOf("cat") >= 0)
        {
            response = "Tell me more about your pets";
        }
        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
         else if (statement.trim().length() < 1){
            response = "Speak up I can't hear you";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Do tell.";
        }
        else if (whichResponse == 5)
        {
            response = "What?!";
        }
    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {
        str = " " + str.toLowerCase() + " ";
        word = " " + word.toLowerCase() + " ";

        return str.indexOf(word);
        }
        
    
    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        statement = statement.trim();
        String qwe = statement.substring(statement.length() - 1);
        if (qwe.equals(".")) {
            statement = statement.substring(statement.length() - 1);

        }
        int ynk = findWord(statement, "I want");
        String jkl = statement.substring(ynk + 7);
        return "Would you really be happy if you had " + jkl + "?";
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        statement = statement.trim();
        String qwe = statement.substring(statement.length() - 1);
        if (qwe.equals(".")) {
            statement = statement.substring(statement.length() - 1);

        }
        int ynk = findWord(statement, "I");
        int tou = findWord(statement, "You");
        String jkl = statement.substring(ynk + 1, tou).trim(); 
        return ("Why do you " + jkl + " me?");
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        statement = statement.trim();
        String qwe = statement.substring(statement.length() - 1);
        if (qwe.equals(".")) {
            statement = statement.substring(statement.length() - 1);
        
         }
        int ynk = findWord(statement, "I want to");
        String jkl = statement.substring(ynk + 9).trim();
        return ("What would it mean to " + jkl + "?");
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        statement = statement.trim();
        String qwe = statement.substring(statement.length() - 1);
        if (qwe.equals(".")) {
            statement = statement.substring(statement.length() - 1);
        
        }
        int ynk = findWord(statement, "You");
        int tou = findWord(statement, "Me");
        String jkl = statement.substring(ynk + 3, tou).trim();
        return ("What makes you think that I " + jkl + " you?");
    }
}
