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

	// 에라토스 테네스의 체로 소수 판별
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

	// 자리수마다 0부터 9까지 값을 바꿔가면서 그 값이 소수이면 큐에 포함, 카운터값을 1 증가
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

			// 자리수 마다
			for (int i = 0; i < 4; i++) {
				// 인덱스마다 각 자리수의 값을 가지고 있음
				int a[] = numToArray(num);

				// 0부터 9까지
				for (int j = 0; j < 10; j++) {

					// 1000의자리에 0이들어가면 안되므로 건너뜀
					if (i == 0 & j == 0)
						continue;

					int newNum = arrayToNum(a, i, j);

					// 숫자는 4자리 이상이여야 하고 방문하지 않은 수여야 하고, 소수여야함
					if (newNum >= 1000 && isPrime[newNum] && !isVisited[newNum]) {
						isVisited[newNum] = true;
						q.add(new Pair(newNum, cnt + 1));
					}
				}
			}

		}

		// 불가능할 경우 -1 반환
		return -1;
	}

	// 배열을 숫자로 변환
	public static int arrayToNum(int[] a, int i, int newNum) {
		a[i] = newNum;
		return (a[0] * 1000) + (a[1] * 100) + (a[2] * 10) + a[3];
	}

	// 숫자를 배열로 변환
	public static int[] numToArray(int num) {
		int temp[] = new int[4];
		temp[0] = num / 1000;
		temp[1] = (num / 100) % 10;
		temp[2] = (num / 10) % 10;
		temp[3] = num % 10;
		return temp;
	}

	// 숫자와 카운터 저장
	static class Pair {
		int number;
		int count;

		public Pair(int number, int count) {
			this.number = number;
			this.count = count;
		}
	}
}