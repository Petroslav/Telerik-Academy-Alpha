import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class BitConert {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		
		String numbers = read.readLine();		
		String[] nums = numbers.split(",");
		int[] toCompare = new int[nums.length];
		
		for(int i = 0; i < nums.length; i++) {
			int number = Integer.parseInt(nums[i]);
			String s = Integer.toString(number, 2);
			toCompare[i] = number;
			nums[i] = getExtraBits(s);
			System.out.print(cleanUp(nums[i], i));
		}
//		
//		for(String s : nums) {
//			System.out.println(s);
//		}

		
	}
	
	private static String cleanUp(String string, int pos) {
		String cleanedUp = "";
		if(pos % 2 == 0) {
			pos = 1;
		}else {
			pos = 0;
		}

		for(int i = pos; i < string.length(); i += 2) {
			cleanedUp += string.charAt(i);
		}
		
		return cleanedUp;
	}

	public static String getExtraBits(String s) {
		int extra = 0;
		while((s.length() + extra)% 8 != 0) {
			extra ++;
		}
		String extraBits = "";
		while(extraBits.length() < extra) {
			extraBits += "0";
		}
		return extraBits + s;
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
	           return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == ',' || c == -1;
	       }
	   }

}
