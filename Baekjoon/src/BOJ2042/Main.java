package BOJ2042;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long arr[];
	static long tree[];
	static StringBuffer sb = new StringBuffer();

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		int n = Integer.parseInt(st.nextToken()); // 수의 개수
		int m = Integer.parseInt(st.nextToken()); // 변경이 일어나는 횟수
		int k = Integer.parseInt(st.nextToken()); // 구간의 합을 구하는 횟수

		arr = new long[n];
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		tree = new long[(int) Math.pow(2, h + 1)];

		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(reader.readLine());
			arr[i] = tmp;
		}

		// 세그먼트 트리 형성
		init(1, 0, n - 1);

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());

			switch (a) {

			// 1일때는 b번째 수를 c로 바꾼다.
			case 1:
				long diff = c - arr[b - 1];
				arr[b - 1] = c;
				update(1, 0, n - 1, b - 1, diff);
				break;

			// b번째 수부터 c번째 수까지의 합을구하여 출력한다.
			case 2:
				printSum(n, b, (int) c);
				break;
			}

		}
		System.out.println(sb.toString());

	}

	public static void printSum(int n, int b, int c) {
		long sum = sum(1, 0, n - 1, b - 1, c - 1);
		sb.append(sum + "\n");
	}

	/*
	 * 입력받은 배열을 기반으로 세그먼트 트리 형성
	 */
	public static long init(int node, int start, int end) {
		if (start == end)
			return tree[node] = arr[start]; // 단말노드에는 배열 값 삽입
		else
			return tree[node] = init(node * 2, start, (start + end) / 2)
					+ init(node * 2 + 1, (start + end) / 2 + 1, end);
	}

	/*
	 * 입력받은 구간의 합계를 리턴
	 */
	public static long sum(int node, int start, int end, int left, int right) {
		// [left, right]와 [start,end]가 겹치지 않을경우
		if (left > end || right < start)
			return 0;

		// [left,right]가 [start,end]를 완전히 포함하는 경우
		if (left <= start && right >= end)
			return tree[node];

		/*
		 * 1. [start,end]가 [left,right]를 완전히 포함하는 경우 2. [left,right]와 [start,end]가 겹쳐 있는
		 * 경우
		 */
		return sum(node * 2, start, (start + end) / 2, left, right)
				+ sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
	}

	/*
	 * 범위내의 값이 변경 되었을 때 변경되어야 할 인덱스의 값들을 변경 diff = 변경된 값과의 차이 값
	 */
	public static void update(int node, int start, int end, int index, long diff) {
		// 변경된 인덱스가 [start,end]의 범위 밖에 있을 때
		if (index < start || index > end)
			return;

		tree[node] += diff;

		// 노드가 리프노드가 아닐경우 분할
		if (start != end) {
			update(node * 2, start, (start + end) / 2, index, diff);
			update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
		}

	}
}
