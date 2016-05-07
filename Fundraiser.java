
import java.util.Random;
public class Fundraiser
{
     private String location = "DEFAULT";
     private Candidate candidate = null;
     private int donors;
     private Random rand = new Random();
     
     public Fundraiser(String inLoc, Candidate inCandidate)
     {
          setLocation(inLoc);
          setCandidate(inCandidate);
          donors = rand.nextInt(201);
     }
     
     public String toString()
     {
          return candidate.getName() + "'s fundraiser takes place in: " + getLocation() + " and has " + getDonors() + " donors attending.\n";
     }
     
     public void setLocation(String inLoc)
     {
          location = inLoc;
     }
     
     public String getLocation()
     {
          return location;
     }
     
     public void setCandidate(Candidate inCandidate)
     {
          candidate = inCandidate;
     }
     
     public Candidate getCandidate()
     {
          return candidate;
     }
     
     public int getDonors()
     {
          return donors;
     }
     
     public int raiseMoney()
     {
          int total = 0;
          for (int x = 0; x < donors; x++)
          {
               total += rand.nextInt(151);
          }
          candidate.addMoney((int)(total * candidate.getMoneyMod()));
          return total;
     }
}