/**
 * Fuad Mohamoud
 * Computer Science II
 * 03/11/2016
 */
import java.util.*;
import java.io.*;
public class Driver
{
     public static void main(String[] args) throws FileNotFoundException
     {
          File cList = new File("/Users/fuadmohamoud/Desktop/OutOfLab2/Candidate.txt");
          File lList = new File("/Users/fuadmohamoud/Desktop/OutOfLab2/Locations.txt");
          Scanner cScanner = new Scanner(cList);
          
          ArrayList<Candidate> candidates = new ArrayList<Candidate>();
          ArrayList<String> locations = new ArrayList<String>();
          ArrayList<String> parties = new ArrayList<String>();
          
          int cCounter = 0;
          while(cScanner.hasNext())
          {
               String line = cScanner.nextLine();
               String[] token = line.split("1");
               candidates.add(new Candidate(token[0],token[2],token[1]));
               boolean match = false;
               for (String party : parties)
               {
                    if(party.equals(token[1]))
                    {
                         match = true;
                    }
               }
               if (!match)
               {
                    parties.add(token[1]);
               }
               cCounter++;
          }
          cScanner.close();
          
          cScanner = new Scanner(lList);
          while(cScanner.hasNext())
          {
               locations.add(cScanner.nextLine());
          }
          cScanner.close();
          
          
          
          Random rand = new Random();
          for (int x = 0; x < 365; x++)
          {
               if (x % 10 == 0 && x < 305)
               {
                    for (String party : parties)
                    {
                         ArrayList<Candidate> thisDebate = new ArrayList<Candidate>();
                         for (Candidate c : candidates)
                         {
                              if (party.equals(c.getParty()))
                              {
                                   thisDebate.add(c);
                              }
                         }
                              
                         boolean done = false;
                         Debate primary = null;
                         while (!done)
                         {
                              try
                              {
                                   primary = new Debate(locations.get(rand.nextInt(locations.size())), thisDebate);
                                   done = true;
                              }
                              catch (TooLowInPollsException e)
                              {
                                   System.err.println(e.getMessage() + "\nSo, we are removing lowest candidate...BUT, WE SHOULDN'T GET HERE!!!");
                              }    
                              
                         }
                         System.out.println(primary);
                         System.out.println(primary.declareWinner());
                         
                    }
               }
               else if (x % 10 == 0)
               {
                    boolean done = false;
                    Debate pres = null;
                    ArrayList<Candidate> thisDebate = new ArrayList<Candidate>();
                    for (Candidate copy : candidates)
                    {
                         thisDebate.add(copy);
                    }
                    while (!done)
                    {
                         try
                         {
                              pres = new Debate(locations.get(rand.nextInt(locations.size())), thisDebate);
                              done = true;
                         }
                         catch (TooLowInPollsException e)
                         {
                              System.err.println(e.getMessage() + "\nSo, we are removing lowest candidate...");
                              Candidate low = thisDebate.get(0);
                              for (int c = 1; c < thisDebate.size(); c++)
                              {
                                   if (low.getMoney() > thisDebate.get(c).getMoney())
                                   {
                                        low = thisDebate.get(c);
                                   }
                              }
                              thisDebate.remove(low);
                         }    
                         
                    }
                    System.out.println(pres);
                    System.out.println(pres.declareWinner());
                    
               }
               else
               {  
                    for (Candidate current : candidates)
                    {
                         if ((x < 250 && rand.nextInt(10) > 6) || (x > 250 && rand.nextInt(10) < 6))
                         {
                              Fundraiser sf = null;
                              if (current.getFundPref() == 0)
                              {
                                   sf = new SocialFundraiser(locations.get(rand.nextInt(locations.size())),current);
                              }
                              else if (current.getFundPref() == 1)
                              {
                                   sf = new PhoneFundraiser(locations.get(rand.nextInt(locations.size())),current);
                              }
                              else if (current.getFundPref() == 2)
                              {
                                   try
                                   {
                                        sf = new PACFundraiser(locations.get(rand.nextInt(locations.size())),current);
                                   }
                                   catch (TooLowInPollsException e)
                                   {
                                        System.err.println(e.getMessage() + "\n Creating a different fundraiser instead.");
                                        if (rand.nextBoolean())
                                        {
                                             sf = new SocialFundraiser(locations.get(rand.nextInt(locations.size())),current);
                                        }
                                        else
                                        {
                                             sf = new PhoneFundraiser(locations.get(rand.nextInt(locations.size())),current);
                                        }
                                   }
                              }
                              
                              System.out.println(sf + "\tRaised: $" + sf.raiseMoney());
                         }
                         else
                         {
                              try
                              {
                                   int select = rand.nextInt(3);
                                   Advertisement ad = null;
                                   if (select == 0)
                                   {
                                        Candidate target = current;
                                        while (!current.equals(target))
                                        {
                                             target = candidates.get(rand.nextInt(candidates.size()));
                                        }
                                        ad = new AttackAdvertisement(current.getSlogan(), current, target);
                                   }
                                   else if (select == 1)
                                   {
                                        ad = new IssueBasedAdvertisement(current.getSlogan(), current);
                                   }
                                   else
                                   {
                                        ad = new TownHallAdvertisement(current.getSlogan(), current);
                                   }
                                   
                                   System.out.println(ad.run());
                                   System.out.println(ad);
                              }
                              catch (OutOfMoneyException e)
                              {
                                   Fundraiser sf = null;
                                   System.err.println(e.getMessage() + "\nCandidate couldn't afford their add, fundraising instead");
                                   if (current.getFundPref() == 0)
                                   {
                                        sf = new SocialFundraiser(locations.get(rand.nextInt(locations.size())),current);
                                   }
                                   else if (current.getFundPref() == 1)
                                   {
                                        sf = new PhoneFundraiser(locations.get(rand.nextInt(locations.size())),current);
                                   }
                                   else if (current.getFundPref() == 2)
                                   {
                                        try
                                        {
                                             sf = new PACFundraiser(locations.get(rand.nextInt(locations.size())),current);
                                        }
                                        catch (TooLowInPollsException e1)
                                        {
                                             System.err.println(e1.getMessage() + "\n Creating a different fundraiser instead.");
                                             if (rand.nextBoolean())
                                             {
                                                  sf = new SocialFundraiser(locations.get(rand.nextInt(locations.size())),current);
                                             }
                                             else
                                             {
                                                  sf = new PhoneFundraiser(locations.get(rand.nextInt(locations.size())),current);
                                             }
                                        }
                                   }
                                   System.out.println(sf + "\tRaised: $" + sf.raiseMoney());
                              }
                         }
                    }
               }
          }
          
          Election finalPres = new Election("US President", candidates);
          System.out.println(finalPres);
     }
}