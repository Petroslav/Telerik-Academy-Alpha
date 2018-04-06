import java.util.Scanner;
import java.util.TreeSet;

public class Girls {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//shirts
		int k = sc.nextInt();
		sc.nextLine();
		//skirts
		String l = sc.nextLine();
		//girls
		int n = sc.nextInt();
		
		sc.close();
		
		TreeSet<String> combos = new TreeSet<String>();

		findWays(combos, l, k, n, "");

		System.out.println(combos.size());
		for(String combo : combos) {
			System.out.println(combo);
		}
	}

	public static void findWays(TreeSet<String> combos, String skirts, int shirts, int girls, String combo) {
		if(combo.length() > (girls*3)-1) {
			combos.add(combo.substring(0, girls*3-1));
			return;
		}
		int start = 0;
		if(combo.length() >= 3) {
			start = combo.charAt(combo.length()-3) - '0' + 1;
		}
		for(int shirt = start; shirt < shirts; shirt++) {
			for(int skirt = 0; skirt < skirts.length(); skirt++) {
				if(skirts.charAt(skirt) == '='){
					continue;
				}

				char s = skirts.charAt(skirt);
				String test = String.valueOf(shirt) + s + "-";
				findWays(combos, skirts.substring(0, skirt) + "=" + skirts.substring(skirt+1), shirts, girls, combo.concat(test));				
			}
		}
	}
}