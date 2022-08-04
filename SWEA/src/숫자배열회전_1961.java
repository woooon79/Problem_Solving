import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 숫자배열회전_1961 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    int tc=Integer.parseInt(br.readLine());
	    StringBuffer sb=new StringBuffer();
	    
	    
	    for(int t=1;t<=tc;t++){
	    	
	    	String answer="";
	    	int n=Integer.parseInt(br.readLine());
	    	//arr에 배열 입력받기
	    	int[][] arr=new int[n][n];
	    	for(int i=0;i<n;i++) {
	    		StringTokenizer st = new StringTokenizer(br.readLine());
	    		for(int j=0;j<n;j++) {
	    			arr[i][j]= Integer.parseInt(st.nextToken());
	    		}
	    	}
	    	
	    	for(int i=0;i<n;i++) {
	    		
	    		String r90="";
	    		String r180="";
	    		String r270="";
	    		
	    		//90도,180도,270도 회전하였을때를 행마다 구하여 결과 문자열에 이어붙인다
	    		for(int j=0;j<n;j++) {
	    			r90+=arr[n-1-j][i];
	    			r180+=arr[n-1-i][n-1-j];
	    			r270+=arr[j][n-1-i];
	    		}
	    		
	    		answer+=r90+" "+r180+" "+r270+"\n";
	    		
	    	}

	    	
	    	sb.append("#"+t+"\n"+answer);
	    }
	    
	    System.out.println(sb);
	   
	    

	}
}
