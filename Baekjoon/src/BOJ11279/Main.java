package BOJ11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//x 가 0이면 루트 출력 , 자연수이면  insert
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		StringBuffer sb = new StringBuffer();
		Heap heap = new Heap(n + 1);

		for (int i = 0; i < n; i++) {
			int t = Integer.parseInt(in.readLine());
			if (t == 0) {
				sb.append(heap.delete()).append("\n");
			} else {
				heap.insert(t);
			}
		}
		System.out.println(sb.toString());

	}
}

class Heap {
	int arr[];
	int capacity;
	int size = 0;

	Heap(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity + 1];
	}

	void insert(int value) {
		arr[++size] = value;
		if (size == 1)
			return;
		else {
			int idx = size;
			while (idx > 1) {
				if (arr[idx] > arr[idx / 2]) {
					swap(idx, idx / 2);
					idx /= 2;
				} else
					break;
			}
		}
	}

	int delete() {
		if (empty())
			return 0;

		int ret = arr[1];
		arr[1] = arr[size--];

		int cnt = 1;
		int child = cnt * 2;
		while (child <= size) {
			if (child + 1 <= size) {
				child = (arr[child] < arr[child + 1] ? child + 1 : child);
			}

			if (arr[cnt] < arr[child])
				swap(cnt, child);
			cnt = child;
			child = cnt * 2;
		}
		return ret;
	}

	boolean empty() {
		return size == 0;
	}

	void swap(int cnt, int pnt) {
		int tmp = arr[cnt];
		arr[cnt] = arr[pnt];
		arr[pnt] = tmp;
	}
}
