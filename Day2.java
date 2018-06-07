import  java.io.*;
import java.util.Scanner;

public class Day2 {

    public  static  void main(String args[]) throws  Exception{
        Scanner sc = new Scanner((System.in)) ;

        String s = sc.nextLine();
        String a=s.trim();
        try {
            int i = Integer.parseInt(a);
            System.out.println("This input is of type Integer");

        } catch (NumberFormatException e) {
            try {
                float d = Float.parseFloat(a);
                System.out.println("This input is of type Float");

            } catch (NumberFormatException e2) {

                Object obj=a;

                    if(obj instanceof String)
                    System.out.println("This input is of type string");
                    else
                        System.out.println("This is something else");

                }

            }
        }






    }



