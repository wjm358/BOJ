package BOJ1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int document[] = new int[101];
	static int tmp_document[] = new int[101];
	static boolean search[] = new boolean[101];
	static boolean tmp_search[] = new boolean[101];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(in.readLine());
		StringBuffer sb = new StringBuffer();
		while (testCase-- > 0) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken()); // 궁금한 문서의 위치
			// 답은 인덱스위치의 +1 해야함
			Arrays.fill(search, false);
			search[m] = true;

			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < n; i++)
				document[i] = Integer.parseInt(st.nextToken());

			for (int i = 0; i < n; i++) {
				int max = document[i];
				int max_idx = i;
				int tmp_idx = 0;
				
				for (int j = i; j < n; j++) {
					if (max < document[j]) {
						max = document[j];
						max_idx = j;
					}
				}
				for (int j = max_idx; j < n; j++) {
					tmp_document[tmp_idx] = document[j];
					tmp_search[tmp_idx] = search[j];
					tmp_idx++;
				}

				for (int j = i; j < max_idx; j++) {
					tmp_document[tmp_idx] = document[j];
					tmp_search[tmp_idx] = search[j];
					tmp_idx++;
				}

				tmp_idx = 0;
				for (int j = i; j < n; j++) {
					document[j] = tmp_document[tmp_idx];
					search[j] = tmp_search[tmp_idx];
					tmp_idx++;
				}
			}
			for (int i = 0; i < n; i++) {
				if (search[i]) {
					sb.append(i + 1).append("\n");
					break;
				}
			}
		}
		
		System.out.println(sb.toString());
	}

}
