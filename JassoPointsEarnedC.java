/* 
10.8.2023
Favio Valentino Jasso 
Prof. Stoll 
Jasso PointsEarnedC*/

//class declration
public class JassoPointsEarnedC
{
   
   //instance field 
   private double pointsEarned;
  
   //No arg Constrcutor  which is intializing pointsEarned
   public JassoPointsEarnedC()
   {
   
      pointsEarned = 0;
   
   }
   //Overloaded Constructor which is that will receive a double and store this value in the points earned instance field
   public JassoPointsEarnedC(double welcomePoints)
   {
   
      pointsEarned =  welcomePoints; 
   }
   /* setter method 
   saves calculated points
   @param cups bought   
   */
   //determine the points earned for each entry and updates the instance field
   public void setMonthsEarned(int [] numCups)
   {
   
      for (int i = 0; i < numCups.length; i++)
         pointsEarned += calcPoints(numCups[i]);
   }
   public void setPointsEarned(int cups)
   {
      pointsEarned += calcPoints(cups);
            
   }
   //overloaded setter method that is converting a string into a int.  
   //@param cups bought 
   public void setPointsEarned(String sCups) 
   {
      int cups = Integer.parseInt(sCups);
      pointsEarned += calcPoints(cups);
   }
   /* getter method 
   @return pointsEarned
   */
   public double getPointsEarned() 
   {
   
      return pointsEarned; 
   
   }
   public void addPoints(double addsPoints) 
   {
      pointsEarned += addsPoints; 
   }
   /* 
   @param number of cups 
   If statments to calculate the number of points earned
   @return the number of points earned after calculation
   */
   private double calcPoints(int numCups)
   {
         //variables 
         double points; 
               
               
               if (numCups >= 5)
            points = 2.895 * numCups;
            else if (numCups == 4)
               points = 11.555;
            else if (numCups == 3) 
               points = 8.249;
            else if (numCups == 2)
               points = 5.15;
            else if (numCups == 1)
               points = 2.00;
            else 
               points = 0;
               
      return points;
   }
}
