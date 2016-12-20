package net.asifhossain.hackerrank.SimpleTextEditor;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author asif.hossain
 * @since 12/20/16.
 */
public class TextEditor {

    public static final int APPEND = 1;
    public static final int DELETE = 2;
    public static final int PRINT = 3;
    public static final int UNDO = 4;

    String text;
    Stack<String> stack;

    public TextEditor() {
        stack = new Stack<>();
        text = "";
    }

    public void append(String word) {
        stack.push(text);
        text = text + word;
    }

    public void delete(int numberOfCharacter) {
        stack.push(text);
        text = text.substring(0, text.length() -  numberOfCharacter);
    }

    public void print(int k) {
        System.out.println(text.charAt(k - 1));
    }

    public void undo() {
        if (!stack.isEmpty()) {
            text = stack.pop();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TextEditor textEditor = new TextEditor();

        int numberOfTestCases = sc.nextInt();

        for (int caseNo = 0; caseNo < numberOfTestCases; caseNo++) {
            int action = sc.nextInt();
            if (action == APPEND) {
                textEditor.append(sc.next());
            } else if (action == DELETE) {
                textEditor.delete(sc.nextInt());
            } else if (action == PRINT) {
                textEditor.print(sc.nextInt());
            } else if (action == UNDO) {
                textEditor.undo();
            }
        }
    }
}
