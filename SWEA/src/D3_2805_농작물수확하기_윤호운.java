package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_2805_농작물수확하기_윤호운 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    
	    int tc = Integer.parseInt(br.readLine());
	    
	    for(int t=1;t<=tc;t++) {
	    	int n = Integer.parseInt(br.readLine());
	    	int ans=0;
	    	//배열 저장
	    	char[][] arr = new char[n][n];
	    	for(int i=0;i<n;i++) {
	    		arr[i]=br.readLine().toCharArray();
	    	}
	    	
	    	//삼각형 다 더하기
	    	int start = n/2;  //시작 열값
	    	for(int i=0;i<n/2+1;i++) {
	    		for(int j=start;j<n-start;j++) {
	    			ans+=arr[i][j]-'0';
	    		}
	    		start--;
	    	}
	    	//역삼각형 다 더하기
	    	start=1;  //시작 열값
	    	for(int i=n/2+1;i<n;i++) {
	    		for(int j=start;j<n-start;j++) {
	    			ans+=arr[i][j]-'0';
	    		}
	    		start++;
	    	}
	    	
	    	
	    	sb.append("#"+t+" "+ans+"\n");
	    }
	    
	    System.out.println(sb);
	}
}
