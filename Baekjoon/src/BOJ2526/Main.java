package BOJ2526;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		int arr[] = new int[100];
		int arr_idx = 0;
		arr[arr_idx++] = n;
		int res = n;

		while (true) {
			res = n * res % p;
			for (int i = 0; i < arr_idx; i++) {
				if (res == arr[i]) {
					System.out.println(arr_idx - i);
					return;
				}
			}
			arr[arr_idx++] = res;
		}

	}
}
