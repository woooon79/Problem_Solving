import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 스도쿠검증_1974 {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		//Testcase 개수
		int tc=Integer.parseInt(br.readLine());
	    StringBuffer sb=new StringBuffer();
	    
	    for(int t=1;t<=tc;t++){
	    	int[][] arr = new int[9][9];
	    	int answer=1;
	    	
	    	//arr에 스도쿠 저장
	    	for(int i=0;i<9;i++) {
	    		StringTokenizer st=new StringTokenizer( br.readLine());
	    		for(int j=0;j<9;j++) {
	    			arr[i][j]=Integer.parseInt(st.nextToken());
	    		}
	    	}

	    	//chk: 중복 확인
	    	//row: 행확인 / col:열 확인 / box: 박스확인
	    	boolean chk = false;	
	    	for(int i=0;i<9;i++) {
		    	boolean[] row = new boolean[10];
		    	boolean[] col = new boolean[10];
		    	
	    		for(int j=0;j<9;j++) {
	    			if(row[arr[i][j]]||col[arr[j][i]]) chk=true;
	    			row[arr[i][j]]=true;
	    			col[arr[j][i]]=true;
	    			
	    			if((i==0||i%3==0)&&(j==0||j%3==0)) {
	    				boolean[] box = new boolean[10];
	    				for(int k=0;k<3;k++) {
	    					for(int p=0;p<3;p++){
	    						if(box[arr[i+k][j+p]]) chk=true;
	    						box[arr[i+k][j+p]]=true;
	    					}
	    				}
	    			}
	    			
	    		}
	    		
	    		if(chk) {answer=0;break;}
	    	}
	    	
	    	
	    
	    	sb.append("#"+t+" "+answer+"\n");
	    }
	    
	    System.out.println(sb);
	   
	    

	}
}
