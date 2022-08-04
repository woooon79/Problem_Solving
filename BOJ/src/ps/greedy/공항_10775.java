package ps.greedy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * 공항
 * https://www.acmicpc.net/problem/10775
 *
 */
public class 공항_10775 {
	static int[] prepare;
	static void union(int a, int b) {
		//g 게이트 도킹했으니 예비게이트 할당
		//예비 게이트는 [현재 게이트 -1]
		a = find(a);
		b = find(b);
		
		prepare[a] = b;
	}
	
	static int find(int x) {
		//g 번 게이트면 return g
		if(x == prepare[x]) 
			return x;
		// 아니면 예비 게이트 탐색
		prepare[x] = find(prepare[x]);
		return prepare[x];
	}
	
	//비행기를 도착하는 순서대로 도킹 
	//각 비행기를 g번 게이트에 도킹시키고, 안되면 g-1,g-2 ..차례대로 되는 곳을 찾는다
	//=> 시간초과 ->유니온파인드
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	 
	    int ngate=Integer.parseInt(br.readLine());
	    int nplane=Integer.parseInt(br.readLine());
	    
	  //각 게이트마다 예비 게이트 할당
	    prepare = new int[ngate+1];
	    for(int i=1;i<=ngate;i++) {
	    	prepare[i]=i;
	    }
	    
	    int result=0;
	    for(int i=0;i<nplane;i++) {
	    	int g=Integer.parseInt(br.readLine());
	    	//게이트 찾기
	    	int empty = find(g);
	    	if(empty==0)
	    		break;
	    	result++;
	     union(find(g),find(g)-1);
	    	
	    }
	    
	    
	   
    System.out.println(result);
    	
	}
}