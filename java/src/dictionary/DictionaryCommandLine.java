package dictionary;

import java.io.File;
import java.io.IOException;

public class DictionaryCommandLine {
    static DictionaryManagement dictManagement= new DictionaryManagement();
    final static File file = new File("./txt/new.txt");

    public static void dictionaryBasic() {
        dictManagement.insertFromCommandline();
    }

    public static void dictionaryAdvance() {
        dictManagement.insertFromFile(file);
        dictManagement.showAllWords();
        dictManagement.dictionaryLookup();
    }
    public static void main(String[] args) {
        //dictionaryBasic();
        dictionaryAdvance();
        /*try {
            dictManagement.dictionaryExportToFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }
}
