package CommandlineVesion;
import java.io.*;
import java.util.*;

public class DictionaryManagement {
    public static void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0 ; i < n; i++) {
            String inputEnglish = sc.nextLine();
            String inputToViet = sc.nextLine();
            Dictionary.words.add(new Word(inputEnglish, inputToViet));
        }
    }
    public static void insertFromFile() throws FileNotFoundException {
        File file = new File("E:\\Dictionary\\src\\dictionaries.txt");
        if (file.exists()) {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String string = sc.nextLine();
                int index = string.indexOf('|');
                if (index == -1) continue;
                String english = string.substring(0, index);
                String vietnamese = string.substring(index +1);
                Dictionary.words.add(new Word(english, vietnamese));
            }
        }
    }
    public static void insertToFile() throws IOException {
        File file = new File("E:\\Dictionary\\src\\dictionaries.txt");
        if(file.exists()) {
            FileWriter writer = new FileWriter(file);
            StringBuilder builder = new StringBuilder();
            for (Word word: Dictionary.words) {
                builder.append(word.word_target +"|"+word.word_explain +'\n');
            }
            writer.write(builder.toString());

            writer.close();
        }
    }
    public static void removeWord(Word temp) {
        Dictionary.words.remove(temp);
    }
    public static void fixWord() {
        Scanner sc = new Scanner(System.in);
        String word_target = sc.nextLine();
        Word temp = new Word(word_target,  "");
        if (Dictionary.words.contains(temp)) {
            Dictionary.words.remove(temp);
            String meaning = sc.nextLine();
            temp.word_explain = meaning;
            Dictionary.words.add(temp);
        }

    }
    public static void dictionaryLookup(String s) {
        for (Word c : Dictionary.words) {
            if (c.word_target.equals(s)) {
                System.out.println(c);
            }
        }
    }

}
