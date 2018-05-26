package BOJ11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean v[];
	static int arr[][];
	static int n;
	static int m;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuffer sb = new StringBuffer();
		n = Integer.parseInt(st.nextToken()); // 정점 개수
		m = Integer.parseInt(st.nextToken()); // 간선 개수
		arr = new int[n+1][n+1];
		v = new boolean[n+1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			arr[v1][v2] = 1;
			arr[v2][v1] = 1;
		}

		int cnt = 0;

		for(int i=1;i<=n;i++) {
			if(v[i] ==false) 
			{
				dfs(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	public static void dfs(int vertex) {
		v[vertex] = true;
		for(int i=1; i<=n;i++) {
			if(arr[i][vertex] == 1 && v[i] == false) {
				dfs(i);
			}
		}
	}
}
