package BOJ1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//Ž�� �˰��� ���
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int cnt =0;
		
		Pair[] p = new Pair[n];
		
		for(int i=0; i<n;i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			p[i] = new Pair(s,e);	
		}
		
		Arrays.sort(p);

		int end = -1;
		for(int i=0; i<n;i++) {
			if(p[i].start >= end) {
				end = p[i].end;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}


/*
 * ���۽ð��� ����ð��� �������ϴ� Pair Ŭ���� ����
 * ����ð��� �������� �켱 �����ϰ�, ����ð��� ���ٸ� ���۽ð���
 * ���������� ���� 
 */
class Pair implements Comparable<Pair> {

	int start;
	int end;

	Pair(int start, int end) {
		this.start = start;
		this.end = end;

	}

	@Override
	public int compareTo(Pair p) {
		if (end == p.end)
			return Integer.compare(start,p.start);
		else
			return Integer.compare(end,p.end);
	}

}
