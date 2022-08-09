import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class D3_9229_한빈이와SpotMart_윤호운 {
	public static int max=-1;
	//두과자의 합이 m보다 작거나 같은 경우, max와 비교해서 max값 갱신 
	public static void findMax(int[] arr, boolean[] visited,int m) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			if(visited[i]) {
				sum+=arr[i];
			}
		}
		if(sum>max&&sum<=m)
			max=sum;
	}
	//두개 뽑는 모든 경우의 수 구하는 메서드 :백트래킹
	public static void comb(int[] arr, int start,int r,boolean[] visited,int m) {
		if(r==0) {
			findMax(arr,visited,m);
			return;
		}
		for(int i=start;i<arr.length;i++) {
			visited[i]=true;
			comb(arr,i+1,r-1,visited,m);
			visited[i]=false;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb=new StringBuffer();
	    int tc = Integer.parseInt(br.readLine());
	    
	    for(int t=1;t<=tc;t++){
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	int n=Integer.parseInt(st.nextToken()); //과자 개수
	    	int m = Integer.parseInt(st.nextToken()); // 최대 합
	    	st = new StringTokenizer(br.readLine());
	    	int[] arr = new int[n];
	    	for(int i=0;i<n;i++) {
	    		arr[i]=Integer.parseInt(st.nextToken());
	    	}
	    	comb(arr,0,2,new boolean[n],m); //두개 뽑는 경우의 수를 구해서 검사
	    	sb.append("#"+t+" "+max+"\n");
	    	max=-1; //테케마다 max값 초기화
	    }
	    
	    System.out.println(sb);
	    
	}
}
