package BOJ1963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean isPrime[] = new boolean[10000];
	static int first, second, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int testCase = Integer.parseInt(reader.readLine());

		era();
		
		while (testCase > 0) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			first = Integer.parseInt(st.nextToken());
			second = Integer.parseInt(st.nextToken());

			int result = dfs(first);
		
			if (result == -1)
				sb.append("Impossible\n");
			else
				sb.append(result + "\n");
			testCase--;
		}
		
		System.out.println(sb.toString());
	}

	// �����佺 �׳׽��� ü�� �Ҽ� �Ǻ�
	public static void era() {
		for (int i = 2; i <= 9999; i++)
			isPrime[i] = true;

		for (int i = 2; (i * i) <= 9999; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= 9999; j += i)
					isPrime[j] = false;
			}
		}
	}

	// �ڸ������� 0���� 9���� ���� �ٲ㰡�鼭 �� ���� �Ҽ��̸� ť�� ����, ī���Ͱ��� 1 ����
	public static int dfs(int start) {
		Queue<Pair> q = new LinkedList<>();
		boolean isVisited[] = new boolean[10000];

		q.add(new Pair(start, 0));
		isVisited[start] = true;

		while (!q.isEmpty()) {
			Pair p = q.poll();
			int num = p.number;
			int cnt = p.count;

			if (num == second)
				return cnt;

			// �ڸ��� ����
			for (int i = 0; i < 4; i++) {
				// �ε������� �� �ڸ����� ���� ������ ����
				int a[] = numToArray(num);

				// 0���� 9����
				for (int j = 0; j < 10; j++) {

					// 1000���ڸ��� 0�̵��� �ȵǹǷ� �ǳʶ�
					if (i == 0 & j == 0)
						continue;

					int newNum = arrayToNum(a, i, j);

					// ���ڴ� 4�ڸ� �̻��̿��� �ϰ� �湮���� ���� ������ �ϰ�, �Ҽ�������
					if (newNum >= 1000 && isPrime[newNum] && !isVisited[newNum]) {
						isVisited[newNum] = true;
						q.add(new Pair(newNum, cnt + 1));
					}
				}
			}

		}

		// �Ұ����� ��� -1 ��ȯ
		return -1;
	}

	// �迭�� ���ڷ� ��ȯ
	public static int arrayToNum(int[] a, int i, int newNum) {
		a[i] = newNum;
		return (a[0] * 1000) + (a[1] * 100) + (a[2] * 10) + a[3];
	}

	// ���ڸ� �迭�� ��ȯ
	public static int[] numToArray(int num) {
		int temp[] = new int[4];
		temp[0] = num / 1000;
		temp[1] = (num / 100) % 10;
		temp[2] = (num / 10) % 10;
		temp[3] = num % 10;
		return temp;
	}

	// ���ڿ� ī���� ����
	static class Pair {
		int number;
		int count;

		public Pair(int number, int count) {
			this.number = number;
			this.count = count;
		}
	}
}