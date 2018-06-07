import java.util.Scanner;

public class Day5 {

    public  static  void  main(String args[])
    {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();

        fact(n);

    }
    public static void fact(int n)
    {
        int factnum =n;
       for(int i=1;i<n;i++)
       {
            factnum = factnum*(n-i);
       }

       System.out.println(factnum);

    }
}
