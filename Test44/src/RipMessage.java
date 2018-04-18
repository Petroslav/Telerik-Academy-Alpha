import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RipMessage {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		String toPrint = read.readLine();
		
		decode(toPrint);		
	}

	private static int decode(String toPrint) {
		int index = 0;
		int end = 1;
		int subStart = -1;
		if(Character.isDigit(toPrint.charAt(0))) {
			subStart = toPrint.indexOf('{');
			end = findDigit(toPrint);
		}
		if(subStart != -1) {
			toPrint = toPrint.substring(subStart);
		}
		for(int i = 0; i < end; i++) {
			for(int j = 0; j < toPrint.length(); j++) {
				if(Character.isDigit(toPrint.charAt(j))){
					j += decode(toPrint.substring(j, toPrint.lastIndexOf('}')+1));
					break;
				}
				if(toPrint.charAt(j) == '{') {
					continue;
				}
				if(toPrint.charAt(j) == '}') {
					if(i < end - 1) {
						index = j;
						break;
					}else {
						continue;
					}
				}
				System.out.print(toPrint.charAt(j)); 			
			}
		}
		
		return index;
	}

	public static int findDigit(String s) {
		int num = 0;
		
		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				num *= 10;
				int temp = s.charAt(i) - '0';
				num += temp;
			}else {
				break;
			}
		}
		
		return num;
	}
}
