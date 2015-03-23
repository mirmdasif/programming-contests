package com.mirasif.codeforces.P514C;

import java.io.*;
import java.util.*;

/**
 * @author asif.hossain
 * @since 3/1/15
 */


public class Main {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    
    HashMap<Integer,List<String>> memoryStrings = new HashMap<Integer,List<String>>();
    List<String> queryStrings = new LinkedList<String>();
    List<String>outputMessages = new LinkedList<String>();
    
    private void parseInput() throws IOException {
        
        String line = br.readLine();
        String[] tokens = line.split("\\s");
        int numberOfMemoryStrings = Integer.parseInt(tokens[0]);
        int numberOfQueryStrings = Integer.parseInt(tokens[1]);
        
        for (int i=0; i<numberOfMemoryStrings;i++) {

            line = br.readLine();
            
            List<String>tempList = memoryStrings.get(line.length());
            if (tempList == null) {
                memoryStrings.put(line.length(), tempList = new ArrayList<String>());
            }
            tempList.add(line);
        }
        for (int i=0; i<numberOfQueryStrings;i++) {
            line = br.readLine();
            queryStrings.add(line);
        }
    }
    
    private void solve2() {
        Map<Integer,Integer> memoryStringHashes = new HashMap<Integer, Integer>();

    }
    
    private void solve() {
        for (String query : queryStrings) {
            
            List<String> mappedMemoryStrings = memoryStrings.get(query.length());
            
            String outputMessage = "NO";
            if (mappedMemoryStrings!=null) {
                for (String memoryString : mappedMemoryStrings) {

                    if (levenshteienDistance(memoryString, memoryString.length()
                            , query, query.length())==1) {
                        outputMessage = "YES";
                        break;
                    }
                }
            }

            outputMessages.add(outputMessage);
        }
    }

    private int levenshteienDistance(String memoryString, int length, String query, int length1) {
        
        int count = 0;
        for (int i= 0; i<length;i++) {
            
            if (memoryString.charAt(i)!= query.charAt(i)) {
                count++;
                
            }
        }
        return count;
    }


    private void printOutPut() {
        
        for (String message : outputMessages) {

            System.out.println(message);
        }
    }

    public static void main(String args[]) throws IOException {

        Main m = new Main();
        m.parseInput();
        m.solve();
        m.printOutPut();

    }
}
