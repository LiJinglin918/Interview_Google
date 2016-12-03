import java.util.*;
public class StringDash {
	public static void main(String[] args) {
		System.out.println(new StringDash().input("sdfsdf", 8));
	}
	public String input (String s, int k) {
		if (s == null || s.length() <= 0 || k <= 0)
			return s;
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '-') {
				sb1.append(s.charAt(i));
			}
		}
		int len = sb1.length();
		int firstGroupSize = len % k;
		
		int i = 0;
		while (i < firstGroupSize) {
			sb2.append(sb1.charAt(i));
			i++;
		}
		
		int count = 0;
		while (i < len) {
			if (i != 0)
				sb2.append('-');
			while (i < len && count < k) {
				count++;
				sb2.append(sb1.charAt(i));
				i++;
			}
			count = 0;
		}
//		System.out.println(firstGroupSize);
		return sb2.toString().toUpperCase();
	}
}
