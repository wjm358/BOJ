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

		int n = Integer.parseInt(st.nextToken()); // ���� ����
		int m = Integer.parseInt(st.nextToken()); // ������ �Ͼ�� Ƚ��
		int k = Integer.parseInt(st.nextToken()); // ������ ���� ���ϴ� Ƚ��

		arr = new long[n];
		int h = (int) Math.ceil(Math.log(n) / Math.log(2));
		tree = new long[(int) Math.pow(2, h + 1)];

		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(reader.readLine());
			arr[i] = tmp;
		}

		// ���׸�Ʈ Ʈ�� ����
		init(1, 0, n - 1);

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Integer.parseInt(st.nextToken());

			switch (a) {

			// 1�϶��� b��° ���� c�� �ٲ۴�.
			case 1:
				long diff = c - arr[b - 1];
				arr[b - 1] = c;
				update(1, 0, n - 1, b - 1, diff);
				break;

			// b��° ������ c��° �������� �������Ͽ� ����Ѵ�.
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
	 * �Է¹��� �迭�� ������� ���׸�Ʈ Ʈ�� ����
	 */
	public static long init(int node, int start, int end) {
		if (start == end)
			return tree[node] = arr[start]; // �ܸ���忡�� �迭 �� ����
		else
			return tree[node] = init(node * 2, start, (start + end) / 2)
					+ init(node * 2 + 1, (start + end) / 2 + 1, end);
	}

	/*
	 * �Է¹��� ������ �հ踦 ����
	 */
	public static long sum(int node, int start, int end, int left, int right) {
		// [left, right]�� [start,end]�� ��ġ�� �������
		if (left > end || right < start)
			return 0;

		// [left,right]�� [start,end]�� ������ �����ϴ� ���
		if (left <= start && right >= end)
			return tree[node];

		/*
		 * 1. [start,end]�� [left,right]�� ������ �����ϴ� ��� 2. [left,right]�� [start,end]�� ���� �ִ�
		 * ���
		 */
		return sum(node * 2, start, (start + end) / 2, left, right)
				+ sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
	}

	/*
	 * �������� ���� ���� �Ǿ��� �� ����Ǿ�� �� �ε����� ������ ���� diff = ����� ������ ���� ��
	 */
	public static void update(int node, int start, int end, int index, long diff) {
		// ����� �ε����� [start,end]�� ���� �ۿ� ���� ��
		if (index < start || index > end)
			return;

		tree[node] += diff;

		// ��尡 ������尡 �ƴҰ�� ����
		if (start != end) {
			update(node * 2, start, (start + end) / 2, index, diff);
			update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
		}

	}
}
