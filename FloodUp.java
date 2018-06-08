import java.io.*;
import java.util.*;
public class FloodUp {

    public static void main(String args[]) throws Exception {
        int n;
        double c;
        int[][] fullarray = new int[200][4];
        double [] [] treeEd= new double[200][200];
        ArrayList<Integer>[] Coordinates;
        int count=0,tree=0;
        int treecount=0;
        ArrayList<Integer> treenum =new ArrayList<Integer>();

        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        c = s.nextDouble();
        Coordinates=new ArrayList[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                fullarray[i][j] = s.nextInt();
            }
        }
        String st = s.nextLine();
        while(s.findInLine("(?=\\S)") != null){
            if(s.hasNextLine()) {
                s.nextLine();
            }else
                break;
        }

        if(n==1){
            System.out.println("0");}
        else {
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> position = new ArrayList<Integer>();
                for (int j = 0; j < 2; j++) {
                    position.add(fullarray[i][j]);
                }
                Coordinates[i] = position;
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    ArrayList<Integer> temp = new ArrayList<>(Coordinates[i]);
                    int a = 0;
                    for (int k : Coordinates[j]) {
                        temp.add(Coordinates[j].get(a));
                        a++;
                    }
                    double dist = euclidian(temp.get(0), temp.get(1), temp.get(2), temp.get(3));

                    treeEd[i][j] = dist;
                    treeEd[j][i] = dist;
                }
                treeEd[i][i] = 0;
            }
           /*for(int i=0;i<n;i++)
           {
               for(int j=0;j<n;j++)
               {
                   System.out.print(treeEd[i][j]);
                   System.out.print("  ");
               }
               System.out.println();
           }*/
            for (int i = 0; i < n; i++) {
                if (fullarray[i][3] < fullarray[i][2]) {
                    count++;
                    tree = i;
                }
            }
            if (count > 1)
                System.out.println("-1");   //not possible to meet as 2 trees ka monkeys issue
            else if (count == 1) {
                for (int i = 0; i < n; i++) {
                    if (treeEd[tree][i] < c)
                        treecount++;
                }
                if (treecount == n)
                    System.out.println(tree);     //1 tree me meet possible
                else
                    System.out.println("-1"); // 1 tree me meet possible but euclidian dist issue
            } else {

                for (int i = 0; i < n; i++) {
                    treecount = 0;
                    for (int j = 0; j < n; j++) {
                        if (treeEd[i][j] <= c)
                            treecount++;
                        else if (fullarray[j][2] == 0)
                            treecount++;
                    }
                    if (treecount == n)
                        treenum.add(i);
                }
                if (treenum.isEmpty())
                    System.out.println(-1);
                else
                   // System.out.println(treenum);

            // System.out.println(treenum); //euclidian dist check kar ke print tree number
            for(int z=0;z<n;z++)
            {
                System.out.print(treenum.get(z)+" ");
            }
        }
    }
}
    public static double euclidian(int x1,int y1,int x2,int y2)
    {
        double ed;
        ed=Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
        return ed;
    }

}
