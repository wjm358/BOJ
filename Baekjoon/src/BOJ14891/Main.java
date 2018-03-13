package BOJ14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] gear = new int[4][8];
	static int CW = 1;// 시계방향
	static int CCW = -1; // 반시계방향
	static boolean isVisited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// n극 , s극 입력
		for (int i = 0; i < 4; i++) {
			String s = reader.readLine();
			for (int j = 0; j < 8; j++)
				gear[i][j] = s.charAt(j) - '0';
		}

		// 회전 횟수
		int k = Integer.parseInt(reader.readLine());

		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int num = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			isVisited = new boolean[4];
			rotate(num - 1, dir);

		}

		int sum = 0;
		int mul = 1;
		for (int i = 0; i < 4; i++) {
			if (gear[i][0] == 1)
				sum += mul;
			mul *= 2;
		}

		System.out.println(sum);
	}

	public static void rotate(int num, int dir) {
		isVisited[num] = true;

		// 왼쪽
		if (num - 1 >= 0 && (gear[num - 1][2] != gear[num][6]) && !isVisited[num - 1])
			rotate(num - 1, swap(dir));

		// 오른쪽
		if (num + 1 < 4 && (gear[num][2] != gear[num + 1][6]) && !isVisited[num + 1])
			rotate(num + 1, swap(dir));

		if (dir == CW)
			clockWise(num);
		else
			counterClockWise(num);

	}

	public static void clockWise(int num) {
		int t = gear[num][7];
		for (int i = 7; i > 0; i--)
			gear[num][i] = gear[num][i - 1];
		gear[num][0] = t;
	}

	public static void counterClockWise(int num) {
		int t = gear[num][0];
		for (int i = 0; i < 7; i++)
			gear[num][i] = gear[num][i + 1];
		gear[num][7] = t;
	}

	public static int swap(int dir) {
		return (dir == 1 ? -1 : 1);
	}
}
