import java.io.*;
import java.util.Scanner;

public class Day4 {

    public  static  void  main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();

        if(n<10)
            System.out.println("I am happy as having no responsibilities.");
        else if(n>=10 && n<18)
            System.out.println("I am still happy but starts feeling pressure of life.");
        else
            System.out.println("I am very much happy as i handled the pressure very well.");




    }

}
