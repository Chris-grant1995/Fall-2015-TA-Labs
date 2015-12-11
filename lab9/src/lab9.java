import java.io.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class lab9
{
    public static void main(String[] args) throws FileNotFoundException
    {
        String fileName1 = args[0];
        String fileName2 = args[1];
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        Scanner s1 = new Scanner(file1);
        Scanner s2 = new Scanner(file2);
        match(s1,s2);

    }
    public static void match(Scanner s1, Scanner s2)
    {

        while(s1.hasNext() && s2.hasNext())
        {
            boolean result = false;
            int a = 1;
            String line1 = s1.nextLine().toUpperCase();
            String line2 = s2.nextLine().toUpperCase();
            //Ststem.print.out("letter")
            if (line1.length() > a && line2.length() > a )
            {
                line1 = line1.substring(0,a);
                line2 = line2.substring(0,a);
                if (line1.compareTo(line2)==0)
                {
                    result = true;
                }
            }

            System.out.print("line" + "#" + a + "matching 1 character/s" + result + "**" + line1.toUpperCase() + "**" + line2.toUpperCase() );
            a++;
        }


    }
}
//java prog dat1.txt dat.txt