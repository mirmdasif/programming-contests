package net.asifhossain.codeforces.P550B;

import java.util.*;

/**
 * @author asif.hossain
 * @since 3/1/15
 */
public class PreparingOlympiad {

    int numberOfProblems;
    int maxTotalDiff;
    int minTotalDiff;
    int minDifference;
    List<Integer> difficulty = new ArrayList<Integer>();

    int counter =0;
    
    private void parseInput() {
        Scanner sc = new Scanner(System.in);

        numberOfProblems = sc.nextInt();
        minTotalDiff = sc.nextInt();
        maxTotalDiff = sc.nextInt();
        minDifference = sc.nextInt();

        for (int i = 0; i < numberOfProblems; i++) {
            difficulty.add(sc.nextInt());
        }
    }

    private void solve() {
        for (int i = 0; i < 1 << numberOfProblems; i++) {
            String binaryString =  Integer.toBinaryString(i);
            List<Integer> subSet = new ArrayList<Integer>();
            for (int j =0; j < binaryString.length(); j++) {
                
                if (binaryString.charAt(binaryString.length() -1 - j) == '1') {
                    subSet.add(difficulty.get(j));
                }
            }
            
            if (isWithinConstrain(subSet)) {
                counter++;
            }
        }
    }
    
    boolean isWithinConstrain(List<Integer> subSet) {

        int totalDifficulty = 0;
        for (int difficulty : subSet) {
            totalDifficulty += difficulty;
        }

        if (subSet.size() >= 2) {
            if ((Collections.max(subSet) - Collections.min(subSet)) >= minDifference) {
                if (totalDifficulty >= minTotalDiff && totalDifficulty <= maxTotalDiff) {
                    return true;
                    
                }
            }
        }
        return false;
    }

    private void printOutPut() {
        System.out.println(counter);
    }

    public static void main(String args[]) {
        PreparingOlympiad main = new PreparingOlympiad();
        main.parseInput();
        main.solve();
        main.printOutPut();
    }
}
