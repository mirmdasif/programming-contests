package com.mirasif.codeforces;

import com.mirasif.codeforces.datastructure.TernaryTrie;

import java.io.*;

/**
 * @author asif.hossain
 * @since 3/1/15
 */
public class Main {
    
    private void parseInput(){}
    private void solve(){}
    private void printOutPut(){}

    public static void main(String args[]) throws IOException {

        TernaryTrie trie = new TernaryTrie();
        
        trie.add("aab");
        trie.add("abbaac");

        System.out.println(trie.contains("aaa"));
        System.out.println(trie.contains("aa"));
        System.out.println(trie.contains("abbaac"));

    }
}
