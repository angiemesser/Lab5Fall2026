import java.util.Scanner;
/** 
* Calculates the falling distance of an object over a specified duration in 
* seconds.
* 1) Asks for and accepts users input for number of seconds
* 2) Displays formatted table headers for time and distance
* 3) Loop from 1 to the user specified seconds
* 4) Call getDistance method passing the current second counter as an argument
* 5) Output the formatted time and distance results in a table
* 
* @author Angie Messer
* @version v1.0
* @since 10/03/2026
*/
public class FallingDistance{ 
    public static final double GRAVITY = 9.8;
    
    public static void main(String[] args) {
        
        int numOfSecs;
        double distance;
        
        Scanner keyboard = new Scanner(System.in);
    
        System.out.print("Enter number of seconds to calculate falling distance: ");
        numOfSecs = keyboard.nextInt();
    
        System.out.printf("%-10s %-12s%n","Time(secs)", "Distance(m)");
        System.out.println("========== ============");
    
        for (int sec = 1; sec <= numOfSecs; sec++) {
            distance = getDistance(sec);
            System.out.printf("%-10d %-12.1f%n", sec, distance);
        }
    
        keyboard.close();
    } //end main
    /**
    * Calculates falling distance in meters for a given number of seconds.
    * 
    * @param seconds the number of seconds the object has been falling
    * @return the falling distance in meters
    */
    public static double getDistance(int seconds) {
        
        return 0.5 * GRAVITY * Math.pow(seconds, 2);
    }
}

