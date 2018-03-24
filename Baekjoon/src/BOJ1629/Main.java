package BOJ1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * (A^B) % C �� ����ϴ� ����
 * A,B,C�� ���� 2,147,483,647 �� ������ �����Ƿ� �ܼ��� B���� ���ϸ�
 * �ð��ʰ��� ���ɼ��� ����. 
 * repeated squaring algorithm ��� 
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

		// ù �Է°��� b�� 1�϶� ó��
		if (b == 1)
			return a % c;

		if (b % 2 == 0)
			return pow((a * a) % c, b / 2);
		else
			return (a * pow((a * a) % c, b / 2)) % c;

	}
}
