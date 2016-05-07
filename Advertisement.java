import java.util.Random;
public class Advertisement
{
     private String message = "Nothing";
     private Candidate cand = null;
     private int cost = 0;
     protected Random rand = new Random();
     
     public Advertisement(String inMsg, Candidate inCand) throws OutOfMoneyException
     {
          setCandidate(inCand);
          setMessage(inMsg);
          if (cost > inCand.getMoney())
          {
               throw new OutOfMoneyException();
          }
     }
     
     public String toString()
     {
          return "This generic Advert is:\n\tFor " + cand.getName() + "\n\tAbout: " + getMessage() + "\n\tCosts: $" + getCost();
     }
     
     public String getMessage()
     {
          return message;
     }
     
     protected void setMessage(String newMessage)
     {
          message = newMessage;
     }
     
     public Candidate getCandidate()
     {
          return cand;
     }
     
     protected void setCandidate(Candidate newCand)
     {
          cand = newCand;
     }
     
     public int getCost()
     {
          return cost;
     }
     
     protected void setCost(int inCost)
     {
          if (inCost > 0)
          {
               cost = inCost;
          }
     }
     
     public String run()
     {
          getCandidate().addMoney(getCost() * -1);
          return "SOMETHING!";
     }

}