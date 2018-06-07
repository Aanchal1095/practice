import java.io.*;
import java.util.*;


public class BenFinalist {
    static int m;
    static int n;
    static int[] rowlengthtotal = new int[30];
    static int currentrow = 25;
    static int cash;
    static int[] casharray = new int[30];

    public static void main(String args[]) throws Exception {
        int i, j, a, count1 = 0, count2 = 0;
        int[][] fullarray = new int[20][20];

        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        String set;

        if(n>0 && n<21 && m>0&& m<21) {
            for (i = 0; i < n; i++) {
                set = s.next();
                for (j = 0; j < m; j++) {
                    fullarray[i][j] = Character.getNumericValue(set.charAt(j));

                }
            }
        }
        else
        {
            end();
        }
        int counternew = 0;
        while (counternew != n) {
            counternew = 0;
            for (int p = 0; p < n; p++) {
                if (rowlengthtotal[p] == 100) {
                    counternew++;
                }
            }
            if (counternew == n) {
              /*  for (int k = 0; k < n; k++) {
                    //System.out.println(casharray[k]);
                }*/
            } else {
                rowlengthtotal = rowlengthfind(fullarray);
                counternew = 0;
                for (int y = 0; y < n; y++) {
                    if (rowlengthtotal[y] == 0) {
                        rowlengthtotal[y] = 100;
                        counternew++;
                    }
                }
                if (counternew == n)
                    break;
                for (int k = 0; k < n; k++) {
                }
                int min = getMinValue(rowlengthtotal);
                int rowno = rowno(rowlengthtotal, min);
                cash = updatearray(fullarray, rowno, cash);
                casharray[rowno] = cash;
            }
        }
        int money = 0;
        for (int c = 0; c < n; c++) {
            money += (casharray[c] * casharray[c]);

        }
        System.out.println(money);
    }

    public static int getMinValue(int[] inputarray) {
        int minValue;
        minValue = inputarray[0];


        for (int i = 1; i < n; i++) {
            if (inputarray[i] < minValue) {
                minValue = inputarray[i];
            }
        }
        return minValue;
    }

    public static int rowno(int[] inputarray, int min) {
        int row = 0;
        for (int i = 0; i < n; i++) {
            if (inputarray[i] == min) {
                row = i;

            }

        }

        return row;
    }

    public static int[] rowlengthfind(int[][] inputarray) {
        int count2 = 0;
        for (int l = 0; l < n; l++) {
            for (int k = 0; k < m; k++) {
                if (inputarray[l][k] == 1) {
                    count2++;

                }
            }
            rowlengthtotal[l] = count2;
            count2 = 0;
        }
        return rowlengthtotal;
    }

    public static int updatearray(int[][] fullarray, int rowno, int cash) {

        for (int j = 0; j < m; j++) {

            if (fullarray[rowno][j] == 1) {
                fullarray[rowno][j] = 0;
                for (int i = 0; i < n; i++) {
                    fullarray[i][j] = 0;
                }
                if (currentrow == rowno) {
                    cash = cash + 1;
                    casharray[rowno] = cash;
                } else {
                    cash = 0;
                    cash++;
                    casharray[rowno] = cash;
                }
                currentrow = rowno;

                break;
            }

        }
        return cash;
    }
    public static void end()
    {
        System.out.println("error");
    }
}