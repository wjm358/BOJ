package BOJ1037;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//1037 ¾à¼ö
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int a[] = new int[n];

		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(a);
	
		if(n==1) 
			System.out.println(a[0] * a[0]);
		else
			System.out.println(a[0] * a[n-1]);
	}
}