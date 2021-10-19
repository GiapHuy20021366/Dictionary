package MyLib; 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Translator extends Thread{

    public static String googleScriptLink = "";
    public static String translatedText = "";
    public static String fromLanguage = "";
    public static String toLanguage = "";
    public static String textNeedTranslate;
    public Translator(String _fromLanguage,  String _toLanguage, String text) {
        fromLanguage = Languages.codeOf(_fromLanguage);
        toLanguage = Languages.codeOf(_toLanguage);
        textNeedTranslate = text;
    }
    public static void main(String[]a) throws IOException {
    	System.out.println(translate("English", "Azeri", "hello"));
    }
    public static String translate( String fromLanguage,  String toLanguage, String text) throws IOException {
    	API.setAPI();
    	 fromLanguage = Languages.codeOf(fromLanguage);
         toLanguage = Languages.codeOf(toLanguage);
        String urlAPI =   googleScriptLink +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + toLanguage +
                "&source=" + fromLanguage;
        URL url = new URL(urlAPI);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            if(inputLine.startsWith("<!DOCTYPE")) {
                if (fromLanguage == toLanguage) {
                    return text;
                }
                return "Maybe you choose the wrong input language";
            }
        }
        in.close();
        return response.toString();
    }

    @Override
    public void run() {
    	translatedText = "";
        try {
            translatedText = translate(fromLanguage, toLanguage, textNeedTranslate );
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }
}