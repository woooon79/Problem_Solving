import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D3_1225_암호생성기_윤호운 {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String input="";
		StringBuilder sb = new StringBuilder();
		while((input=br.readLine())!=null&&!input.isEmpty()) {
			StringBuilder ans = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			//선입선출 => 큐이용
			Queue<Integer> q = new LinkedList<Integer>();
			
			//큐에 암호들 입력
			for(int i=0;i<8;i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean chk=false;
			while(!chk) {
				//한 싸이클
				for(int i=1;i<=5;i++) {
					int temp = q.poll();
					temp-=i;
					// 감소했을때 0보다 작거나 같으면 0을 큐에 넣고 종료
					if(temp<=0) {
						temp=0;
						q.add(temp);
						chk=true;
						break;
					}
					q.add(temp);
				}
			}
			// 큐의 값들을 빼서 stringbuildr에 append
			while(!q.isEmpty()) {
				ans.append(q.poll()+" ");
			}
			
			sb.append("#"+input+" "+ans.toString()+"\n");
		}
		
		System.out.println(sb);
	}
}
