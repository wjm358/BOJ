package BOJ10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(reader.readLine());

		int arr[] = new int[n];

		for (int i = 0; i < n; i++) {
			int t = Integer.parseInt(st.nextToken());
			arr[i] = t;
		}

		Arrays.sort(arr);

		int m = Integer.parseInt(reader.readLine());
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < m; i++) {
			int t = Integer.parseInt(st.nextToken());
			if (Arrays.binarySearch(arr, t) < 0)
				sb.append("0 ");
			else
				sb.append("1 ");
		}

		System.out.println(sb.toString());

	}
}
