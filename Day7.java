
/*
import java.util.Scanner;
public class Day7
{
    public static void main(String args[])
    {
        int up, down, s3, flag = 0, i, j,count=0;
        Scanner s = new Scanner(System.in);
        up = s.nextInt();
        down = s.nextInt();

        for(i = up; i <= down; i++)
        {
            for( j = 2; j < i; j++)
            {
                if(i % j == 0)
                {
                    flag = 0;
                    break;
                }
                else
                {
                    flag = 1;
                }
            }
            if(flag == 1)
            {
                count++;
            }
        }
        System.out.println (count);
    }
}*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Day7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int up = scanner.nextInt();
        int down = scanner.nextInt();
        List<Integer> primes = new ArrayList<>();

        // loop through the numbers one by one
        for(int k=up;k<=down;k++) {
            for (int i = 2; i < k; i++) {
                boolean isPrimeNumber = true;

                // check to see if the number is prime
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrimeNumber = false;
                        break; // exit the inner for loop
                    }
                }

                // print the number if prime
                if (isPrimeNumber) {
                    primes.add(i);
                }
            }
        }

        System.out.println("The number of prime is: " + primes.size() + ", and they are: " + primes.toString());
    }
}
