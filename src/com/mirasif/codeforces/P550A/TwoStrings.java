package com.mirasif.codeforces.P550A;

import java.io.IOException;
import java.util.Scanner;


public class TwoStrings {

    String str;
    
    public void parseInput() throws IOException {

        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
    }
    public void solve() {

        int indexAB = str.indexOf("AB");
        
        if (indexAB != -1) {
            
            if (str.indexOf("BA",indexAB+2) != -1) {

                System.out.println("YES");
                return;
            }
        }
        
        
        int indexBA = str.indexOf("BA");
        
        if (indexBA != -1) {

            if (str.indexOf("AB",indexBA+2) != -1) {

                System.out.println("YES");
                
                return;
            }
        }

        System.out.println("NO");
    }
    

    private void printOutPut() {

    }



    public static void main(String[] args) throws IOException {
        TwoStrings m = new TwoStrings();
        m.parseInput();
        m.solve();
        m.printOutPut();
    }

}