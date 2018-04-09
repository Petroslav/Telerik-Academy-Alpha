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
		boolean[] shirts = new boolean[k];
		
		sc.close();
		
		TreeSet<String> combos = new TreeSet<String>();

		findWays(combos, l, shirts, n, "");

		System.out.println(combos.size());
		for(String combo : combos) {
			System.out.println(combo);
		}
	}

	public static void findWays(TreeSet<String> combos, String skirts, boolean[] shirts, int girls, String combo) {
		if(dashCount(combo) == girls) {
			combos.add(combo.substring(0, combo.length()-1));
			return;
		}
		int start = 0;
		for(int i = 0; i < shirts.length; i++) {
			if(shirts[i]) start = i + 1;
		}
		for(int shirt = start; shirt < shirts.length; shirt++) {
			shirts[shirt] = true;
			for(int skirt = 0; skirt < skirts.length(); skirt++) {
				if(skirts.charAt(skirt) == '='){
					continue;
				}

				char s = skirts.charAt(skirt);
				String test = String.valueOf(shirt) + s + "-";
				findWays(combos, skirts.substring(0, skirt) + "=" + skirts.substring(skirt+1), shirts, girls, combo.concat(test));				
			}
			shirts[shirt] = false;
		}
	}
	
	public static int dashCount(String s) {
		int dashes = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '-') dashes++;
		}
		
		return dashes;
	}
}