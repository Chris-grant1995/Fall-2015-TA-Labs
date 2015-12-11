/**
 * Created by Chris on 11/6/15.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class lab9InClass {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName1 = args[0];
        String fileName2 = args[1];
        File f1 = new File(fileName1);
        File f2 = new File(fileName2);
        Scanner scan1 = new Scanner(f1);
        Scanner scan2 = new Scanner(f2);
        //Here you have String representations of the filenames.
        //Create new file objects with these two filenames.
        //Open those two files in two scanners.
        //Pass those scanners to the compareFiles method.
        compareFiles(scan1, scan2);
    }


    public static void compareFiles(Scanner scan1, Scanner scan2){
        //Create an integer that represents the line number and number of characters that you are comparing.
        //While  scan1.hasNext() == true and while scan2.hasNext() == true
            //Create a boolean that represents whether or not the strings match.
            //Create 2 strings, one that is scan1.nextLine() and another that is scan2.nextLine()
            //Check if the lengths of the first and second string are greater than the number of
            //characters you are reading in

                //If they are, set the string equal to the substring of the string from 0
                // and the number of characters


            //Compare the strings see the last lab on how to do this

            //Print out the output as shown in the lab description

            //Increment the counter

    }
}