import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 어디에단어가들어갈수있을까_1979 {
	

	public static int solve(String temp,int k) {
		int answer=0;
		String[] word=temp.split("0");
		for(int j=0;j<word.length;j++) {
			if(word[j].length()==k)
				answer++;
		}
		return answer;
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int tc=Integer.parseInt(br.readLine());
	    StringBuffer sb=new StringBuffer();
	    
	    for(int t=1;t<=tc;t++){
	    	StringTokenizer st=new StringTokenizer(br.readLine());
	    	int n=Integer.parseInt(st.nextToken());
	    	int k = Integer.parseInt(st.nextToken());
	    	int[][] arr = new int[n][n];
	    	int answer=0;
	    	
	    	for(int i=0;i<n;i++) {
	    		String row = br.readLine();
	    		st=new StringTokenizer(row);
	    		for(int j=0;j<n;j++) {
	    			arr[i][j]=Integer.parseInt(st.nextToken());
	    		}
	    		row=row.replaceAll(" ", "");
	    		answer+=solve(row,k);
	    	}
	    	
	    
	    	for(int i=0;i<n;i++) {
	    		String col = "";
	    		for(int j=0;j<n;j++) {
	    			col+=arr[j][i];
	    		}
	    		answer+=solve(col,k);
	    	}
	    	
	    	sb.append("#"+t+" "+answer+"\n");
	    }
	    
	    System.out.println(sb);
	   
	    

	}

}
