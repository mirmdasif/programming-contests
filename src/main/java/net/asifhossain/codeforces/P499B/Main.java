package net.asifhossain.codeforces.P499B;

import java.util.*;
import java.io.*;

public class Main {

    Map<String,String> mappings = new HashMap<>();
    List<String> inputLecture= new LinkedList<>();
    List<String> outputLecture = new LinkedList<>();
    
    int nWordsLecture;
    int mWordsLanguage;
    public Main() {

    }

    public void solve() {
        
        for (String word : inputLecture) {
            
            String mappedWord = mappings.get(word);
            
            if(word.length() <= mappedWord.length()) {
                
                outputLecture.add(word);
            } 
            else {
                
                outputLecture.add(mappedWord);
            }
        }
    }
    
    public void parseInput() throws IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String line = reader.readLine();
        readWordsSizes(line);
        
        mapLanguageWords(reader);
                
        readLectureWords(reader);
        
    }

    private void readLectureWords(BufferedReader reader) throws IOException {

        String line;
        line = reader.readLine();

        String[] lectureWords = line.split("\\s+");
        for (String word : lectureWords) {
            inputLecture.add(word);
        }

    }

    private void mapLanguageWords(BufferedReader reader) throws IOException {
        for(int i=0;i<mWordsLanguage;i++) {

            String line = reader.readLine();
            String [] words = line.split("\\s+");
            mappings.put(words[0],words[1]);
            mappings.put(words[1],words[0]);
        }
    }

    private void readWordsSizes(String line) {
        String[] tokens = line.split("\\s+");
        nWordsLecture = Integer.parseInt(tokens[0]);
        mWordsLanguage = Integer.parseInt(tokens[1]);
    }

    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.parseInput();
        m.solve();
        m.printOutPut();
    }

    private void printOutPut() {
        
        for (String word : outputLecture) {
            System.out.print(word+" ");
        }
    }
}