
import java.io.*;
import java.util.*;

public class BJ_1158_요세푸스문제_윤호운 {

	public static void main(String[] args) throws IOException  {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		// 큐에 1-n까지 삽입
		for(int i=1;i<=n;i++) {
			q.offer(i);
		}
		int seq=0;
		
		StringBuilder sb=new StringBuilder();
		sb.append("<");
		while(!q.isEmpty()) {
			int tmp=q.poll(); //큐에서 하나 뽑음
			seq++; //순서 한개씩 증가
			if(seq==k) { // 첫번쨰 요세푸스 값 : k번쨰면 정답 문자열에 추가 하고 continue
				sb.append(tmp);
				continue;
			}
			if (seq%k==0) { //k로 나눴을떄 나머지 0이면 ','와 함께 정답 문자열에 추가하고 continue 
				sb.append(", "+tmp);
				continue;
			}
			q.offer(tmp); //큐에 다시삽입
		}
		sb.append(">");
		System.out.println(sb.toString());
		
	}
}
