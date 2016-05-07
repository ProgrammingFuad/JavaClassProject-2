public class AttackAdvertisement extends Advertisement
{
     private Candidate target = null;
     
     
 	/**
 	 * Takes in Message and a candidate.
 	 * Utilizes Super constructor----> Advertisement
 	 * Method Overrides cost and triggers exception if candidate does not
 	 * have enough money to generate the Attack Based Advertisement
 	 * Also has a target Candidate for Attack Ad
 	 */
     public AttackAdvertisement(String inMsg, Candidate inCand, Candidate inTarget) throws OutOfMoneyException
     {
          super(inMsg,inCand);
          setCost(rand.nextInt(25001) + 50000);
          target = inTarget;
          if (getCost() > getCandidate().getMoney())
          {
               throw new OutOfMoneyException();
          }

     }
     
     
 	/**
 	 * Prints information about Attack Advertisement
 	 */
     public String toString()
     {
          return "This Attack Advert is:\n\tFor " + getCandidate().getName() + "\n\tAgainst: " + target.getName() + "\n\tAbout: " + getMessage() + "\n\tCosts: $" + getCost();
     }
     
     
     /**
  	 * If candidates money is less then the cost required to run advert, returns a string
  	 * If Candidates Advertisement Preference is Attack based, Increase his Debate Modifier by 20% and decrease money mod by 20% 
  	 * Also decrease Targets debate mod by 15% and money mod by 20%, and return string approving message
  	 * otherwise increase debate Modifier by 10% and decrease Money Mod by 5% and return string not approving advertisement
  	 * Along with decreasing Targets debate mod by 5% and money mod by 10%
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
               getCandidate().setDebateMod(getCandidate().getDebateMod() + .2);
               getCandidate().setMoneyMod(getCandidate().getMoneyMod() - .2);
               target.setDebateMod(target.getDebateMod() - .15);
               target.setMoneyMod(target.getMoneyMod() - .25);
               return "My name is " + getCandidate().getName() + ", and I approve this message";
          }
          else
          {
               getCandidate().setDebateMod(getCandidate().getDebateMod() + .1);
               getCandidate().setMoneyMod(getCandidate().getMoneyMod() - .05);
               target.setDebateMod(target.getDebateMod() - .05);
               target.setMoneyMod(target.getMoneyMod() - .1);
               return "This message has not been approved by " + getCandidate().getName() + ".";
          }
     }
}