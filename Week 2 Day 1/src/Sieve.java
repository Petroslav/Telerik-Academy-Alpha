	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;
	import java.util.stream.Collectors;
	import java.util.stream.Stream;
	
	public class Sieve {
	
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			sc.close();
			ArrayList<Integer> primes = findPrimes(n);
			
			for(int a : primes) {
				if(a == 0) {
					continue;
				}
				System.out.print(a + " ");
			}
		}
		
		public static ArrayList<Integer> findPrimes(int n){
			List<Boolean> list = Stream.generate(() -> true)
					.limit(n+1)
					.collect(Collectors.toList());
			
			list = isPrime(list);		
			
			return collectPrimes(list);
		}
		
		public static ArrayList<Integer> collectPrimes(List<Boolean> list){
			ArrayList<Integer> primes = new ArrayList<Integer>(list.size());
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i)) {
					primes.add(i);
				}
			}
			return primes;
		}
		
		public static List<Boolean> isPrime(List<Boolean> list){
			
			for(int i = 2; i < list.size(); i++) {
				if(!list.get(i)) {
					continue;
				}
				for(int j = i + i; j < list.size(); j += i) {
					list.set(j, false);
				}
			}
			
			return list;
		}
	}
