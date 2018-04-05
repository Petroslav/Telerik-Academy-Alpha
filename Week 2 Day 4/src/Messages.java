import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Messages {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String message = sc.nextLine();
		String cipher = sc.nextLine();
		
		HashMap<String, String> pattern = new HashMap<String, String>();
		HashSet<String> combos = new HashSet<>();
		
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
//		decipher(pattern, combos, message);
		
		System.out.println(combos.size());
		for(String combo : combos) {
			System.out.println(combo);
		}
	}

	public static void decipher(HashMap<String, String> pattern, HashSet<String> combos, String message) {
		
		if(!hasDigit(message)){
			combos.add(message);
		}
		
		for(int start = 0; start < message.length(); start++) {
			if(!Character.isDigit(message.charAt(start))) {
				continue;
			}
			for(int i = 1; i < message.length(); i++) {
				String check = message.substring(start, i+1);
				if(pattern.containsKey(check)) {
					decipher(pattern, combos, message.replace(check, pattern.get(check)));
				}
			}
		}
		
		return;      
		
	}
	
	public static boolean hasDigit(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) return true;
		}
		return false;
	}
}
