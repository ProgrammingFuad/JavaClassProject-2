public class SocialFundraiser extends Fundraiser
{
	
	/**
	 * Takes in Message and a candidate.
	 * Utilizes Super constructor----> Fundraiser
	 * Throws too low in polls exception if Candidates total money is less than 1% of
	 */
     public SocialFundraiser(String inLoc, Candidate inCandidate)
     {
          super(inLoc,inCandidate);
     }
     
     
     /**
 	 * Returns String about SocialFundraiser
 	 */
     public String toString()
     {
          return getCandidate().getName() + "'s social fundraiser takes place in: " + getLocation() + " and has " + getDonors() + " donors attending.\n";
     }

     /**
      * Calls the super constructor---> Fundraiser
      * It will raise money for the Candidate depending on how many random Donors he has and how much
      * the total random amount of money each of them carry, totaled up. 
      * Then it will increase Candidates Money Modifer by 10%. 
    */
      public int raiseMoney()
     {
          int total = super.raiseMoney();
          getCandidate().setMoneyMod(getCandidate().getMoneyMod() + .1);
          return total;
     }
     
}