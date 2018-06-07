import  java.io.*;
import java.util.Scanner;

public class Day6 {

    public  static  void  main(String args[]) throws  Exception
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int count=0;
        while (n !=0)
        {
            n=n/10;
            count++;
        }
        System.out.println(count);
    }
}
