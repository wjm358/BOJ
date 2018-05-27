package BOJ2501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuffer sb = new StringBuffer();
		ArrayList<Integer> ans = new ArrayList<>();
		
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
			
		for(int i=1; i<=n;i++) {
			if(n % i == 0) 
				ans.add(i);
		}
		
		if(ans.size() < k ) System.out.println(0);
		else
		System.out.println(ans.get(k-1));
	}
}
