package BOJ1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	final static int MIN = 987654321;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		int s = 0, e = 0;

		int sum = 0, min = MIN;

		while (true) {
			if (sum >= k)
				sum -= arr[s++];
			else if (e == n)
				break;
			else
				sum += arr[e++];
			if (sum >= k) {
				min = Math.min(min, e - s);
			}
		}
		if (min == MIN)
			System.out.println(0);
		else

			System.out.println(min);

	}
}
