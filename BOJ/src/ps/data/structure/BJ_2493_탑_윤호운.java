package ps.data.structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 타워의 인덱스와 높이를 가지고 있는 클래스
class Tower{
	int height;
	int index;
	Tower(int h,int i){
		height=h;
		index=i;
	}
}

public class BJ_2493_탑_윤호운 {
	
	
	public static void main(String[] args) throws IOException {

		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    
	    int n = Integer.parseInt(br.readLine());
	    
	    //입력
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    Tower[] arr = new Tower[n+1];
	    for(int i=1;i<=n;i++) {
	    	arr[i]= new Tower(Integer.parseInt(st.nextToken()),i);
	    }
	    
	    Stack<Tower> s = new Stack<Tower>();
	    
	    //정답 넣을 배열
	    int[] ans = new int[n+1];
	    ans[1]=0;  //첫번쨰 탑은 무조건 0
	    for(int i=n;i>1;i--) {
	    	//왼쪽 탑이 나보다 같거나 크면
	    	if(arr[i-1].height>=arr[i].height) {
	    		//정답배열의 현재 팁인덱스에 왼쪽탑 인덱스 데입
	    		ans[i]=i-1;
	    		// 스택이 비어있지않고 왼쪽탑 높이가 스택맨위 탑높이값보다 크면, 스택에서 값을 빼고 왼쪽탑 인덱스를 정답배열에 넣는다 => 스택에는 위에서부터 오름차순 순으로 쌓여있을 수밖에없음
	    		while(!s.isEmpty()&&arr[i-1].height>=s.peek().height) {
	    				Tower temp=s.pop();
	    				ans[temp.index]=i-1;
	    		}
	    	}
	    	else {
	    		//왼쪽 탑이 나보다 작으면 스택에 넣는다
	    		s.add(arr[i]);
	    	}
	    }
	    
	    //스택에 값이 남아있으면 다 빼서 정답을 0으로 ->레이저 맞은 탑이없음
	    while(!s.isEmpty()) {
	    	Tower temp=s.pop();
	    	ans[temp.index]=0;
	    }
	    
	    for(int i=1;i<=n;i++) {
	    	System.out.print(ans[i]+" ");
	    }
	

	}
}
