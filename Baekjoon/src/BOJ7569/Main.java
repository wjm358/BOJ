package BOJ7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int tomato[][][];
	static int m, n, h;
	static int x[] = { 0, 0, -1, 1, 0, 0 };
	static int y[] = { -1, 1, 0, 0, 0, 0 };
	static int z[] = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		Queue<Pair> q = new LinkedList<>();

		//저장될 때 부터 모든 토마토가 익어있는 상태인지 저장하는 플래그
		boolean isAll = true;
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		tomato = new int[m][n][h];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(reader.readLine());
				
				for (int k = 0; k < m; k++) {
					tomato[k][j][i] = Integer.parseInt(st.nextToken());
					if (tomato[k][j][i] == 1)
						q.add(new Pair(k, j, i));
					else
						isAll = false;
				}
			}
		}

		//모든 토마토가 익어있는 상태이면 0을 출력하고 종료
		if (isAll == true) {
			System.out.println("0");
			return;
		}

		//토마토가 모두 익는데 걸리는 시간 계산
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int x1 = p.x;
			int y1 = p.y;
			int z1 = p.z;
			for (int i = 0; i < 6; i++) {
				int newX = x1 + x[i];
				int newY = y1 + y[i];
				int newZ = z1 + z[i];

				if (isInside(newX, newY, newZ) && tomato[newX][newY][newZ] == 0) {
					tomato[newX][newY][newZ] = tomato[x1][y1][z1] + 1;
					q.add(new Pair(newX, newY, newZ));
				}
			}

		}

		int max = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (tomato[k][j][i] == 0) {
						System.out.println("-1");
						return;
					} else {
						max = Math.max(tomato[k][j][i], max);
					}
				}
			}
		}

		System.out.println(max - 1);
	}

	
	static boolean isInside(int x, int y, int z) {
		return (x >= 0 && x < m && y >= 0 && y < n && z >= 0 && z < h);
	}

	static class Pair {
		int x;
		int y;
		int z;

		Pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}
