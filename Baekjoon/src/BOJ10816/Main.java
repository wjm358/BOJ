package BOJ10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, Integer> map = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < n; i++) {
			int t = Integer.parseInt(st.nextToken());

			if (map.containsKey(t)) {
				map.replace(t, map.get(t) + 1);
			} else
				map.put(t, 1);
		}

		int m = Integer.parseInt(reader.readLine());
		st = new StringTokenizer(reader.readLine());

		for (int i = 0; i < m; i++) {
			int t = Integer.parseInt(st.nextToken());

			if (map.containsKey(t)) {
				sb.append(map.get(t) + " ");
			} else {
				sb.append("0 ");
			}
		}

		System.out.println(sb.toString());

	}
}
