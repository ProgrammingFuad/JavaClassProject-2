import java.util.*;
public class Election
{
     private String title = "DEFAULT";
     private ArrayList<Candidate> candidates = new ArrayList<Candidate>();
     private Random rand = new Random();
     
     public Election(String inTitle, ArrayList<Candidate> newList)
     {
          setTitle(inTitle);
          setCandidates(newList);
     }
     
     public String toString()
     {
          return "This is the " + getTitle() + " election.  The Candates participating are:\n" + getCandidates() + "\n" + declareWinner() + "\n";
     }
     
     public void setTitle(String inTitle)
     {
          title = inTitle;
     }
     
     public String getTitle()
     {
          return title;
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
          //Verify no dupes before adding the new Candidate
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
          Candidate winner = candidates.get(0);
          for (int x = 1; x < candidates.size(); x++)
          {
               if ( (winner.getMoney() < candidates.get(x).getMoney()) || (rand.nextBoolean() && winner.getMoney() == candidates.get(x).getMoney()) )
               {
                    winner = candidates.get(x);
               }
          }
          
          return winner.getName() + " is the winner of the " + getTitle() + " election";
     }
     
}