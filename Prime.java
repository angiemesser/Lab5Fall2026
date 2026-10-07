import java.util.Scanner;
/**
* Tests whether an integer is a prime number.
* 1) Prompts user to enter a whole number greater than 2
* 2) Call testForPrime to check divisibility up to the square root of number
* 3) Output whether number is prime or not prime
* 4) Ask the use if they want to test another number
* 5) Repeat the loop if the user enters "yes", exits if the user enters "no"
*
* @author Angie Messer
* @version v1.0
* @since 10/03/2026
*/
public class Prime {
    public static void main (String[] args) {
        boolean isPrime;
        int number;
        String playAgain;
        
        Scanner keyboard = new Scanner(System.in);
        
        do {
            System.out.print("Enter a whole number>2 (ie 19) to test if prime: ");
            number = keyboard.nextInt();
    
            isPrime = testForPrime(number);
    
            if (isPrime) {
                System.out.println(number + " is prime");
            } else {
                System.out.println(number + " is not prime");
            }
    
            System.out.print("Enter yes to test another number, enter no to quit. ");
            playAgain = keyboard.next();
    
        } while (playAgain.equalsIgnoreCase("yes"));
    
        keyboard.close();
    }
    /** Evaluates whether a given whole number is prime.
     * 
     * @param number The whole number (int) to evaluate.
     * @return true if the number is prime; false otherwise.
     */
    public static boolean testForPrime(int number) {
        int limit = (number / 2) +1;
        boolean isPrimeMeth = true; 
    
        for (int i = 2; isPrimeMeth && i <= limit; i++) {
            if (number % i == 0) {
                isPrimeMeth = false;
            }
        }
        return isPrimeMeth;
    }
}