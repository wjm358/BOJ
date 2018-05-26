package boj10162;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		int a = 300, b = 60, c = 10;
		int cntA = 0, cntB = 0, cntC = 0;
		int n = Integer.parseInt(in.readLine());

		if (n >= 300) {
			cntA += n / 300;
			n %= 300;
		}

		if (n >= 60) {
			cntB += n / 60;
			n %= 60;
		}

		if (n >= 10) {
			cntC += n / 10;
			n %= 10;
		}

		if(n != 0 ) System.out.println(-1);
		else
		System.out.println(cntA + " " + cntB + " " + cntC);

	}
}
