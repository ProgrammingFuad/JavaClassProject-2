public class TooLowInPollsException extends Exception
{
     public String getMessage()
     {
          return "One of the candidates is too low in the polls to compete in this debate!";
     }
}