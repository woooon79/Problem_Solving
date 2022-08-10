package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11660_구간합구하기5_윤호운 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    //행마다 0~n 까지의 합을 넣을 배열 sum
	    int[][] sum = new int[n+1][n+1];

	    for(int i=1;i<=n;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=1;j<=n;j++) {
	    		sum[i][j]=sum[i][j-1]+Integer.parseInt(st.nextToken());
	    	}
	    }
	    
	    for(int i=0;i<m;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int x1=Integer.parseInt(st.nextToken());
	    	int y1=Integer.parseInt(st.nextToken());
	    	int x2=Integer.parseInt(st.nextToken());
	    	int y2=Integer.parseInt(st.nextToken());
	    	
	    	int ans=0;
	    	
	    	// (x1,y1)~(x2,y2) 까지의 합은
	    	// 각 행의 y1~y2 까지의 합=> sum(0~y2)-sum(0~y1-1)
	    	for(int k=x1;k<=x2;k++) {
	    		ans+=sum[k][y2]-sum[k][y1-1];
	    	}

	    	sb.append(ans+"\n");
	    }

	    System.out.println(sb);
	}
}
