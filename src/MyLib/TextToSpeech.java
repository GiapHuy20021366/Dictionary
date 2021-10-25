package MyLib;
import com.mysql.cj.x.protobuf.MysqlxConnection.Close;
import com.voicerss.tts.*;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.plaf.basic.BasicPasswordFieldUI;

public class TextToSpeech extends Thread{
	private static Player player = null;
    public static boolean playerIsPlaying = true;
    public static String voicessAPIKey = "";
    public static void downloadEnglishVoice(String word, String voiceName, int speed) {
    	new TextToSpeech(word, "English", voiceName, speed, word).start();
    }
    
    public static void speech(String voiceName, int speed, String keyPath) throws Exception {
    	new Thread(new Runnable() {
    		@Override
    		public void run() {
    			if (player != null) {
    	    		player.close();
    	    	}
    	    	String path = ".//MP3//"+keyPath+voiceName+speed+".mp3";
    	    	File file = new File(path);
    	    	if (!file.exists()) {
    	    		return;
    	    	}
    	    	FileInputStream fileInputStream = null;
				try {
					fileInputStream = new FileInputStream(path);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
				try {
					player = new Player(fileInputStream);
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					playerIsPlaying = true;
					player.play();
					playerIsPlaying = false;
				} catch (JavaLayerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
    		}
    	}).start();
    	
    }
    
    public static void closePlayer() {
    	if (player != null) {
    		player.close();
    		playerIsPlaying = false;
    	}
    }
    
    private String word ="";
    private String language ="";
    private String voiceName = "";
    private Integer speed = 0;
    private String keyPath ="";
    public TextToSpeech(String word, String language, String voiceName, int speed, String keyPath) {
    	this.language = language;
    	this.word = word;
    	this.voiceName = voiceName;
    	this.speed = speed;
    	this.keyPath = keyPath;
    }
    
    public static void dowloadVoiceText(String text, String language, String voiceName, int speed) {
    	if (text == null || text.trim().length() < 1) {
    		return;
    		//n
    	} 
    	new TextToSpeech(text, language, voiceName, speed, buildPathKey(text)).start();
    }
    
    public static String buildPathKey(String text) {
		StringBuilder builder = new StringBuilder();
		if (text.length() <= 10) {
			for (int i = 0; i < text.length() ;i++) {
				builder.append((int) text.charAt(i));	
			}
			return builder.toString();
		}
		builder.append(text.length());
		builder.append(text.charAt(0));
		builder.append(text.charAt(text.length() - 1));
		builder.append(text.charAt(text.length()/2));
		builder.append(text.charAt(text.length()/3));
		builder.append(text.charAt(text.length()/4));
		return builder.toString();
	}
    public static void downloadVoiceWord(String word, String language, String voiceName, int speed, String keyPath) throws Exception {
    	String path = ".//MP3//"+keyPath+voiceName+speed+".mp3";
    	File file = new File(path);
    	if (file.exists()) {
    		return;
    	}
    	writeBytes(word, language, voiceName, speed, path);
    }
    private static void writeBytes(String word, String language, String voiceName, int speed, String path) throws Exception {
    	VoiceProvider tts = new VoiceProvider(voicessAPIKey);
    	VoiceParameters params = new VoiceParameters(word, Languages.codeVoiceOf(language));
    	params.setCodec(AudioCodec.MP3);
        params.setFormat(AudioFormat.Format_44KHZ.AF_44khz_16bit_stereo);
        params.setBase64(false);
        params.setSSML(false);
        params.setRate(speed);
    	params.setVoice(voiceName);
    	 byte[] voice = tts.speech(params);
         FileOutputStream fos = new FileOutputStream(path);
         fos.write(voice, 0, voice.length);
         fos.flush();
         fos.close();
    }
    @Override
    public void run() {
    	try {
			downloadVoiceWord(word, language, voiceName, speed, keyPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
