package BOJ10451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean v[];
	static int arr[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int testCase = Integer.parseInt(in.readLine());

		while (testCase > 0) {
			int n = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			arr = new int[n+1];
			v = new boolean[n+1];
			int cnt = 0;
			for (int i = 1; i <= n; i++)
				arr[i] = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= n; i++) {
				if (!v[i]) {
					v[i] = true;
					dfs(i, arr[i]);
					cnt++;
				}
			}

			sb.append(cnt).append("\n");
			testCase--;
		}
		System.out.println(sb.toString());

	}

	static void dfs(int startIdx, int value) {
		if (value != startIdx) {
			v[value] = true;
			dfs(startIdx, arr[value]);
		} else
			return;
	}
}
