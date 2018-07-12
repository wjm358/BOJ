package BOJ10757;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a;
		String b;
		int carry = 0;
		String[] t = sc.nextLine().split(" ");
		a = t[0];
		b = t[1];
		String result = new String();
		if (a.length() < b.length()) {
			int length = b.length() - a.length();
			for (int i = 0; i < length; i++) {
				a = "0" + a;
			}
		} else {
			int length = a.length() - b.length();
			for (int j = 0; j < length; j++) {
				b = "0" + b;
			}

		}
		for (int i = a.length() - 1; i >= 0; i--) {
			int anum = a.charAt(i) - '0';
			int bnum = b.charAt(i) - '0';
			int sum = anum + bnum + carry;
			result = (sum % 10) + result;
			carry = sum / 10;
		}
		if (carry != 0)
			System.out.println(carry + result);
		else
			System.out.println(result);
	}
}