import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeSet;

public class Messages {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		StringBuilder message = new StringBuilder(sc.nextLine());
		String cipher = sc.nextLine();
		
		sc.close();
		
		HashMap<String, String> pattern = new HashMap<String, String>();
		TreeSet<String> combos = new TreeSet<>();
		
		for(int i = 0; i < cipher.length(); i++) {
			String value = "";
			String key = "";
			if(!Character.isDigit(cipher.charAt(i))) {
				value = Character.toString(cipher.charAt(i));
				for(int j = i+1; j < cipher.length(); j++) {
					if(!Character.isDigit(cipher.charAt(j))) {
						break;
					}
					key += cipher.charAt(j);
				}
				
			}else {
				continue;
			}
			pattern.put(key, value);
		}
		
		decipher(pattern, combos, message);
		
		System.out.println(combos.size());
		for(String combo : combos) {
			System.out.println(combo);
		}
	}

	public static void decipher(HashMap<String, String> pattern, TreeSet<String> combos, StringBuilder message) {
		if(!hasDigit(message)){
			combos.add(message.toString());
		}
		int start = 0;
		for(int i = start; i < message.length(); i++) {
			if(!Character.isDigit(message.charAt(start))) {
				start++;
				continue;
			}
			String check = message.substring(start, i+1);
			if(pattern.containsKey(check)) {
				StringBuilder m2 = new StringBuilder(message);
				decipher(pattern, combos, m2.replace(start, i+1, pattern.get(check)));
			}
		}
		
	}
	
	public static boolean hasDigit(StringBuilder s) {
		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) return true;
		}
		return false;
	}
}