package net.asifhossain.codechef.videogame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputLine = br.readLine().split("\\s");

        int n = Integer.parseInt(inputLine[0]);
        int maxSize = Integer.parseInt(inputLine[1]);
        int[] stacks = new int[n];

        inputLine = br.readLine().split("\\s");

        for (int i = 0; i < n; i++) {
            stacks[i] = Integer.parseInt(inputLine[i]);
        }

        Crane crane = new Crane(maxSize, stacks);

        inputLine = br.readLine().split("\\s");

        for (int i = 0; i < inputLine.length; i++) {
            switch (inputLine[i]) {
                case "0":
                    crane.print();
                    return;
                case "1":
                    crane.moveLeft();
                    break;
                case "2":
                    crane.moveRight();
                    break;
                case "3":
                    crane.pick();
                    break;
                case "4":
                    crane.drop();
            }
        }

        crane.pick();
        crane.print();
    }

    static class Crane {
        private int maxSize;
        private int[] stacks;
        private int cranePosition;
        private boolean boxInCrane;

        Crane(int maxSize, int[] stacks) {
            this.maxSize = maxSize;
            this.stacks = stacks;
            this.cranePosition = 0;
            boxInCrane = false;
        }

        void print() {
            for (int i = 0; i < stacks.length - 1; i++) {
                System.out.print(stacks[i] + " ");
            }

            System.out.println(stacks[stacks.length - 1]);
        }

        void moveLeft() {
            if (cranePosition == 0) return;
            cranePosition--;
        }

        void moveRight() {
            if (cranePosition == stacks.length - 1) return;
            cranePosition++;
        }

        void pick() {
            if (boxInCrane) return;
            if (stacks[cranePosition] == 0) return;

            boxInCrane = true;
            stacks[cranePosition] = stacks[cranePosition] - 1;
        }

        void drop() {
            if (!boxInCrane) return;
            if (stacks[cranePosition] == maxSize) return;

            stacks[cranePosition] = stacks[cranePosition] + 1;
            boxInCrane = false;
        }
    }
}