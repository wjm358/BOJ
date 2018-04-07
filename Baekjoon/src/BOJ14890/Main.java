package BOJ14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, l, count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());

		int roadA[][] = new int[n][n];
		int roadB[][] = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < n; j++) {
				int t = Integer.parseInt(st.nextToken());
				roadA[i][j] = roadB[j][i] = t;
			}
		}

		for (int i = 0; i < n; i++) {
			check(i, roadA);
			check(i, roadB);
		}

		System.out.println(count);
	}

	public static void check(int row, int[][] arr) {
		int h = arr[row][0];
		boolean v[] = new boolean[n];

		for (int i = 0; i < n; i++) {
			if (h != arr[row][i]) {

				if (Math.abs(h - arr[row][i]) > 1)
					return;
				else {
					if (h > arr[row][i]) {
						// right step is lower than current step
						int tmp = arr[row][i];
						for (int j = i; j <= i + l - 1; j++) {
							if (j >= n || v[j])
								return;
							if (tmp != arr[row][i])
								return;
							v[j] = true;
						}
						// i = i +l -1;
						// if(i>=n ) break;
					} else {
						// current step is lower than right step
						int tmp = arr[row][i];
						for (int j = i - 1; j >= i - l; j--) {
							if (j < 0 || v[j])
								return;
							if (tmp != arr[row][i])
								return;
							v[j] = true;
						}
					}
				}

				h = arr[row][i];
			}
		}

		count++;
	}

}
