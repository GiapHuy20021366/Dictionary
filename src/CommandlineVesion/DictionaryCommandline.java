package CommandlineVesion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DictionaryCommandline {
    public DictionaryCommandline() {

    }

    public void showAllWords(Set<Word> words) {
        int count = 1;
        for (Word c: words) {
            System.out.println((count++) + " "+ c);
        }
    }
    public void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        showAllWords(Dictionary.words);
    }

    public void dictionaryAdvanced() {
        try {
            DictionaryManagement.insertFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        showAllWords(Dictionary.words);
        DictionaryManagement.dictionaryLookup("Hi");
    }

    public static void dictionarySearcher(String s) {
        for (Word c : Dictionary.words) {
            if (c.word_target.startsWith(s)) {
                System.out.println(c.word_target);
            }
        }
    }
    public static void main(String[] args) throws IOException {DictionaryCommandline ip = new DictionaryCommandline();
        DictionaryManagement.insertFromFile();
        Word s = new Word("Born", "Sinh");
        Dictionary.words.add(s);
//        DictionaryManagement.insertFromCommandline();
//        DictionaryManagement.removeWord(s);
        DictionaryManagement.fixWord();
        DictionaryManagement.insertToFile();
    }
}
