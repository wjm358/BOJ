package BOJ1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * (A^B) % C 를 계산하는 문제
 * A,B,C의 값이 2,147,483,647 의 범위를 가지므로 단순히 B번을 곱하면
 * 시간초과의 가능성이 높다. 
 * repeated squaring algorithm 사용 
 */
public class Main {
	static int c;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());

		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		System.out.println(pow(a, b));
	}

	public static long pow(long a, long b) {
		if (b == 0)
			return 1;

		// 첫 입력값에 b가 1일때 처리
		if (b == 1)
			return a % c;

		if (b % 2 == 0)
			return pow((a * a) % c, b / 2);
		else
			return (a * pow((a * a) % c, b / 2)) % c;

	}
}
