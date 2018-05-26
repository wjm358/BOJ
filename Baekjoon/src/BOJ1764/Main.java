package BOJ1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuffer sb = new StringBuffer();
		Set<String> list = new HashSet<>();
		ArrayList<String> ans = new ArrayList<>();
		

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			String tmp = in.readLine();
			list.add(tmp);
		}
	
		for (int i = 0; i < m; i++) {
			String tmp = in.readLine();
			if (list.contains(tmp)) {
				ans.add(tmp);
				cnt++;
			}
		}
		Collections.sort(ans);
		for(String t : ans) 
			sb.append(t+"\n");
		
		System.out.println(cnt);
		System.out.println(sb.toString());
	}
}
