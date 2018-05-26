package BOJ11057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int s[] = {1,1,1,1,1,1,1,1,1,1};//0 - 9
		int result =10 ;
		
		for(int i=2; i<=n;i++) {
			for(int j=1; j<10;j++) {
				if( j == 1 ) {result +=1; continue;}
				
				s[j] = (s[j] + s[j-1]) % 10007;
				result = (result + s[j]) % 10007; 
			}
		}
		
		System.out.println(result);
	}
}
