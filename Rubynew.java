

/*
 * Enter your code here. Read input from STDIN. Print your output to STDOUT.
 * Your class should be named CandidateCode.
 */

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Rubynew {

    public static void main(String args[] ) throws Exception
    {

        int i = 0,b,r,y,g;

        Scanner s=new Scanner(System.in);


        b=s.nextInt();
        r=s.nextInt();
        y=s.nextInt();
        g=s.nextInt();

        Character necklace_len[] = new Character[10000];
        int beads = b+r+y+g;

        for(int n=0;n<=beads;n++)
        {
            //for first bead in necklace
            if(i==0)
            {

                if(b!=0)
                {
                    necklace_len [i]= 'b';
                    b--;
                }
                else if(r!=0)
                {
                    necklace_len [i]='r';
                    r--;
                }

                else if(g!=0)
                {

                    necklace_len [i]='g';
                    g--;
                }
                else if(y!=0)

                {

                    necklace_len [i]='y';
                    y--;
                }

            }


            //if current bead is blue
            if (necklace_len [i] == 'b')
            {
                if(b!=0)
                {
                    addbluebead(necklace_len,b,i);
                    b--;
                    i++;
                }

                else if(r!=0)
                {
                    addredbead(necklace_len,r,i);
                    r--;
                    i++;
                }

                //  continue;
                //i++;

            }

            //if current bead is green
            if (necklace_len[i] == 'g')
            {

                if(g!=0)
                {
                    addgreenbead(necklace_len,g,i);
                    g--;
                    i++;
                }
                else if(y!=0)
                {
                    addyellowbead(necklace_len,y,i);
                    y--;
                    i++;
                }
                //continue;
            }

            //if current bead is red
            if (necklace_len [i] == 'r')
            {

                if(g!=0)
                {
                    addgreenbead(necklace_len,g,i);
                    g--;
                    i++;
                }
                else if(y!=0)
                {
                    addyellowbead(necklace_len,y,i);
                    y--;
                    i++;
                }
                //  continue;
            }

            //if current bead is yellow
            if (necklace_len [i] == 'y')
            {
                if(b!=0)
                {
                    addbluebead(necklace_len,b,i);
                    b--;
                    i++;
                }
                else if(r!=0)
                {
                    addredbead(necklace_len,r,i);
                    r--;
                    i++;
                }
                // continue;
            }



        }


        //necklace length
        System.out.println(i+1);

    }
    //for adding blue bead
    static void addbluebead(Character[] necklace_len, int b, int i)
    {
        necklace_len [i+1]='b';
    }

    //for adding red bead
    static void addredbead(Character[] necklace_len,int r, int i)
    {
        necklace_len [i+1]='r';
    }

    //for adding yellow bead
    static void addyellowbead(Character[] necklace_len,int y, int i)
    {
        necklace_len [i+1]='y';
    }

    //for adding green bead
    static void addgreenbead(Character[] necklace_len,int g, int i)
    {
        necklace_len [i+1]='g';
    }
}

