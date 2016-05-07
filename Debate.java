import java.util.*;
public class Debate
{
     private String location = "DEFAULT";
     private ArrayList<Candidate> candidates = new ArrayList<Candidate>();
     private Random rand = new Random();
     
     
     /**
      * 
      * @param inLoc Location of where Debate will be
      * @param newList ArrayList of Candidates
      * @throws TooLowInPollsException 
      */
     public Debate(String inLoc, ArrayList<Candidate> newList) throws TooLowInPollsException
     {
          setLocation(inLoc);
          setCandidates(newList);
          boolean sameParty = true;
          if (candidates.size() != 0)
          {
               String party = candidates.get(0).getParty();
               for (Candidate person : candidates)
               {
                    if (!(person.getParty().equals(party)))
                    {
                         sameParty = false;
                    }
               }
               if (!sameParty)
               {
                    for (Candidate person : candidates)
                    {
                         long total = Candidate.getAllMoney();
                         if (person.getMoney() < total * .03)
                         {
                              throw new TooLowInPollsException();
                         }
                    }
               }
               
          }
          
     }
     
     public String toString()
     {
          return "This debate takes place at " + getLocation() + ".  The Candates participating are:\n" + getCandidates() + "\n";
     }
     
     public void setLocation(String inLoc)
     {
          location = inLoc;
     }
     
     public String getLocation()
     {
          return location;
     }
     
     public void setCandidates(ArrayList<Candidate> newList)
     {
          //If using list mode, reset old list
          candidates.clear();
          
          //Go through new List
          for (Candidate newCand : newList)
          {
               //Add each newCandidate
               addCandidate(newCand);
          }
     }
     
     //This method not required by OoL #2, but seems like it would be useful
     public void addCandidate(Candidate newCand)
     {
          //Verify no duplicates before adding the new Candidate
          boolean noMatch = true;
          for (Candidate current : candidates)
          {
               if (newCand.equals(current))
               {
                    noMatch = false;
               }
          }
          if (noMatch)
          {
               candidates.add(newCand);
          }
     }
     
     public String getCandidates()
     {
          String candList = "";
          for (Candidate cand : candidates)
          {
               candList = candList + "\n" + cand;
          }
          return candList;
     }
     
     public String declareWinner()
     {
          if (candidates.size() == 0)
          {
               return "NO WINNER";
          }
          //Points array
          int[] points = new int[candidates.size()];
          int total = 0;
          for (int x = 0; x < candidates.size(); x++)
          {
               points[x] = (int) (rand.nextInt(101) * candidates.get(x).getDebateMod());
               total += points[x];
          }
          
          //Determine Winner!
          int winnerIndex = -1;
          int maxPoints = -1;
          for (int x = 0; x < points.length; x++)
          {
               if (points[x] > maxPoints || (points[x] == maxPoints && rand.nextBoolean()) )
               {
                    maxPoints = points[x];
                    winnerIndex = x;
               }
          }          
          String output = "The winner of this debate is " + candidates.get(winnerIndex).getName() + ".  This winning candidate recieved the following payouts:";          
          
          //Handle payouts
          int payouts = 0;
          for (int x = 0; x < candidates.size(); x++)
          {
               if (x != winnerIndex)
               {
                    int payout = (candidates.get(x).getMoney() * (total - points[x])) / total;
                    payouts += payout;
                    candidates.get(x).addMoney(-1 * payout);
                    candidates.get(winnerIndex).addMoney(payout);
                    output = output + "\n\t" + candidates.get(x).getName() + " paid out $" + payout;
               }
          }
          
          return output;
          
     }
     
}


