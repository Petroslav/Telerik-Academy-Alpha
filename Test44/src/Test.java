
public class Test {

	public static void main(String[] args) {
		int start = 3;
		char b = (char) (start + '0');
		String str = "12sad3";
		System.out.println(start);
		System.out.println((char) start);
		System.out.println(str.indexOf((char) start));
		System.out.println(str.indexOf(b));
	}
}
