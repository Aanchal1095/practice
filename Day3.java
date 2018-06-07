import java.util.Scanner;
import java.io.*;
import java.math.*;
public class Day3 {

    public  static void  main (String args[])throws Exception
    {

        Scanner sc = new Scanner((System.in));
        double a = sc.nextDouble();
        int b =sc.nextInt();
        int c=sc.nextInt();
        double si = (a*b*c)/100;
        int ans=(int)Math.round(si);
        System.out.println(ans);




    }
}
