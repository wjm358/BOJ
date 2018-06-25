package BOJ1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 큐의 크기 N과 뽑아내려고하는 수의 개수 M

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int totalCount =0;
		
		for(int i=1; i<=n;i++) { 
			deque.addLast(i);
		}
		
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			int index = 1;
			
			for(Iterator iter = deque.iterator(); ;iter.hasNext()) {
				if(num == (int)iter.next()) break;
				index++;
				
			}
			
			int leftCount = index -1;
			int rightCount = deque.size() - index+1;
				
			if(leftCount < rightCount) {
				for(int i1=0; i1<leftCount;i1++) {
					deque.addLast(deque.removeFirst());
					totalCount++;
				}
				deque.removeFirst();
			}
			else {
				for(int i1=0; i1<rightCount;i1++) {
					deque.addFirst(deque.removeLast());
					totalCount++;
				}
				deque.removeFirst();
			}
			
		}
		System.out.println(totalCount);
	}
}
