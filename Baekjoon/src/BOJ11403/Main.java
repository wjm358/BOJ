package BOJ11403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int adj[][], result[][], n;
	static boolean v[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(reader.readLine());
		adj = new int[n][n];
		result = new int[n][n];
		v = new boolean[n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			dfs(i,i);
			Arrays.fill(v, false);
		}

		for(int i=0; i<n; i++) {
			for( int j=0; j<n;j++) {
				System.out.printf("%d ",result[i][j] );
			}
			System.out.println();
		}
	}

	public static void dfs(int idx, int r) {
		for (int i = 0; i < n; i++) {
			if (adj[idx][i] == 1 && v[i] == false) {
				v[i] = true;
				result[r][i] = 1;
				dfs(i,r);
			}
		}
		
	}
}
