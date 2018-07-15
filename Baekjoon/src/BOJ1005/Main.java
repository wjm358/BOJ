package BOJ1005;

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
		int testCase = Integer.parseInt(in.readLine());
		StringBuffer sb = new StringBuffer();

		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken()); // 건물의 개수
			int k = Integer.parseInt(st.nextToken()); // 건물간의 건설순서 규칙
			int time[] = new int[n + 1];
			int sum[] = new int[n + 1];
			int degree[] = new int[n + 1];
			st = new StringTokenizer(in.readLine());
			ArrayList<Integer> building[] = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++)
				building[i] = new ArrayList<>();
			Queue<Integer> q = new LinkedList<>();

			for (int i = 1; i <= n; i++)
				time[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(in.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				building[first].add(second);
				degree[second]++;
			}

			int w = Integer.parseInt(in.readLine()); // 건설해야할 건물의 번호

			for (int i = 1; i <= n; i++)
				if (degree[i] == 0) {
					q.add(i);
					sum[i] = time[i];
				}

			while (!q.isEmpty()) {
				int first = q.poll();
				for (int t : building[first]) {
					degree[t]--;
					sum[t] = Math.max(sum[t], sum[first] + time[t]);
					if (degree[t] == 0)
						q.add(t);
				}
			}
			sb.append(sum[w]).append("\n");
		}
		System.out.println(sb.toString());

	}
}
