package BOJ1735;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());
		int jaA = Integer.parseInt(st.nextToken());
		int moA = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		int jaB = Integer.parseInt(st.nextToken());
		int moB = Integer.parseInt(st.nextToken());

		if (moA != 0 && moB != 0) {
			int numLcm = lcm(moA, moB);
			int a = numLcm / moA;
			int b = numLcm / moB;

			jaA = a * jaA;
			jaB = b * jaB;

			int sumMo = numLcm;
			int sumJa = jaA + jaB;

			int numGcd = gcd(sumMo, sumJa);
			if (numGcd != 1) {
				sumMo /= numGcd;
				sumJa /= numGcd;
			}

			System.out.println(sumJa + " " + sumMo);
		} else
			System.out.println("0 0 ");

	}

	static int gcd(int a, int b) { 
		int mod = a % b;
		while (mod > 0) {
			a = b;
			b = mod;
			mod = a % b;
		}
		return b;
	}

	static int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
}
