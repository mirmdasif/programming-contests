package com.mirasif.codeforces;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author asif.hossain
 * @since 3/1/15
 */
public class Main {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedOutputStream writer = new BufferedOutputStream(System.out);
    
    private void parseInput() throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            writer.write((line + "\n").getBytes());
        }
        writer.flush();
    }

    private void solve() {
    }

    private void printOutPut() {
    }

    public static void main(String args[]) throws IOException {
        Main main = new Main();
        
        main.parseInput();
        main.solve();
        main.printOutPut();

    }
}
