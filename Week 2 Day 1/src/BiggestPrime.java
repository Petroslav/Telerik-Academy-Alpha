import java.util.Scanner;

public class BiggestPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		sc.close();
		biggestPrime(n);
	}
	
	public static boolean isPrime(int n) {
		int maxDiv = (int) Math.sqrt(n);
		
		for(int i = 2; i <= maxDiv; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void biggestPrime(int n) {
		for(int i = n; i > 2; i--) {
			if(isPrime(i)) {
				System.out.println(i);
				break;
			}
		}
	}
}
