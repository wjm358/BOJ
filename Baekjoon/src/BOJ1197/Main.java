package BOJ1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int parent[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		parent = new int[v + 1];
		ArrayList<Edge> edge = new ArrayList<>();
		
		for (int i = 1; i <= v; i++)
			parent[i] = i;

		for (int i = 1; i <= e; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edge.add(new Edge(a, b, c));
		}

		Collections.sort(edge);

		int sum = 0;
		for (int i = 0; i < e; i++) {
			Edge t = edge.get(i);
			if (merge(t.from, t.to))
				sum += t.weight;
		}

		System.out.println(sum);

	}

	public static int getParent(int v) {
		if (v == parent[v])
			return v;

		return parent[v] = getParent(parent[v]);
	}

	public static boolean merge(int a, int b) {
		int pA = getParent(a);
		int pB = getParent(b);

		if (pA != pB) {
			parent[pB] = pA;
			return true;
		}
		return false;
	}
}

class Edge implements Comparable<Edge> {
	int from;
	int to;
	int weight;

	Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.weight < o.weight)
			return -1;
		else if (this.weight == o.weight)
			return 0;
		else
			return 1;
	}
}