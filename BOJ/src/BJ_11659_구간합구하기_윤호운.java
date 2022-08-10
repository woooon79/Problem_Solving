package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11659_구간합구하기_윤호운 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    //0~n 까지의 합을 넣을 배열 sum
	    int[] sum = new int[n+1];
	    
	    st = new StringTokenizer(br.readLine());
	    for(int i=1;i<=n;i++) {
	    	sum[i]=sum[i-1]+Integer.parseInt(st.nextToken());;
	    }
	    
	    for(int i=0;i<m;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int a=Integer.parseInt(st.nextToken());
	    	int b=Integer.parseInt(st.nextToken());
	    	//a~b 까지의 합은 sum(0~b)-sum(0~a-1)
	    	sb.append(sum[b]-sum[a-1]+"\n");
	    }

	    System.out.println(sb);
	}
}
