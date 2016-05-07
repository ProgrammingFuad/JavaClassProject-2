public class PACFundraiser extends Fundraiser
{
	
	
	/**
	 * Takes in Message and a candidate.
	 * Utilizes Super constructor----> Fundraiser
	 * Throws too low in polls exception if Candidates total money is less than 1% of
	 */
     public PACFundraiser(String inLoc, Candidate inCandidate) throws TooLowInPollsException
     {
          super(inLoc,inCandidate);
          long total = Candidate.getAllMoney();
          if (inCandidate.getMoney() < total * .01)
          {
               throw new TooLowInPollsException();
          }
     }
     
     /**
  	 * Prints information about PACFundraiser
  	 */
     public String toString()
     {
          return getCandidate().getName() + "'s PAC fundraiser takes place in: " + getLocation() + " and has " + getDonors() + " donors attending.\n";
     }
     
     
     /**
   	 * Calls the super constructor---> Fundraiser
   	 * It will raise money for the Candidate depending on how many random Donors he has and how much
   	 * the total random amount of money each of them carry, totaled up. 
   	 * Then it will increase Candidates Money Modifer and Debate Modifer. 
   	 */
     public int raiseMoney()
     {
          int total = super.raiseMoney();
          getCandidate().setMoneyMod(getCandidate().getMoneyMod() + .2);
          getCandidate().setDebateMod(getCandidate().getDebateMod() + .1);
          return total;
     }
     
}