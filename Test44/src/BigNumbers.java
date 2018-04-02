import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class BigNumbers {

	public static void main(String[] args) {
		InputReader read = new InputReader();
		
		ArrayList<Integer> num1 = new ArrayList<>();
		ArrayList<Integer> num2 = new ArrayList<>();
		
		int n = read.readInt();
		int m = read.readInt();
		
		for(int i = 0; i < n; i++) {
			int num = read.readInt();
			num1.add(num);
		}
		
		for (int i = 0; i < m; i++) {
			int num = read.readInt();
			num2.add(num);
		}
		
		BigInteger number1 = BigInteger.valueOf(num1.get(num1.size()-1));
		BigInteger number2 = BigInteger.valueOf(num2.get(num2.size()-1));
		
		int bigger = n >= m ? n : m;
		
		for(int i = bigger-1; i > -1; i--) {
			if(i < n-1) {
				number1 = number1.multiply(BigInteger.valueOf(10));
				number1 = number1.add(BigInteger.valueOf(num1.get(i)));
			}
			if(i < m-1) {
				number2 = number2.multiply(BigInteger.valueOf(10));
				number2 = number2.add(BigInteger.valueOf(num2.get(i)));
			}
		}
		
		BigInteger newNum = number1.add(number2);
		String test = newNum.toString();
		for(int i = test.length()-1; i > -1; i--) {
			System.out.print(test.charAt(i));
			if(i > 0) {
				System.out.print(" ");
			}
		}
		
	}
	
	static class InputReader {
	    private InputStream stream;
	    private byte[] buf = new byte[1024];
	    private int curChar;
	    private int numChars;

	    InputReader() {
	        this.stream = System.in;
	    }

	    int read() {
	        if (numChars == -1)
	            throw new InputMismatchException();
	        if (curChar >= numChars) {
	            curChar = 0;
	            try {
	                numChars = stream.read(buf);
	            } catch (IOException e) {
	                throw new InputMismatchException();
	            }
	            if (numChars <= 0)
	                return -1;
	        }
	        return buf[curChar++];
	    }

	    int readInt() {
	        int c = read();
	        while (isSpaceChar(c)) {
	            c = read();
	        }
	        int sgn = 1;
	        if (c == '-') {
	            sgn = -1;
	            c = read();
	        }
	        int res = 0;
	        do {
	            if (c < '0' || c > '9') {
	                throw new InputMismatchException();
	            }
	            res *= 10;
	            res += c - '0';
	            c = read();
	        } while (!isSpaceChar(c));
	        return res * sgn;
	    }

	    boolean isSpaceChar(int c) {
	        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	    }
	}
}