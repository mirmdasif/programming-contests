package com.mirasif.codeforces.P514C;

import com.mirasif.codeforces.datastructure.TernaryTrie;

import java.io.*;
import java.util.*;

/**
 * @author asif.hossain
 * @since 3/1/15
 */


public class Main {
    
    TernaryTrie trie = new TernaryTrie();

    public static long[] hashingCoefficients = new long[600000];

    void init() {
        long h=1;
        hashingCoefficients[1] = 1;
        for (int i = 2; i < 600000 ; i++) {
            h = 257*h;
            hashingCoefficients[i] = h;
        }
    }

    public static long clcHash(String s) {

        long h = 0;

        for (int i = s.length(); i>=1 ; i--) {

            h += hashingCoefficients[i] * s.charAt(s.length() - i);
        }

        return h;
    }

    /**
     *  Re-calculate hash in O(1)
     * @param s input string
     * @param hashValue previously calculated hash value
     * @param index index of new character
     * @param ch character replaced
     * @return hash value of string s character at index replaced by ch
     */
    public static long reCalcHash(String s ,long hashValue , int index , char ch ) {

        return hashValue
                - hashingCoefficients[s.length() - index]*s.charAt(index)
                + hashingCoefficients[s.length() - index]*ch;
    }


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    
    HashMap<Long,Long> memoryStrings = new HashMap<Long,Long>();
    List<String> queryStrings = new LinkedList<String>();
    List<String>outputMessages = new LinkedList<String>();
    
    private void parseInput() throws IOException {
        
        String line = br.readLine();
        String[] tokens = line.split("\\s");
        long numberOfMemoryStrings = Integer.parseInt(tokens[0]);
        long numberOfQueryStrings = Integer.parseInt(tokens[1]);
        
        for (int i=0; i<numberOfMemoryStrings;i++) {

            line = br.readLine();
            memoryStrings.put(clcHash(line),0l);

        }
        for (long i=0; i<numberOfQueryStrings;i++) {
            line = br.readLine();
            queryStrings.add(line);
        }
    }

    
    String getResult(String query) {

        char[] chars = {'a', 'b', 'c'};

        long hash = clcHash(query);
        for ( int i = 0; i < 3 ; i++ ) {
            for (int j = 0 ; j < query.length() ; j++ ) {

                if( query.charAt(j) != chars[i]) {
                    long reHash = reCalcHash(query, hash, j, chars[i]);
                    if (memoryStrings.get(reHash) != null) {
                        return  "YES";
                    }
                }
            }
        }
        return "NO";
    }
    
    private void solve() {
        for (String query : queryStrings) {
            outputMessages.add(getResult(query));
        }
    }

    private long levenshteienDistance(String memoryString, long length, String query, long length1) {
        
        long count = 0;
        for (int i= 0; i<length;i++) {
            
            if (memoryString.charAt(i)!= query.charAt(i)) {
                count++;
                
            }
        }
        return count;
    }


    private void prlongOutPut() {
        
        for (String message : outputMessages) {

            System.out.println(message);
        }
    }

    public static void main(String args[]) throws IOException {

        
        Main m = new Main();
        
        m.init();
        m.parseInput();
        m.solve();
        m.prlongOutPut();

    }

    // Trie for strings contain characters 'a' 'b' 'c'
    public class TernaryTrie {

        public static final int NUM_ELEMENTS= 3;

        Node root = new Node();

        public void add(String str) {

            Node currentNode = root;

            for (int i = 0; i < str.length() ; i++) {

                if (currentNode.childNodes[str.charAt(i)-'a'] == null ) {

                    currentNode = currentNode.childNodes[str.charAt(i)-'a'] = new Node();
                }
                else {
                    currentNode = currentNode.childNodes[str.charAt(i)-'a'];
                }
            }
            currentNode.value++;
        }

        public boolean contains(String str) {
            Node currentNode = root;
            for (int i = 0; i < str.length(); i++) {

                int index = str.charAt(i) - 'a';

                if (currentNode.childNodes[index] == null) {

                    return false;
                }
                else  {
                    currentNode = currentNode.childNodes[index];
                }
            }

            return currentNode.value != 0;
        }

        private class Node {
            Node[] childNodes = new Node[NUM_ELEMENTS];
            int value;
        }
    }

}
