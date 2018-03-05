package BOJ10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		Queue<Integer> queue = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		
		int back = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(reader.readLine());
			String first = st.nextToken();
			switch (first) {
			case "push":
				int pushNum = Integer.parseInt(st.nextToken());
				queue.add(pushNum);
				back = pushNum;
				break;
				
			case "pop":
				if (!queue.isEmpty()) {
					int popNum = queue.poll();
					sb.append(popNum+"\n");
				} else
					sb.append("-1\n");
				break;
				
			case "size":
				sb.append(queue.size() + "\n");
				break;
				
			case "empty":
				if (queue.isEmpty())
					sb.append("1\n");
				else
					sb.append("0\n");
				break;
				
			case "front":
				if (!queue.isEmpty())
					sb.append(queue.peek() + "\n");
				else
					sb.append("-1\n");
				break;
				
			case "back":
				if (!queue.isEmpty())
					sb.append(back+"\n");
				else
					sb.append("-1\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}