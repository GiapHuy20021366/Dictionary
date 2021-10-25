package MyLib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar;

public class API {
    public static void setAPI() throws FileNotFoundException {
        Translator.googleScriptLink = readAPIKeyFrom("googleScriptLink.txt");
        DectectedLanguageLib.DetectLanguage.apiKey = readAPIKeyFrom("DetectedLanguageAPIKey.txt");
        TextToSpeech.voicessAPIKey = readAPIKeyFrom("VoicessAPIKey.txt");
    }
    
    public static String readAPIKeyFrom(String fileName) throws FileNotFoundException {
    	String pathString = ".\\APIKey\\" + fileName;
    	File file = new File(pathString);
    	Scanner scanner = new Scanner(file);
    	return scanner.next();
    }
}
