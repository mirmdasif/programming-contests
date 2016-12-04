package net.asifhossain.codeforces.P530C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * @author asif.hossain
 * @since 4/2/15
 */
public class DiophantineEquation {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    double A,B,C;
    int xMax,xMin;

    
    class XYValues {
        int x;
        int y;

        XYValues(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x+" "+y;
        }
    }
    List<XYValues> xyValues = new LinkedList<XYValues>();

    private void parseInput() throws IOException {

        String line = br.readLine();
        String[] token = line.split("\\s+");

        A = Integer.parseInt(token[0]);
        B = Integer.parseInt(token[1]);
        C = Integer.parseInt(token[2]);
    }

    private void solve(){
        xMax = (int) (C/A);
        xMin = 1;

        for (int x=xMin; x <= xMax; x++) {

            double y = (C-A*x)/B;
            
            if (y == Math.floor(y)) {
                xyValues.add(new XYValues(x,(int) y));
            }
        }

    }
    private void printOutPut(){
        System.out.println(xyValues.size());
        
        for (XYValues xyValue : xyValues) {

            System.out.println(xyValue.toString());
        }
    }

    
    public static void main(String[] args) throws IOException {
        
        DiophantineEquation diophantineEquation = new DiophantineEquation();
        
        diophantineEquation.parseInput();
        diophantineEquation.solve();
        diophantineEquation.printOutPut();
        
    }
}
