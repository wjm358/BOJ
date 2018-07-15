package BOJ10820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String input;

		while ((input = in.readLine()) != null) {
			check(input);
		}
		System.out.println(sb.toString());
	}

	// 소문자, 대문자, 숫자, 공백의 개수
	public static void check(String a) {
		int upper = 0, lower = 0, space = 0, num = 0;

		for (int i = 0; i < a.length(); i++) {
			char tmp = a.charAt(i);
			if (tmp >= 'a' && tmp <= 'z')
				lower++;
			else if (tmp >= 'A' && tmp <= 'Z')
				upper++;
			else if (tmp == ' ')
				space++;
			else if (tmp >= '0' && tmp <= '9')
				num++;
		}

		sb.append(lower + " " + upper + " " + num + " " + space + " \n");
	}
}
