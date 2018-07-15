package BOJ1051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int x = Integer.parseInt(st.nextToken()); // За
		int y = Integer.parseInt(st.nextToken()); // ї­
		int[][] square = new int[x][y];

		int maxSize = Math.max(x, y);
		for (int i = 0; i < x; i++) {
			String t = in.readLine();
			for (int j = 0; j < t.length(); j++)
				square[i][j] = t.charAt(j) - '0';
		}

		int max = 1;
		for (int size = 2; size <= maxSize; size++) {
			for (int i = 0; i <= x - size; i++) {
				for (int j = 0; j <= y - size; j++) {
					if ((square[i][j] == square[i + (size-1)][j]) && (square[i + (size-1)][j] == square[i][j + (size-1)])
							&& (square[i][j + (size-1)] == square[i + (size-1)][j + (size-1)])) {
						max =Math.max(max, size*size);
						break;
					}
				}
			}
		}
		System.out.println(max);

	}

}
