public class IssueBasedAdvertisement extends Advertisement
{
     
	/**
	 * Takes in Message and a candidate.
	 * Utilizes Super constructor----> Advertisement
	 * Method Overrides cost and triggers exception if candidate does not
	 * have enough money to generate the Issue Based Advertisement
	 */
     public IssueBasedAdvertisement(String inMsg, Candidate inCand) throws OutOfMoneyException
     {
          super(inMsg,inCand);
          setCost(rand.nextInt(15001) + 5000);
          if (getCost() > getCandidate().getMoney())
          {
               throw new OutOfMoneyException();
          }

     }
     
     /**
 	 * Prints information about Issue Based Advertisement
 	 */
     public String toString()
     {
          return "This Issue-Based Advert is:\n\tFor " + getCandidate().getName() + "\n\tAbout: " + getMessage() + "\n\tCosts: $" + getCost();
     }
     
     
     /**
 	 * If candidates money is less then the cost required to run advert, returns a string
 	 * If Candidates Advertisement Preference is Issue Based, Increase his Debate Modifier by .1 and return string approving message
 	 * otherwise increase debate Modifier by .05 and return string not approving advertisement
 	 */
     public String run()
     {
          if (getCandidate().getMoney() < getCost())
          {
               return "NO CASH";
          }
          
          getCandidate().addMoney(getCost() * -1);
          
          if (getCandidate().endorse(this))
          {
               getCandidate().setDebateMod(getCandidate().getDebateMod() + .1);
               return "My name is " + getCandidate().getName() + ", and I approve this message";
          }
          else
          {
               getCandidate().setDebateMod(getCandidate().getDebateMod() + .05);
               return "This message has not been approved by " + getCandidate().getName() + ".";
          }
     }
    

}