package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D3_1210_Ladder1_윤호운 {
	
	
	public static int solve (int dest,int[][] arr) {
		// n_i: 현재 위치의 행 인덱스 , n_j : 현재 위치의 열 인덱스
		int n_i=99;
		int n_j=dest;
		//방문했는지 확인하는 용도의 배열
		boolean[][] visited = new boolean[100][100];
		while(true) {
			if(n_i==0)
				break;
			//왼쪽에 방문하지 않았고 1이면 왼쪽으로이동
			if(n_j>0&&arr[n_i][n_j-1]==1&&!visited[n_i][n_j-1]) {
				n_j--;
			}
			//오른쪽에 방문하지 않았고 1이면 오른쪽으로 이동
			else if(n_j<99&&arr[n_i][n_j+1]==1&&!visited[n_i][n_j+1]) {
				n_j++;
			}
			// 둘다없으면 그냥 위로
			else {
				n_i--;
				}
			// 방문표시
			visited[n_i][n_j]=true;

		}
		
		//열값 반환
		return n_j;
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    
	    for(int t=1;t<11;t++) {
	    	br.readLine();
	    	
	    	// int형 배열 arr에 사다리값 저장
	    	int[][] arr = new int[100][100];;
	    	int dest=0; //열 값
	    	for(int i=0;i<100;i++) {
	    		StringTokenizer st =new StringTokenizer(br.readLine());
	    		for(int j=0;j<100;j++) {
	    			arr[i][j]=Integer.parseInt(st.nextToken());
	    			if(i==99&&arr[i][j]==2)
	    				dest = j;
	    		}
	    	}
	    	
	    	
	    	int ans=solve(dest,arr);
	    	sb.append("#"+t+" "+ans+"\n");
	    }
	    
	    System.out.println(sb);
	}
}
