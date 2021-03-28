package dictionary;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;

public class DictionaryManagement {
    Dictionary dict;

    public DictionaryManagement() {
        this.dict = new Dictionary();
    }

    public void insertFromCommandline() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhập số lượng word: ");
        int nums = scan.nextInt();scan.nextLine();
        for (int i = 0; i < nums; i++) {
            System.out.println("Word " + (i + 1) + " ----------");
            System.out.println("Nhap word target ");
            String target = scan.nextLine();
            System.out.println("Nhap word explain ");
            String explain = scan.nextLine();
            dict.addWords(target, explain);
        }
        scan.close();
    }

    public void insertFromFile(File file) {
        try {
            Scanner scan = new Scanner(file);
            String[] wordsArray;

            while (scan.hasNext()) {
                String curLine = scan.nextLine();
                wordsArray = curLine.split("\\s+");
                dict.addWords(wordsArray[0], wordsArray[1]);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void dictionaryLookup() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter word target ");
        String target = scan.nextLine();
        System.out.println(dict.search(target));
        scan.close();
    }

    public void dictionaryExportToFile() throws IOException {
        FileOutputStream fout = new FileOutputStream("./txt/new.txt");
        for (int i = 0; i < dict.words.size(); i++) {
            String row = dict.getWord(i).toString() + "\n"; 
            byte b[] = row.getBytes();
            fout.write(b); 
        }
        fout.close();
    }

    public void showAllWords() {
        System.out.println("No --- English --- Vietnamese");
        for (int i = 0; i < dict.words.size(); i++) { 
            System.out.println(i + "  " + dict.getWord(i));   
        }
    }

    public static void main(String args[]) {
        DictionaryManagement dictManagement = new DictionaryManagement();
        File file = new File("./txt/test.txt");
        dictManagement.insertFromFile(file);
        dictManagement.dictionaryLookup();
        dictManagement.showAllWords();
        /*Dictionary dict = new Dictionary();
        dict.addWords("hello", "chao");
        dict.addWords("love", "yeu");
        System.out.println(dict.search("hello"));
        dict.remove("hello");
        dict.modify("love", "fuck");*/
    }
}
