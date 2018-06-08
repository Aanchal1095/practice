import java.io.*;
import java.util.*;
public class Flood84 {

    public static void main(String args[]) throws Exception {
        int n;
        float c;
        ArrayList<Float>[] Coordinates;
        int count=0,tree=0;
        int treecount=0;
        ArrayList<Integer> treenum =new ArrayList<Integer>();
        ArrayList<Integer> treeissue =new ArrayList<Integer>();
        ArrayList<Integer> treenoissue =new ArrayList<Integer>();
        ArrayList<Integer> check =new ArrayList<Integer>();

        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        c = s.nextFloat();
        Coordinates=new ArrayList[n];
        float[][] fullarray = new float[n][4];
        float[] [] treeEd= new float[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                fullarray[i][j] = s.nextFloat();
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
            if(fullarray[0][2] == 0)
                System.out.println(-1);
            else
            System.out.println("0");}
        else {
            for (int i = 0; i < n; i++) {
                ArrayList<Float> position = new ArrayList<Float>();
                for (int j = 0; j < 2; j++) {
                    position.add(fullarray[i][j]);
                }
                Coordinates[i] = position;
            }
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    ArrayList<Float> temp = new ArrayList<>(Coordinates[i]);
                    int a = 0;
                    for (float k : Coordinates[j]) {
                        temp.add(Coordinates[j].get(a));
                        a++;
                    }
                    float dist = euclidian(temp.get(0), temp.get(1), temp.get(2), temp.get(3));
                    if(dist<=c) {
                        treeEd[i][j] = 1f;
                        treeEd[j][i] = 1f;
                    }
                    else
                    {
                        treeEd[i][j] = 0.0f;
                        treeEd[j][i] = 0.0f;
                    }
                }
                treeEd[i][i] = 1f;
            }
           for(int i=0;i<n;i++)
           {
               for(int j=0;j<n;j++)
               {
                   System.out.print(treeEd[i][j]);
                   System.out.print("  ");
               }
               System.out.println();
           }
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
                    if (treeEd[tree][i] == 1) {
                        treecount++;
                        treenoissue.add(i);
                    }
                }
                if (treecount == n)
                    System.out.println(tree);     //1 tree me meet possible
                else {
                    int chance = 0;
                    for (int y = 0; y < treeissue.size(); y++) {
                        int t1 = treeissue.get(y);
                        for (int x = 0; x < treenoissue.size(); x++) {
                            int t2 = treenoissue.get(x);
                            if (treeEd[t1][t2] == 1 && (fullarray[t1][2] + fullarray[t2][2] <= fullarray[t2][3]))
                                chance++;


                        }
                    }
                    if (chance > 0) {
                        System.out.println(tree);
                    } else {
                        System.out.println("-1");
                    }
                    // 1 tree me meet possible but euclidian dist issue
                }
            }else {
                for (int i = 0; i < n; i++) {
                    treecount = 0;
                    //if (fullarray[i][2] != 0) {
                    for (int j = 0; j < n; j++) {
                        //System.out.println(i+" " + j +" " + treeEd[i][j]);
                        if (treeEd[i][j] == 1) {
                            treecount++;
                            treenoissue.add(j);
                        }

                        else if (fullarray[j][2] == 0) { //euclidian dist capacity se more but j tree pe no monkeys
                            treecount++;
                            treenoissue.add(j);
                        }//so we can consider i tree
                       else{
                            treeissue.add(j);
                        }
                    }
                    //System.out.println("treecount " + treecount);
                    if (treecount == n)
                        treenum.add(i);
                    else{
                            int chance = 0;
                            for (int y = 0; y < treeissue.size(); y++) {
                                int t1 = treeissue.get(y);
                                for (int x = 0; x < treenoissue.size(); x++) {
                                    int t2 = treenoissue.get(x);
                                    if (treeEd[t1][t2] == 1 &&y!=x && (fullarray[t1][2] + fullarray[t2][2] <= fullarray[t2][3])) {
                                        chance++;
                                        check.add(x);
                                    }
                                }
                                if(check.size()!=0)
                                    check.add(y);

                                Collections.sort(check);
                            if (chance > 0) {
                                for(int u=0;u<check.size();u++)
                                {
                                    System.out.println(check.get(u)+  " ");
                                }
                                System.out.println();
                            } else {

                                System.out.println("-1");
                            }
                            // 1 tree me meet possible but euclidian dist issue
                        }
                    }
                }
                if(treenum.size()==0)
                {
                    System.out.println(-1);   //doubt
                        }
                    else {
                    for(int z=0;z<treenum.size();z++)
                    {
                        System.out.print(treenum.get(z)+" ");
                    }

                    }
                    // System.out.print(i+" ");
                }
                // System.out.println(treenum); //euclidian dist check kar ke print tree number

            }
        }

    public static float euclidian(float x1,float y1,float x2,float y2)
    {
        float ed;
        ed= (float) Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
        return ed;
    }

}
