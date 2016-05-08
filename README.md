# JavaClassProject-2
CSCI161 Second Java Project Completed


This was my Second project of the Spring 2016 Semester and I learned alot of new programming concepts. In this Project I utilized Inheritance, Exception handling, method overloading and overriding along with re-learning a valuable skill: Good Variable names and great documentation. Below are the list of requirements the program must adhere by in order to get a perfect score on the project. 

  I have provided a sample txt file if you wish to download the program, all that needs changing is the scanner directory in the Driver file for the program to work. 




List of Requirements:


Candidate

Needs a toString() method.
Needs an equals() method (compares candidate name)
Needs a compareTo() method (Compares candidate’s money)
Has an Advertisement preference. (Generate this value randomly from the 3 options)
The 3 types of Advertisements are: Issue-Based, Attack Ads, Town Hall
Has a Fundraiser preference. (Generate this value randomly from the 3 options) The 3
types of Fundraisers are: Social Events, Automated Phone Calls, Political Action Committees.
Has a money modifier (initially 1.0 when the Candidate is created):If this value is every below zero, the associated get method should return zero.The associated set method should add to or subtract from the current value by
the input parameter value
Has a debate modifier (initially 1.0 when the Candidate is created):If this value is every below zero, the associated get method should return zero. The associated set method should add to or subtract from the current value by
the input parameter value
The old endorsement method should now take in an Advertisement. Based on the
Advertisement, the endorsement method should return a Boolean value to indicate if
the Candidate approved the Advertisement.

Debate

Needs a toString() method.
Can now have 2 or more candidates (capped at max integer)
Winner should now be decided by:
Generating a debate score for each candidate involved in the debate.
Use the formula, where Random_Number is 0 to 100 (both endpoints inclusive):
Debate_Score = Random_Number * Candidate’s_Debate_Modifier
Candidate with highest debate score wins!
Winning candidate receives money from each losing candidate as calculated by:
Money_Won = Losing_Candidate’s_Money * (Total_Of_All_Debate_Scores -
Losing_Candidate’s_Debate_Score ) / Total_Of_All_Debate_Scores
Return String declaring the winner and how much money each losing candidate
lost to the Winner

Fundraiser

Needs a toString() method.
Should now generate money by:
Randomly generating a number of donors who attended (0 to 200, both points
inclusive)
For each donor, generate a random number (0 to 151, zero inclusive, 151
exclusive) to represent how much that donor contributes
Total of all donations should be multiplied against the candidate’s money
modifier
Add the resulting value to the candidate’s money

Election

Needs a toString() method.
Should now allow any number of Candidates to enter

NEW OBJECTS SECTION:

Advertisement

Should have a message which describes what the Advertisement is about
Has a Candidate
Have a cost
o Needs a toString() method.


IssueBasedAdvertisement

Needs a toString() method.
Should be a sub-class of Advertisement
Cost should be randomly generated between 5,000 and 20,000 (endpoints inclusive) If approved by its Candidate, it should:
Increase its Candidate’s debate modifier by .1 unit.
Return Endorsement message (see OoL #1 for exact text).  If not approved by its Candidate, it should:
Increase its Candidate’s debate modifier by .05 units.
Return the message “This message has not been approved by XXX.” Where XXX
should be replaced by the name of the candidate.


AttackAdvertisement

Needs a toString() method.
Should be a sub-class of Advertisement
Cost should be randomly generated between 50,000 and 75,000 (endpoints inclusive) o Should have a second candidate (referred to in this specification as the TARGET)
If approved by its Candidate, it should:
Increase its Candidate’s debate modifier by .2 units.
Decrease its Candidate’s money modifier by .2 units.
Decrease its TARGET’s debate modifier by .15 units.
Decrease its TARGET’s money modifier by .25 units.
Return Endorsement message (see OoL #1 for exact text).
If not approved by its Candidate, it should:
Increase its Candidate’s the debate modifier by .1 unit.
Decrease its Candidate’s the money modifier by .05 units.
Decrease its TARGET’s debate modifier by .05 units.
Decrease its TARGET’s money modifier by .1 units.
Return the message “This message has not been approved by XXX.” Where XXX
should be replaced by the name of the candidate.

TownHallAdvertisement

Needs a toString() method.
Should be a sub-class of Advertisement
Cost should be randomly generated between 5,000 and 100,000 (endpoints inclusive) o Has attendees
Attendees should be generated randomly as follows:
Generate a random number from 0 (inclusive) to 151 (exclusive) o If approved by its Candidate, it should:
Increase its Candidate’s money modifier by (attendees / 500.0) units
Return the message “XXX holds a successful Town Hall.” Where XXX should be
replaced by the name of the candidate. o If not approved by its Candidate, it should:
Increase its Candidate’s money modifier by (attendees / 2000.0) units
Return the message “XXX holds a Town Hall.” Where XXX should be replaced by
the name of the candidate.

SocialFundraiser

Needs a toString() method.
Should be a sub-class of Fundraiser
During money generation and after money has been transferred to Candidate:
Candidate’s money modifier should be increased by .1 units 

PhoneFundraiser

Needs a toString() method.
Should be a sub-class of Fundraiser
During money generation and after money has been transferred to Candidate:
Candidate’s money modifier should be decreased by .05 units 

PACFundraiser

Needs a toString() method.
Should be a sub-class of Fundraiser
During money generation and after money has been transferred to Candidate:
Candidate’s money modifier should be increased by .2 units
Candidate’s debate modifier should be increased by .1 units 

OutOfMoneyException

This exception should be thrown during an advertisement’s constructor if the ad will cost more than the Candidate has money.

TooLowInPollsException

This exception should be thrown during a debate’s constructor if a one or more of the
debate’s candidate has less than 3% of the total money currently in play (total of all money from all candidates) UNLESS all of the debate’s candidates are from the same political party
This exception should be thrown during a PACFundraiser’s constructor if the PACFundraiser’s candidate has less than 1% of the total money currently in play (total of all money from all candidates)

DRIVER LAYOUT: The Driver will now operate as follows:

Should read in a file with candidate data for all candidates. Your only guarantee about file size is that there will be between 1 and Max Integer candidates. The input file will still be formatted the same way as OoL #1
Use the candidate data to create your candidates (must use either an Array or ArrayList of Candidates)
Read in location data from a file called “Locations.txt” (There will be one location per line in this file)
Store the location data in an Array or an ArrayList
Run through a loop 365 times. Each iteration = 1 day. Each time through this loop:
Each Candidate will be allowed 1 action, the action should be randomly selected from: Fundraising (30% weighted UNTIL day 250, then 60% weighted):
Create a Fundraiser of the Candidate’s preferred type (and select its location randomly from the list of locations)
If a TooLowInPollsException was triggered, randomly select and create either of the non-PACFundraisers instead.
Use the Fundraiser to generate money
Printout the fundraiser’s information via the Fundraiser’s toString() Advertising (70% weighted until day 250, then 40% weighted)
Generate a random Advertisement from the 3 specific types of Advertisements
If an OutOfMoneyException was triggered, do a fundraising event instead
Printout the Advertisement’s information and effects via the Advertisement’s toString();
  
If the current day is evenly divisible by 10:
And day 305 hasn’t been reached yet:
Create a debate for each political party
Each of political party’s debate should include all candidates from that
political party
Location data should be randomly selected from the list of locations
Declare the winner of the each debate and printout each debate’s
information using the debate’s toString() After day 305:
Create 1 debate which includes all eligible Candidates (candidates with more than 3% of the total money currently in play (total of all money from all candidates))
Location data should be randomly selected from the list of locations
Declare the winner of the debate and printout the debate’s information
using the debate’s toString()
Printout each of the Candidates (using their toString()) from most money to least money
Create an election using all candidates
Determine who won the election
Print the String announcing who won the election using the election’s toString()
