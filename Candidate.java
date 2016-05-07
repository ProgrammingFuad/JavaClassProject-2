
import java.util.Random;
public class Candidate
{
     private String name = "DEFAULT";
     private String slogan = "DEFAULT";
     private int money = 0;
     private static long allMoney = 0;
     private String party = "DEFAULT";
     private Random rand = new Random();
     private int adPref = -1; // 0: IssueBased, 1: Attack, 2:TownHall
     private int fundPref = -1; // 0: Social, 1: RotoCall, 2:PACs
     private double moneyMod = 1.0;
     private double debateMod = 1.0;
          
     public String toString()
     {
          String adType = "";
          if (getAdPref() == 0)
          {
               adType = "Issue Based";
          }
          else if (getAdPref() == 1)
          {
               adType = "Attack";
          }
          else if (getAdPref() == 2)
          {
               adType = "Town Hall";
          }
          else
          {
               adType = "Unknown";
          }
          
          String fundType = "";
          if (getAdPref() == 0)
          {
               fundType = "Social Events";
          }
          else if (getAdPref() == 1)
          {
               fundType = "Automated Phone Calls";
          }
          else if (getAdPref() == 2)
          {
               fundType = "Political Action Committees";
          }
          else
          {
               fundType = "Unknown";
          }
          
          return "Candidate " + getName() + ":\n\tSlogan: " + getSlogan() + "\n\tParty: " + getParty() + "\n\tCurrent funds: " + getMoney() + "\n\tPreferred Ad Type: " + adType + "\n\tPreferred Fund Type: " + fundType + "\n\tCurrent Money Modifier: " + getMoneyMod() + "\n\tCurrent Debate Modifier: " + getDebateMod() + "\n";
     }
     
     public Candidate(String inName, String inSlogan, String inParty)
     {
          setName(inName);
          setSlogan(inSlogan);
          setParty(inParty);
          addMoney(rand.nextInt(101));
          setAdPref(rand.nextInt(3));
          setFundPref(rand.nextInt(3));
     }
     
     public void setName(String inName)
     {
          name = inName;
     }
     
     public String getName()
     {
          return name;
     }
     
     public void setSlogan(String inSlogan)
     {
          slogan = inSlogan;
     }
     
     public String getSlogan()
     {
          return slogan;
     }
     
     public void setParty(String inParty)
     {
          party = inParty;
     }
     
     public String getParty()
     {
          return party;
     }
     
     public int getMoney()
     {
          return money;
     }
     
     public static long getAllMoney()
     {
          return allMoney;
     }
     
     public void addMoney(int newMoney)
     {
          money += newMoney;
          allMoney +=newMoney;
     }
     
     public boolean endorse(Advertisement newAd)
     {
          return (getAdPref() == 0 && newAd instanceof IssueBasedAdvertisement) || (getAdPref() == 1 && newAd instanceof AttackAdvertisement) || (getAdPref() == 2 && newAd instanceof TownHallAdvertisement);
     }
     
     public boolean equals(Candidate otherCand)
     {
          return getName().equals(otherCand.getName());
     }
     
     public int compareTo(Candidate otherCand)
     {
          return getMoney() - otherCand.getMoney();
     }
     
     public int getAdPref()
     {
          return adPref;
     }
     
     private void setAdPref(int newPref)
     {
          adPref = newPref;
     }
     
     public int getFundPref()
     {
          return fundPref;
     }
     
     private void setFundPref(int newPref)
     {
          fundPref = newPref;
     }
     
     public double getMoneyMod()
     {
          if (moneyMod < 0)
          {
               return 0;
          }
          return moneyMod;
     }
     
     public void setMoneyMod(double newMod)
     {
          moneyMod = newMod;
     }

     public double getDebateMod()
     {
          if (debateMod < 0)
          {
               return 0;
          }
          return debateMod;
     }
     
     public void setDebateMod(double newMod)
     {
          debateMod = newMod;
     }

}

