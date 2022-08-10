package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1233_사칙연산유효성검사_윤호운 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();

	    for(int t=1;t<=10;t++) {
	    	int n = Integer.parseInt(br.readLine());
	    	String operator ="-+*/";
	    	int ans=1;
	    	
	    	for(int i=0;i<n;i++) {
	    		StringTokenizer st = new StringTokenizer(br.readLine());
	    		if(ans!=0) {
		    		Integer.parseInt(st.nextToken()); //정접번호 읽기
		    		if(operator.contains(st.nextToken())) { //산술연산자
		    			int num=0;
		    			while(st.hasMoreTokens()) {
		    				num++;
		    				st.nextToken();
		    			}
		    			if(num!=2) { //남은게 두개가 아니면 실패
		    				ans=0;
		    				continue;
		    			}
		    				
		    		}
		    		else { //산술연산자 아님
		    			if(st.hasMoreTokens()) { //더 있으면 실패
		    				ans=0;
		    				continue;
		    			}
		    		}
	    	   }
	    	}
	    	sb.append("#"+t+" "+ans+"\n");
	    }
	    
	    System.out.println(sb);
	}
}
