package BOJ10868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr; // 값들 저장
	static int[] tree; // segment tree
	final static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken()); // n 개의 정수
		int m = Integer.parseInt(st.nextToken()); // m개의 (a,b) 쌍
		StringBuffer sb = new StringBuffer();
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		int size = (int) Math.pow(2, h + 1) - 1;

		arr = new int[n];
		tree = new int[size];
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(in.readLine());

		init(1, 0, n - 1);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			sb.append(search(1, s - 1, e - 1, 0, n - 1)).append("\n");
		}

		System.out.println(sb.toString());
	}

	static int init(int idx, int start, int end) {
		if (start == end)
			tree[idx] = arr[start];
		else
			tree[idx] = Math.min(init(idx * 2, start, (start + end) / 2),
					init(idx * 2 + 1, (start + end) / 2 + 1, end));
		return tree[idx];
	}

	// [left,right] - 찾으려는 구간
	// [start,end] - 노드가 가진 구간
	static int search(int idx, int left, int right, int start, int end) {
		if (right < start || end < left)
			return INF;
		else if (left <= start && right >= end)
			return tree[idx];
		return Math.min(search(idx * 2, left, right, start, (start + end) / 2),
				search(idx * 2 + 1, left, right, (start + end) / 2 + 1, end));
	}
}
