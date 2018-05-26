package BOJ10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		char[][] word = new char[5][15];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < 5; i++) {
			String tmp = in.readLine();
			for(int j=0; j<tmp.length();j++)
				word[i][j] = tmp.charAt(j);
		}
		
		for(int i=0;i<15;i++) {
			for(int j=0; j<5;j++) {
				if(word[j][i] == '\0') continue;
				sb.append(word[j][i]);
			}
		}
		System.out.println(sb.toString());

	}
}
