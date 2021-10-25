package MyLib;
import DectectedLanguageLib.*;
public class DetectLanguage {

	public static void main(String[] args)  {
         //This is my API key. You should use different API key. It's free, but limited request a day.
		DectectedLanguageLib.DetectLanguage.apiKey ="";
        String result = null;
        try {
            result = DectectedLanguageLib.DetectLanguage.detectLanguageOf("Xin chào Việt Nam");
        } catch (APIError e) {
            e.printStackTrace();
        }

        System.out.println("Language: " + Languages.languageInVietnamese(result)); // Output: en (English).
    }
	public static String findLanguage(String text) {
        String result = null;
        try {
            result = DectectedLanguageLib.DetectLanguage.detectLanguageOf(text);
//            result =  Languages.languageInVietnamese(result);
        } catch (APIError e) {
            e.printStackTrace();
        }
        return result;
        //;
	}
}
