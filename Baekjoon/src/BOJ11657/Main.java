package BOJ11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	final static int MAX = 987654321;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int dist[] = new int[n];
		ArrayList<Edge> edge[] = new ArrayList[n];
		for (int i = 0; i < n; i++)
			edge[i] = new ArrayList<>();

		Arrays.fill(dist, MAX);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edge[from - 1].add(new Edge(to - 1, cost));
		}

		dist[0] = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n; j++) {
				for (Edge t : edge[j]) {
					int to = t.to;
					int cost = t.cost;
					if (dist[j] != MAX && (dist[j] + cost < dist[to])) {
						dist[to] = dist[j] + cost;
					}
				}
			}
		}

		boolean minusCycle = false;
		for(int j =0; j<n;j++) {
			for(Edge t: edge[j]) {
				int to = t.to; 
				int cost = t.cost;
				if (dist[j] != MAX && (dist[j] + cost < dist[to])) {
					dist[to] = dist[j] + cost;
					minusCycle = true;
					break;
				}
				if(minusCycle == true) break;
			}
		}
		
		if(minusCycle) System.out.println(-1);
		else {
			for(int i=1; i<n;i++) {
				if(dist[i] == MAX) System.out.print(-1+ " ");
				else System.out.print(dist[i]+ " " );
			}
		}
	}
}

class Edge {
	int to;
	int cost;

	Edge(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}
}
