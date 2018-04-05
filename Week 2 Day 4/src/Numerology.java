import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Numerology {

	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String start = sc.readLine();
		sc.close();
		int[] count = new int[10];
		wtf(start, count);
		for(int num : count) {
			System.out.print(num + " ");
		}
	}
	
	public static void wtf(String start, int[] count) {
		if(start.length() == 1) {
			count[start.charAt(0) - '0']++;
			return;
		}
		
		for(int i = 0; i < start.length() -1; i++) {
			int a = start.charAt(i) - '0';
			int b = start.charAt(i+1) - '0';
			int c = (a + b) * (a ^ b) % 10;
			
			wtf(start.substring(0, i) + c + start.substring(i+2) , count);
			
		}
	}
}