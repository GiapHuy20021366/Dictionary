package MyLib;

import java.util.ArrayList;
import java.util.List;

public class Format {
	public static void main(String[] arvg) {
		String textString = "\r\n"
				+ "Noun\r\n"
				+ "	S: (n) abandonment, forsaking, desertion (the act of giving something up) \r\n"
				+ "	S: (n) desertion, abandonment, defection (withdrawing support or help despite allegiance or responsibility) \"his abandonment of his wife and children left them penniless\"\r\n"
				+ "	S: (n) abandonment (the voluntary surrender of property (or a right to property) without attempting to reclaim it or give it away) ";
		String string = formatForInformations(textString, 40);
	}
	public static String formatForInformations(String text, int length) {
		
		List<String> list = new ArrayList<>();
		int index1 = text.indexOf('\n');
		int index2 = text.indexOf('\n', index1 + 1);
		while(index1 != -1 && index2 != -1) {
			String string = text.substring(index1+1, index2 - 1);
			list.add(string);
			index1 = index2;
			index2 = text.indexOf('\n', index1 + 1);
		}
		if (index1 < text.length() -1) {
			list.add(text.substring(index1 + 1));
		}
		StringBuilder builder = new StringBuilder();
		for (String string : list) {
			System.out.println(string);
			int begin =0;
			for (int i = 0 ; i < string.length() / length; i++ ) {
				int index = string.indexOf(' ', i * length);
				builder.append(string.substring(begin, index) + "\n\t");
				begin = index + 1;
			}
		}
		System.out.println(builder.toString());
		return null;
	}
}
