package BOJ1158_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//BOJ1158 √÷¿˚»≠
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb =new StringBuffer();
		StringBuffer result = new StringBuffer();
		StringTokenizer st =new StringTokenizer(reader.readLine());
		ArrayList<Integer> a =new ArrayList<>();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken())-1;
		
		for(int i=1; i<=n;i++) 
			a.add(i);
		
		int cntIdx =0;
		
		sb.append("<");
		while(!a.isEmpty()) {
			cntIdx += m;
			if(cntIdx >= a.size())
				cntIdx %= a.size();
			sb.append(a.remove(cntIdx) + ", ");
		}
		result.append(sb.substring(0, sb.length()-2)+ ">");
		System.out.println(result.toString());
	}
}
