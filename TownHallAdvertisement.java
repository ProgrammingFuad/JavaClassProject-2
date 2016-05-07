public class TownHallAdvertisement extends Advertisement
{
     private int attendees = 0;
 	/**
 	 * Takes in Message and a candidate.
 	 * Utilizes Super constructor----> Advertisement
 	 * Throws too Out of Money exception if advertisement cost is greater than Candidates money
 	 */
     public TownHallAdvertisement(String inMsg, Candidate inCand) throws OutOfMoneyException
     {
          super(inMsg,inCand);
          setCost(rand.nextInt(95001) + 5000);
          attendees = rand.nextInt(151);
          if (getCost() > getCandidate().getMoney())
          {
               throw new OutOfMoneyException();
          }

     }
     
     
 	/**
 	 * Returns TownHall Advertisement information.
 	 */
     
     public String toString()
     {
          return "This Town Hall Advert is:\n\tFor " + getCandidate().getName() + "\n\tAbout: " + getMessage() + "\n\tCosts: $" + getCost();
     }
     
     /**
  	 * If candidates money is less then the cost required to run advert, returns a string
  	 * If Candidates Advertisement Preference is Town Hall, Change Money Modifier to Attendees divided by 500+ modifier and return string approving message
  	 * otherwise Change Money Modifier to Attendees divided by 2000 + modifier and return string approving message
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
               getCandidate().setMoneyMod(getCandidate().getMoneyMod() + (attendees / 500.0));
               return getCandidate().getName() + " holds a successfull Town Hall.";
          }
          else
          {
               getCandidate().setMoneyMod(getCandidate().getMoneyMod() + (attendees / 2000.0));
               return getCandidate().getName() + " holds a Town Hall.";
          }
     }
}