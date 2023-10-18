import java.util.Scanner;
/* 
10.15.2023
Favio Valentino Jasso 
Prof. Stoll 
Jasso Lab11
*/

public class JassoLab11
{
//main method
   //displaying points earned to user(s) 
   //retrieving data from seperate class
   //retrieving calculation from seperate class
    public static void main(String[] args)
    {
        int[] numCups = new int[6];
        JassoPointsEarnedC numPoints = new JassoPointsEarnedC();
        final double WELCOME_POINTS = 10;
        String answer;
     // these are the variables that are going to declare months, cum-cups, avg cups.
        int months = 0;
        double totalCups = 0;
        double averageCups = 0;
//puts in new scanner for yes or no question. prints question to user if they would like to join the loyalty program. 
        Scanner kb = new Scanner(System.in);
        welcomeUser(kb, numPoints, WELCOME_POINTS);
      //Moved logic. 
        for (int i = 0; i < numCups.length; i++)
        {
            askForMonthCups(kb, numCups, i, months);
            totalCups += numCups[i];
            averageCups = totalCups / (i + 1);
        }

        numPoints.setMonthsEarned(numCups);
        checkVolumeBonus(months, averageCups, numPoints);

        displayPoints(numPoints);
    }
 /*
      Asks user if they would like to join the loyalty program
      If yes, thanks user and awards 10 points
      If not, pulls no arg constructor 
      @param WELCOME_POINTS
      */
    public static void welcomeUser(Scanner kb, JassoPointsEarnedC numPoints, double WELCOME_POINTS)
    {
        String answer;
        do
        {
            System.out.println("Would you like to sign up for our loyalty program? Y/N?");
            answer = kb.nextLine();

            if (answer.equals("Y"))
            {
                numPoints = new JassoPointsEarnedC(WELCOME_POINTS);
                System.out.printf("Thank you for joining the loyalty program! Your points are %.3f \n", numPoints.getPointsEarned());
            }
            else if (!answer.equals("N"))
                System.out.println("Invalid input, please re-enter.");
        }
        while ((!answer.equals("Y")) && (!answer.equals("N")));
    }
//asks for number cups month to month. 
    public static void askForMonthCups(Scanner kb, int[] numCups, int index, int months)
    {
        String answer;
        do
        {
            System.out.printf("Would you like to enter cups for month %d? \n", index + 1 );
            answer = kb.nextLine();

            if (answer.equals("N"))
            {
                numCups[index] = 0;
            }
            else if (answer.equals("Y"))
            {
                months++;
                numCups[index] = getData(kb);
            }
            else
                System.out.println("Invalid input, please re-enter.");
        }
        while ((!answer.equals("Y")) && (!answer.equals("N")));
    }
    /* sets a scanner to collect user's input, 
         m is used as a variable to user's input
         validates for good / bad data
         @returns the first valid input
         
      */
    public static int getData(Scanner kb) {
	int m = 0;
        boolean test = true;

        do {
            try {
                System.out.println("Enter the number of cups bought: ");
                m = Integer.parseInt(kb.nextLine());
                
                if (m > 10) {
                    throw new IllegalArgumentException("The number cannot be greater than 10.");
                }

                if (m < 0) {
                    System.out.println("Negative input entered. Please enter a positive number.");
                } else {
                    test = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Decimal or Non-Numeric input entered. Please enter a valid number.");
                test = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                test = false;
            }
        } while (!test);

        return m;
}     /** validate users input x  0
         @param x, user's input
         @return t, if valid = true , returns false if invalid 
         
       */ 
    public static boolean validater(int x)
    {
        boolean t;
		//validate the data 
      if (x >= 0)
			t = true;
		else
			t = false;
		return t;
    }
//
//@param months, avgCups, JassoPointsEarnedC
    public static void checkVolumeBonus(int months, double averageCups, JassoPointsEarnedC numPoints)
    {
        if (months >= 3 && averageCups >= 5.1)
        {
            int bonusPoints = 9;
            System.out.println("Congratulations! You qualify for the volume bonus.");
            System.out.println("You have earned an additional " + bonusPoints + " bonus points.");
            numPoints.addPoints(bonusPoints);
        }
    }
   //displays the points! :)
    public static void displayPoints(JassoPointsEarnedC numPoints)
    {
        System.out.printf("Your points are %.3f", numPoints.getPointsEarned());
    }
}
/*
No loyalty test data. 

N, N, N , N ,(Y1),N, N = 1 = Valid + result = 2.000
N, N, N, N, N, N, (Y, -1),= Invalid data entered, please try again + Enter the number of cups bought
N, N, N, N, N, N, (Y, -1000)  = Invalid data entered, please try again + Enter the number of cups bought 
N, N, N, N, N, N, (Y,1000) = Invalid
N, N, N, N, N, N, (Y,100)  = Invalid 
N, N, N, N, N, N, (Y,-100) = Invalid data entered, please try again + Enter the number of cups bought2 = Valid + result = 5.150
N, N, N, N, N, N, (Y,3) = Valid + result = 8.249 
N, N, N, N, N, N, (Y,4) = Valid + result = 11.555
N, N, N, N, N, N, (Y,5) = Valid + result = 14.925
N, N, N, N, N, N, (Y,0) = Valid + result = 0.000

YES LOYALTY. test data.
Y, N, N, N, N , N , (Y,1) = Valid + result = 12.000
Y, N, N, N, N , N , (Y,3) = Valid + result = 18.249
Y, N, N, N, N , N , (Y,4) = Valid + result = 21.555
Y, N, N, N, N , N , (Y,5) = Valid + result = 24.925
Y, N, N, N, N , N , (Y,0) = Valid + result = 10.000
Y, N, N, N, N , N , (Y,-1) = Welcome to the loyal program + Your points is 10.000 + (when entering -1) Invalid input, please re-enter.
Y, N, N, N, N , N , (Y,-1000) = Welcome to the loyal program + Your points is 10.000 + (when entering -1000) Invalid input, please re-enter.
Y, N, N, N, N , N , (Y,-100) = Welcome to the loyal program + Your points is 10.000 + (when entering -100) Invalid input, please re-enter.

Volume Bonus Test Data 
N, (Y,5), (Y,5), (Y,5), (Y,5), N, N = 59.700
N, (Y,6), (Y, 7), (Y, 7), N, N, N = 68.700
N, (Y,10), (Y,10), N, N, N, N = 59.700
*/