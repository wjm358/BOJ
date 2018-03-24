package BOJ1158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		StringBuffer sb = new StringBuffer();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		boolean v[] = new boolean[n];

		long start = System.currentTimeMillis();
		int cntIdx = 0;
		sb.append("<");
		for (int i = 0; i < n; i++) {
			int count = m;

			for (int j = 0; j < m; j++) {

				if (v[cntIdx] == false) {
					count--;
					if (count == 0) {
						sb.append((cntIdx + 1));

						// 마지막 숫자 뒤에 ,이 추가되는 것 방지
						if (i < n - 1)
							sb.append(", ");

						v[cntIdx] = true;
						break;
					}
					cntIdx = (cntIdx + 1) % n;
				} else {
					cntIdx = (cntIdx + 1) % n;
					j--;
					continue;
				}
			}
		}
		long end = System.currentTimeMillis();
		sb.append(">");
		System.out.println(sb.toString());
		System.out.println((end - start)/ 1000.0);
	}
}
