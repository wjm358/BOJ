package BOJ6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuffer sb = new StringBuffer();
	static int n;
	static int a[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;
			a = new int[n];

			for (int i = 0; i < n; i++) {
				int t = Integer.parseInt(st.nextToken());
				a[i] = t;

			}
			dfs(0, 0, "");
			System.out.println(sb.toString());
			sb.setLength(0);
		}

	}

	static void dfs(int idx, int cnt, String s) {
		if (cnt == 6) {
			sb.append(s + "\n");
			return;
		} else if (idx >= n) //인덱스가 n을 넘어 갔을 때 
			return;
		else {
			dfs(idx + 1, cnt + 1, s + a[idx] + " "); //선택한 경우
			dfs(idx + 1, cnt, s); //선택하지 않은 경우
		}
	}
}
