package ps.data.structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2164_카드2_윤호운 {
	 public static void main(String[] args) throws IOException {
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		    // 선입선출 => 큐~!
		    int num=Integer.parseInt(br.readLine());
		    Queue<Integer> q = new LinkedList<Integer>();
		    for(int i=1;i<=num;i++) {
		    	q.add(i);
		    }
		    //큐 사이즈 1되면 while문 탈출
		    while(q.size()>1) {
		    	//카드 버리기
		    	q.poll();
		    	//뽑은 카드 맨 아래에 넣기 
		    	q.add(q.poll());
		    }
		    //마지막남은 카드 큐에서 poll
		    System.out.println(q.poll());
		    br.close();
		    
	 }
}
