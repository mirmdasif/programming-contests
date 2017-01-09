package net.asifhossain.hackerrank.TriesContacts;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author asif.hossain
 * @since 1/8/17.
 */
public class TriesContacts {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Trie trie = new Trie();

        int n = Integer.parseInt(sc.nextLine());

        for (int i =0; i < n; i++) {
            String line = sc.nextLine();

            String[] tokens = line.split("\\s");

            if ("add".equals(tokens[0])) {
                trie.insertWord(tokens[1]);
            } else {
                trie.find(tokens[1]);
            }
        }
    }
}

class Trie {
    int count;

    Map<Character, Trie> map = new HashMap<>(26);

    public void insertWord(String word) {

        Trie temp = this;

        for (int i =0; i < word.length(); i++) {
            Trie node = temp.map.get(word.charAt(i));

            if (node == null) {
                node = new Trie();
            }

            node.count++;

            temp.map.put(word.charAt(i), node);

            temp = node;
        }
    }

    public void find(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); i++) {
            temp = temp.map.get(word.charAt(i));
            if (temp == null) {
                System.out.println(0);
                return;
            }
        }

        System.out.println(temp.count);
    }
}
