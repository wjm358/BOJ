package BOJ1225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		String a = st.nextToken();
		String b = st.nextToken();

		long sum = 0;
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				sum += (a.charAt(i)-'0') * (b.charAt(j)-'0');
			}
		}
		System.out.println(sum);

	}
}
