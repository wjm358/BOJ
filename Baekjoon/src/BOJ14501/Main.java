package BOJ14501;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	static int max = 0;
	static int n; // n+1�� ° �Ǵ³� ���
	static int[] t; // ��� �Ϸ� �ϴµ� �ɸ��� �ð�
	static int[] p; // ��� ���� �� ���� �� �ִ� �ݾ�

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

		// day���� ����� �ϰ� ��� �Ϸ� �ϴµ� �ɸ��� �ð��� ���ؼ� �ѱ�
		if (day + t[day] <= n + 1)
			dfs(day + t[day], sum + p[day]);

		// day�� ����� ���� �ʰ� �������� �Ѿ
		if (day + 1 <= n + 1)
			dfs(day + 1, sum);

	}
}
