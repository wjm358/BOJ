package BOJ2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		int testCase = Integer.parseInt(reader.readLine());
		
		while(testCase >0) {
			int k = Integer.parseInt(reader.readLine()); //���� ��
			int n = Integer.parseInt(reader.readLine()); //ȣ�� ��
			int arr[][] = new int[k+1][n+1]; //����Ʈ�� 0�������ְ�, ȣ�� 1ȣ���� �ִ�
			
			//0���� iȣ���� i���� ���
			for(int i=1; i<=n; i++) 
				arr[0][i] = i;
			
			for(int i=1; i<=k;i++) {
				for(int j=1; j<=n;j++) {
					//1ȣ���� jȣ���� ����
					for(int t=1; t<=j;t++)
						arr[i][j] += arr[i-1][t];
				}
			}
			
			testCase--;
			sb.append(arr[k][n] + "\n");
		}
		System.out.println(sb.toString());
		
	}
}
