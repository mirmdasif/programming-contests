package com.mirasif.codeforces.P514C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author asif.hossain
 * @since 3/1/15
 */


public class AcWithTries {
    
    TernaryTrie trie = new TernaryTrie();
    
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
            trie.add(line);
        }
        for (long i=0; i<numberOfQueryStrings;i++) {
            line = br.readLine();
            queryStrings.add(line);
        }
    }

    String getResult(String query) {
        
        if (trie.contains(query)) {
            return "YES";
            
        }
        else 
            return "NO";
    }
    
    private void solve() {
        for (String query : queryStrings) {
            outputMessages.add(getResult(query));
        }
    }



    private void printOutPut() {
        
        for (String message : outputMessages) {

            System.out.println(message);
        }
    }

    public static void main(String args[]) throws IOException {

        
        AcWithTries m = new AcWithTries();
        
        m.parseInput();
        m.solve();
        m.printOutPut();

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


        public boolean dfsSearch(Node node, String str, int countChange, int depth) {

            if (str.length() == depth) {

                if (node.value > 0 && countChange == 1) {
                    return true;
                }
                else {
                    return false;
                }
            }

            for (int i=0; i < NUM_ELEMENTS; i++) {

                int changeInCurrentSubTree = countChange;

                if (node.childNodes[i] == null)
                    continue;

                if (str.charAt(depth) != 'a'+i) {
                    changeInCurrentSubTree++;
                }

                // Subtree with only one change is allowed
                if (changeInCurrentSubTree<2) {
                    if (dfsSearch(node.childNodes[i],str,changeInCurrentSubTree,depth+1)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean contains(String str) {
            return dfsSearch(root,str,0,0);
        }

        private class Node {
            Node[] childNodes = new Node[NUM_ELEMENTS];
            int value;
        }
    }
}
