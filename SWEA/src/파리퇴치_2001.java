import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 파리퇴치_2001 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int tc=Integer.parseInt(br.readLine());
	    StringBuffer sb=new StringBuffer();
	    
	    for(int t=1;t<=tc;t++){
	    	StringTokenizer st=new StringTokenizer(br.readLine());
	    	int n=Integer.parseInt(st.nextToken());
	    	int m = Integer.parseInt(st.nextToken());
	    	int[][] arr = new int[n][n];
	    	int answer=0;
	    	
	    	for(int i=0;i<n;i++) {
	    		st=new StringTokenizer( br.readLine());
	    		for(int j=0;j<n;j++) {
	    			arr[i][j]=Integer.parseInt(st.nextToken());
	    		}
	    	}
	    	
	    	for(int i=0;i<n-m+1;i++) {
	    		for(int j=0;j<n-m+1;j++) {
	    			int sum=0;
	    			for(int p=0;p<m;p++) {
	    				for(int k=0;k<m;k++) {
	    					sum+=arr[i+p][j+k];
	    				}
	    			}
	    			
	    			if(sum>answer)
						answer=sum;
	    			
	    		}
	    	}
	    	
	    	sb.append("#"+t+" "+answer+"\n");
	    }
	    
	    System.out.println(sb);
	   
	    

	}
}
