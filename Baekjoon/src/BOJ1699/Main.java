package BOJ1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * ������ �� : ���� ū ���������θ� ���Ұ��
 * 12 = 3^2 + 1^2 + 1^2 + 1^2 (4��)�� �ԷµǴµ�
 * 12 = 2^2+ 2^2 + 2^2(3��)�� �ּҰ����� �Ǵ°��� �߰����� ����
 * ���� 1���� ���������� ��� �غ�����
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int dp[] = new int[n + 1];
		
		for(int i=1;i<=n;i++)
			dp[i] = i;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
			}
		}
		
		System.out.println(dp[n]);
	}
}
