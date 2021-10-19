package MyLib; 
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class TestFuntion {
    public static void main(String[] args) throws IOException {
    	Languages.loadLanguages();
    	Boolean isSupported = Languages.isSupportVoiceInVietnamese("Tiếng Azeri");
    	System.out.println(isSupported);
    }
    public static String translate() throws IOException {
        String urlAPI = "http://wordnetweb.princeton.edu/perl/webwn?s=game&sub=Search+WordNet&o2=&o0=1&o8=1&o1=1&o7=&o5=&o9=&o6=&o3=&o4=&h=000000000000";
        URL url = new URL(urlAPI);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
            if(inputLine.startsWith("<!DOCTYPE")) {
                return "Maybe you choose the wrong input language";
            }
        }
        in.close();
        return response.toString();
    }
    public static void get() throws IOException {
        String urlAPI = "http://wordnetweb.princeton.edu/perl/webwn?s=kind&sub=Search+WordNet&o2=&o0=1&o8=1&o1=1&o7=&o5=&o9=&o6=&o3=&o4=&h=000000000000";
        URL url = new URL(urlAPI);
        InputStream is = url.openStream(); //fURL can be one of the links above
        BufferedReader buffer = null;
        buffer = new BufferedReader(new InputStreamReader(is, "iso-8859-9"));

        StringBuilder builder = new StringBuilder();
        int byteRead;
        while ((byteRead = buffer.read()) != -1) {
            builder.append((char) byteRead);
        }
        buffer.close();
        System.out.println(builder.toString());
    }
}
