import java.util.HashSet;
import java.util.Scanner;

public class Expressions {
	public static HashSet<String> expressions = new HashSet<String>();
	public static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String num = sc.nextLine();
		int target = sc.nextInt();
		
		sc.close();
		
		int count = 0;
		wtf(num, "");
		
		for(String line : expressions) {
			int sum = (int) computeAnother(line);
			System.out.println(line + " = " + sum);
			if(sum == target) {
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static boolean checkLine(String line) {
		for(int i = 0; i < line.length()-1; i++) {
			if(i == 0 && line.charAt(i) == '0') {
				if(Character.isDigit(line.charAt(i+1))) {
					return false;
				}else {
					continue;
				}
			}
			char sign = line.charAt(i);
			if(sign == '*' || sign == '-' || sign == '+') {
				char nextChar = line.charAt(i+1);
				if(nextChar == '0' && i+2 < line.length()) {
					if(Character.isDigit(line.charAt(i+2))) {
						return false;
					}
				}				
			}
		}
		return true;
	}

	public static void wtf(String original, String current) {
		for(int i = 0; i < original.length()-1; i++) {
			String s = current + original.substring(0, i+1) + "*";
			wtf(original.substring(i+1), s);
			if(checkLine(s + original.substring(i+1))) expressions.add(s + original.substring(i+1));
			
			s = current +  original.substring(0, i+1) + "+";
			wtf(original.substring(i+1), s);
			if(checkLine(s + original.substring(i+1))) expressions.add(s + original.substring(i+1));
			
			s = current +  original.substring(0, i+1) + "-";
			wtf(original.substring(i+1), s);
			if(checkLine(s + original.substring(i+1))) expressions.add(s + original.substring(i+1));
			
			s = current +  original.substring(0, i+1);
			wtf(original.substring(i+1), s);
			if(checkLine(s + original.substring(i+1))) expressions.add(s + original.substring(i+1));
		}
	}
	
	static double computeAnother(String equation) {
        double result = 0.0;
        String noMinus = equation.replace("-", "+-");
        String[] byPluses = noMinus.split("\\+");

        for (String multipl : byPluses) {
            String[] byMultipl = multipl.split("\\*");
            double multiplResult = 1.0;
            for (String operand : byMultipl) {
                if (operand.contains("/")) {
                    String[] division = operand.split("\\/");
                    double divident = Double.parseDouble(division[0]);
                    for (int i = 1; i < division.length; i++) {
                        divident /= Double.parseDouble(division[i]);
                    }
                    multiplResult *= divident;
                } else {
                    multiplResult *= Double.parseDouble(operand);
                }
            }
            result += multiplResult;
        }

        return result;
    }
}