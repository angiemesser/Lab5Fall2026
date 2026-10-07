import java.io.*;
import java.util.Scanner;
/**
* Reads numerical grade sets from an input file, and computes letter grade. Counts
* high/low scores and calculates average, then summary reports to an output file.
* 
* 1) Call getInFile to prompt for and validate the existence of the input file using an input pit
* 2) Call getOutFile to get the target output file name from the user
* 3) Open Scanner and PrintWriter streams in processFile
* 4) Process input file line by line, reading grade values until the -1 sentinel is reached
* 5) Track high score, low score, total sum, grade count and letter grade frequencies
* 6) Calculate the average score for each set and write formatted statistics to the ouput file
* 7) Close all files streams and notify the user upon completion
*
* @author Angie Messer
* @version v1.0
* @since 10/03/2026
*/
public class Grades { 
    
    public static void main (String[] args) throws IOException { 
        String inFile = getInFile();
        String outFile = getOutFile();
        processFile(inFile, outFile);
    }
    /**
    * Uses Scanner to get and return valid input file name
    * @return The verified input file name
    * @throws IOException If file/O operations encounter errors.
    */
    public static String getInFile() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the input file (ie input.txt): ");
        String fileName = keyboard.nextLine().trim();
        File file = new File(fileName);
        
        while (!file.exists()) {
                System.out.println("Input file cannot be found.");
                System.out.print("Enter the name of the input file (ie input.txt): ");
                fileName = keyboard.nextLine().trim();
                file = new File(fileName);
        }
        
        return fileName;
    }
    
    /**
     * Prompts the user and returns the output file name.
     * @return The output file name
     * @throws IOException if I/O error occurs
     */
    public static String getOutFile() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the name of the output file (ie output.txt): ");
        return keyboard.nextLine().trim();
    }
        
        /** 
         * Reads grades line by line, processes statistics for each set,
         * and writes results to the output file.
         * 
         * @param inFile Path to the input file.
         * @param outFile Path to the output file.
         * @throws IOException If file access fails.
         */
         public static void processFile(String inFile, String outFile) throws IOException {
             File file = new File(inFile);
             Scanner fileScanner = new Scanner(file);
             PrintWriter outStream = new PrintWriter(outFile);
             int setNumber = 1;
             
             while (fileScanner.hasNextLine()) {
                 String line = fileScanner.nextLine();
                 if (line.isEmpty()) {
                     continue;
                }
                
                Scanner lineScanner = new Scanner(line);
                
                int countA = 0, countB = 0, countC = 0, countD = 0, countF = 0;
                int total = 0, counter = 0;
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                
                while (lineScanner.hasNextInt()) {
                    int number = lineScanner.nextInt(); 
                    
                    if (number == -1) {
                        break;
                    }
                    
                    counter++;
                    total += number;
                
                    if (number < min) {
                        min = number;
                    }
                    
                    if (number > max) {
                        max = number;  
                    }
                
                    if (number >= 90) {
                        countA++;
                    } else if (number >= 80) {
                        countB++;
                    } else if (number >= 70) {
                        countC++;
                    } else if (number >= 60) {
                        countD++;
                    } else {
                        countF++;
                    }
            }
            lineScanner.close();
            
            outStream.println("Set " + setNumber + " of grades calculated");
             
            if (counter == 0) {
                 outStream.println("No grades to average");
            } else {
                double avg = (double) total / counter; 
            
                outStream.println("Number of As: " + countA);
                outStream.println("Number of Bs: " + countB);
                outStream.println("Number of Cs: " + countC);
                outStream.println("Number of Ds: " + countD);
                outStream.println("Number of Fs: " + countF);
                outStream.println("The high score was: " + max);
                outStream.println("The low score was: " + min);
                outStream.printf("The avg score is: %.1f%n", avg);
            }
            outStream.println();
            setNumber++;
            
        }
        
        fileScanner.close();
        outStream.close();
                
        System.out.println("Grade processing completed");
        System.out.println("You can retrieve the output file at, " + outFile); 
    } 
}