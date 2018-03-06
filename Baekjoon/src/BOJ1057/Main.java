package BOJ1057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		st.nextToken();
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());
		int cnt = 0;

		while (first != second) {
			first = (first % 2 == 0) ? first / 2 : (first + 1) / 2;
			second = (second % 2 == 0) ? second / 2 : (second + 1) / 2;
			cnt++;
		}

		System.out.println(cnt);
	}
}
