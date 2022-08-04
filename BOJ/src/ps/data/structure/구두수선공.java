package ps.data.structure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 구두수선공
 * https://www.acmicpc.net/submit/14908/25399479
 * @author Howoon
 *
 */
 class Todo implements Comparable<Todo>{
	double total;
	int num;
	
	Todo(double total,int num){
		this.total=total;
		this.num=num;
	}

	@Override
	public int compareTo(Todo o) {
		// TODO Auto-generated method stub
		//같다면 오름차순
		if(o.total==total)
			return num-o.num;
		else
		    {
			if(o.total>total)
				return 1;
			else
				return -1;
		    }
	}
	
	
}
public class 구두수선공 {
	 public static void main(String[] args) throws IOException {
			// TODO Auto-generated method stub
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		    
		    int num=Integer.parseInt(br.readLine());
		    Todo[] tlist=new Todo[num];
		    
		    StringTokenizer st;
		    for(int i=0;i<num;i++) {
		    	st= new StringTokenizer(br.readLine());
		    	//걸리는 일 수
		    	int days=Integer.parseInt(st.nextToken());
		    	//지연될때마다 내는 보상금
		    	int penalty=Integer.parseInt(st.nextToken());
		    	
		    	//일수 대비 패널티가 작은 순으로 정렬 하기 위해 Todo 클래스 생성
		    	tlist[i]=new Todo((double)penalty/days,i+1);
		    }
		    
		    //정렬
		    Arrays.sort(tlist);
		    
		    for(Todo tmp:tlist) {
		    	//bw.write(tmp.num+" ");
		    	System.out.print(tmp.num+" ");
		    }
		    
		  //  bw.flush();
		    bw.close();
		    br.close();
		    
	 }
}