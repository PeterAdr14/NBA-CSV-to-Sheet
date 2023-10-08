package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCSV {
    public static ArrayList GetData(String filePath) throws FileNotFoundException {
        /**
         * Initialize the 2D ArrayList active and set up the file reader
         */
        ArrayList<ArrayList<String>> active = new ArrayList<>();
        Scanner sc = new Scanner(new File(filePath));
        sc.useDelimiter(",");

        /**
         * Fill the 2D ArrayList active with lists representing each player.
         * May need to be adjusted depending on format of the CSV file.
         */

        while (sc.hasNextLine()) {
            ArrayList<String> pnew = new ArrayList<>();
            sc.next();
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            sc.next();
            sc.next();
            sc.next();
            sc.next();
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            sc.next();
            sc.next();
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            sc.next();
            pnew.add(sc.next().replace("\"",""));
            pnew.add(sc.next().replace("\"",""));
            active.add(pnew);
            sc.nextLine();
        }
        sc.close();
        System.out.println("Players Saved");
        return active;
    }
}
