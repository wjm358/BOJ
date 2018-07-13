package BOJ11651;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(in.readLine());
		loc[] location = new loc[n];
		for(int i=0;i<n;i++) {
			StringTokenizer st =new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			location[i] = new loc(x,y);
		}
		Arrays.sort(location);
		for(loc t : location) {
			sb.append(t.x).append(" ").append(t.y).append("\n");
		}
		System.out.println(sb.toString());
	}
}

// y좌표가 증가하는 순으로, 같다면 x좌표가 증가하는 순으로
class loc implements Comparable<loc> {
	int x;
	int y;

	loc(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(loc o) {
		if (this.y == o.y) {
			return this.x-o.x;
		}
		return this.y-o.y;
	}

}
