import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D3_1228_암호문1_윤호운 {
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb=new StringBuffer();
	    
	    for(int t=1;t<=10;t++){
	    	// 숫자 담을 array list
	    	ArrayList<String> list = new ArrayList<>();
	    	int num = Integer.parseInt(br.readLine());
	    	
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	for(int i=0;i<num;i++) {
	    		list.add(st.nextToken()); 
	    	}
	    	
	    	int change = Integer.parseInt(br.readLine());
	    	st= new StringTokenizer(br.readLine());
	    	// 명령어 개수만큼 arraylist 인덱스에 읽은 숫자 삽입
	    	while(change>0) {
	    		if(st.nextToken().equals("I")) {
	    			int index = Integer.parseInt(st.nextToken());
	    			int cnt = Integer.parseInt(st.nextToken());
	    			for(int i=0;i<cnt;i++) {
	    				list.add(index+i,st.nextToken()); //숫자 삽입
	    			}
	    			change--;
	    		}
	    	}
	    	// 정답문자열 앞에서 10개 stringbuffer에 저장
	    	StringBuffer ans = new StringBuffer();
	    	for(int i=0;i<10;i++) {
	    		ans.append(list.get(i)+" ");
	    	}
	    	
	    	sb.append("#"+t+" "+ans.toString()+"\n");
	    }
	    
	    System.out.println(sb);
	   
	    

	}
}
