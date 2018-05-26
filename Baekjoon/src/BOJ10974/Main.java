package BOJ10974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean v[];
	static int num[];
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(in.readLine());
		v = new boolean[n + 1];
		num = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			v[i] = true;
			dfs(i, 1, n);
			v[i] = false;
		}
		
		System.out.println(sb.toString());
	}

	public static void dfs(int i, int idx, int n) {
		num[idx] = i;
	
		if (idx == n) {
			for (int a = 1; a <= n; a++) {
				sb.append(num[a] + " ");
			}
			sb.append("\n");
			return;
		}
		
		for (int j = 1; j <= n; j++) {
			if (v[j] == true)
				continue;
			v[j] = true;
			dfs(j, idx+1, n);
			v[j] = false;
		}
	}
}
