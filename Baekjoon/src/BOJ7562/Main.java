package BOJ7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int x[] = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int y[] = { -1, 1, -2, 2, -2, 2, -1, 1 };
	static int chessLength;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(in.readLine());

		for (int c = 0; c < testCase; c++) {
			chessLength = Integer.parseInt(in.readLine());
			int map[][] = new int[chessLength][chessLength];
			boolean v[][] = new boolean[chessLength][chessLength];
			Queue<Pair> q = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			int srcX = Integer.parseInt(st.nextToken());
			int srcY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine());
			int desX = Integer.parseInt(st.nextToken());
			int desY = Integer.parseInt(st.nextToken());
			q.add(new Pair(srcX, srcY, 0));

			while (!q.isEmpty()) {
				Pair p = q.poll();
				if (p.x == desX && p.y == desY) {
					System.out.println(p.count);
					break;
				}
				
				for (int i = 0; i < x.length; i++) {
					int newX = p.x + x[i];
					int newY = p.y + y[i];
					
					if (inside(newX, newY) && !v[newX][newY]) {
						q.add(new Pair(newX, newY, p.count+1));
						v[newX][newY] = true;
					}
				}
			}

		}

	}

	static boolean inside(int x, int y) {
		return x >= 0 && x < chessLength && y >= 0 && y < chessLength;
	}
}

class Pair {
	int x;
	int y;
	int count;

	Pair(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}
