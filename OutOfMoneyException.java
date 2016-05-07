public class OutOfMoneyException extends Exception
{
     public String getMessage()
     {
          return "Advertisement can't be generated, Candidate doesnt have enough Money.";
     }
}