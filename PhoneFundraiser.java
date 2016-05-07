public class PhoneFundraiser extends Fundraiser
{
	
	/**
	 * Takes in Message and a candidate.
	 * Calls super Constructor---> Fundraiser
	 */
     public PhoneFundraiser(String inLoc, Candidate inCandidate)
     {
          super(inLoc,inCandidate);
     }
     
     /**
 	 * Returns Information about PhoneFundraiser
 	 */
     public String toString()
     {
          return getCandidate().getName() + "'s phone fundraiser takes place in: " + getLocation() + " and has " + getDonors() + " donors attending.\n";
     }
     
     /**
    	 * Calls the super constructor---> Fundraiser
    	 * It will raise money for the Candidate depending on how many random Donors he has and how much
    	 * the total random amount of money each of them carry, totaled up. 
    	 * It will then decrease Candidates Money  Modifier by 5%  
    	 */
     public int raiseMoney()
     {
          int total = super.raiseMoney();
          getCandidate().setMoneyMod(getCandidate().getMoneyMod() - .05);
          return total;
     }
     
}