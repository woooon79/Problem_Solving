package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1~18까지 적힌 18장의 카드 =>9장씩 나눔 => 9라운드 
// 이기면 : 합만큼 점수 가져감 

//완전 탐색
public class D3_6808_규영이와인영이의카드게임_윤호운 {
	
	static int[] gyu = new int[9];
	static int win,lose;
	//카드 한장씩 비교하면서 규영이의 win,lose 개수 세기
	static void solve(int[] output) {
		int gs=0;
		int is=0;
		for(int i=0;i<9;i++) {
			if(gyu[i]>output[i]) {
				gs=gs+(gyu[i]+output[i]);
			}
			else {
				is=is+(gyu[i]+output[i]);
			}
		}
		if(gs>is)
			win++;
		else if(gs<is)
			lose++;
	}
	//인영이 카드 모든 경우의 수 구하기 => 순열 구하기
	static void perm(int[] inyoung, int[] output, boolean[] visited, int depth, int n) {
	    if (depth == n) {
	        solve(output);
	        return;
	    }
	    for (int i=0; i<n; i++) {
	        if (visited[i] != true) {
	            visited[i] = true;
	            output[depth] = inyoung[i];
	            perm(inyoung, output, visited, depth + 1, n);       
	            visited[i] = false;;
	        }
	    }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int tc = Integer.parseInt(br.readLine());
	    // 이기는 경우 .. 지는 경우
	    for(int t=1;t<=tc;t++) {
	    	int ans=0;
	    	boolean[] arr = new boolean[19];
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	for(int i=0;i<9;i++) {
	    		gyu[i]=Integer.parseInt(st.nextToken());
	    		arr[gyu[i]]=true; 
	    	}
	    	int[] inyoung = new int[9]; //인영이 배열 구하기
	    	int cnt=0;
	    	for(int i=1;i<=18;i++) {
	    		if(!arr[i])
	    			inyoung[cnt++]=i;
	    	}
	    	perm(inyoung, new int[9],new boolean[9],0,9); //인영이 경우의수 다 구하기

	    	sb.append("#"+t+" "+win+" "+lose+"\n");
	    	win=0;
	    	lose=0;
	    }
	    
	    System.out.println(sb);
	}
}
