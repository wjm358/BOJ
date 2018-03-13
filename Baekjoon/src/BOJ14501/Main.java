package BOJ14501;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int max = 0;
	static int n; // n+1일 째 되는날 퇴사
	static int[] t; // 상담 완료 하는데 걸리는 시간
	static int[] p; // 상담 했을 때 받을 수 있는 금액

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		t = new int[n + 1];
		p = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();

		}

		dfs(1, 0);

		System.out.println(max);
	}

	public static void dfs(int day, int sum) {
		if (day == n + 1) {
			max = Math.max(max, sum);
			return;
		}

		// day날에 상담을 하고 상담 완료 하는데 걸리는 시간을 더해서 넘김
		if (day + t[day] <= n + 1)
			dfs(day + t[day], sum + p[day]);

		// day에 상담을 하지 않고 다음날로 넘어감
		if (day + 1 <= n + 1)
			dfs(day + 1, sum);

	}
}
