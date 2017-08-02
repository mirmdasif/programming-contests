package net.asifhossain.hackerrank.rodcutting;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < n; i++){
            int number = in.nextInt();
            if(map.get(number) == null) map.put(number, 0);
            map.put(number, map.get(number) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(n);
            n =  n - entry.getValue();
        }
    }
}
