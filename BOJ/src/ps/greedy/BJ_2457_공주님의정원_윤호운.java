package ps.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_2457_공주님의정원_윤호운 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	 
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    
	    char[] arr = br.readLine().toCharArray();
	    StringBuilder sb =new StringBuilder();
	    
	    //마지막 결과값 출력을 위해 덱 자료구조사용
	    
	    Deque<Character> s = new ArrayDeque<>();
	    int cnt=0;
	    int i=0;
	    for(i=0;i<n;i++) {
	    	//일단 덱에 첫자리 삽입
	    	if(s.isEmpty()) {
	    		s.addFirst(arr[i]);
	    		continue;
	    	}
	    	//현재 자릿수랑 덱에 있는 수들과 비교 (자신이 더 크면 덱에서 제거)
	    	while(!s.isEmpty()&&cnt<k) {
	    	if(arr[i]>s.peek()) {
	    		s.poll();
	    		cnt++;
	    	}
	    	else 
	    		break;
	    	}
	    	
	    	s.push(arr[i]);
	    	
	    	//제거한 수가 k개면 break
	    	if(cnt==k)
	    		break;
	    	
	    	
	    }
	    
	    if(s.size()>=n-k) {
	    	for(int t=0;t<n-k;t++) {
	    		sb.append(s.pollLast());
	    	}
	    	
	    }
	    
	    else {
	    	while(!s.isEmpty()) {
	    		sb.append(s.pollLast());
	    	}
	    	
	    	for(int t=i+1;t<n;t++) {
	    		sb.append(arr[t]);
	    	}
	    }
	    
	    System.out.println(sb);
	}
}
