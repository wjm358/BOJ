package BOJ11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		ArrayList<Integer> a[] = new ArrayList[n + 1];
		int visited[] = new int[n + 1];
		Queue<Integer> q = new LinkedList<>();
		StringBuffer sb = new StringBuffer();

		for (int i = 1; i <= n; i++)
			a[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			a[from].add(to);
			a[to].add(from);
		}

		q.add(1);
		while (!q.isEmpty()) {
			int from = q.poll();
			for (int t : a[from]) {
				if (visited[t] == 0) {
					visited[t] = from;
					q.add(t);
				}
			}
		}

		for (int i = 2; i <= n; i++)
			sb.append(visited[i]).append("\n");

		System.out.println(sb.toString());
	}
}
