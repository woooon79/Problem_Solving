package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D4_1861_정사각형방_윤호운 {
	
	static int[] di= {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int n;
	static int max;
	static int value;
	
	public static void solve(int[][] arr,int i,int j,int sum,boolean[][] visited,int s_i,int s_j) {
		
		if(sum>max) {
			max=sum;
			value=arr[s_i][s_j];
			
		}else if(sum==max&&arr[s_i][s_j]<value) {
			value=arr[s_i][s_j];
		}
		for(int k=0;k<4;k++) {
			int t_i = i+di[k];
			int t_j = j+dj[k];
			
			if(t_i<0||t_j<0||t_i>=n||t_j>=n||visited[t_i][t_j]||arr[t_i][t_j]!=arr[i][j]+1)
				continue;
			visited[t_i][t_j]=true;
			solve(arr,t_i,t_j,sum+1,visited,s_i,s_j);
			visited[t_i][t_j]=false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int tc = Integer.parseInt(br.readLine());
	    for(int t=1;t<=tc;t++) {
	    	int ans=0;
	    	n = Integer.parseInt(br.readLine());
	    	int[][] arr = new int[n][n];
	    	
	    	for(int i=0;i<n;i++) {
	    		StringTokenizer st = new StringTokenizer(br.readLine());
	    		for(int j=0;j<n;j++) {
	    			arr[i][j]= Integer.parseInt(st.nextToken());
	    		}
	    	}
	    	
	    	for(int i=0;i<n;i++) {
	    		for(int j=0;j<n;j++) {
	    			solve(arr,i,j,1,new boolean[n][n],i,j);
	    		}
	    	}

	    	sb.append("#"+t+" "+value+" "+max+"\n");
	    	value=0;
	    	max=0;

	    }
	    
	    System.out.println(sb);
	}
}
