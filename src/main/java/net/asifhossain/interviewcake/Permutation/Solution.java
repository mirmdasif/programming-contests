package net.asifhossain.interviewcake.Permutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author asif.hossain
 * @since 11/1/17.
 */
public class Solution {
    public static void main(String[] args) {
        Set<String> perms = permutation("123");
        System.out.println(perms);
    }

    private static Set<String> permutation(String str) {
        List<Character> characters = str.chars().mapToObj(value -> (char) value).collect(Collectors.toList());
        return permutation(characters);
    }

    private static Set<String> permutation(List<Character> characters) {
        if (characters.isEmpty()) {
            Set<String> emptyStringSet = new HashSet<>();
            emptyStringSet.add("");

            return emptyStringSet;
        }

        Set<String> strings = new HashSet<>();
        for (int i = 0; i < characters.size(); i++) {
            List<Character> tempChars = new LinkedList<>(characters);
            char firstChar = tempChars.get(i);
            tempChars.remove(i);
            Set<String> stringSet = permutation(tempChars);

            for (String s : stringSet) {
                strings.add(firstChar + s);
            }
        }

        return strings;
    }
}
