package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16926_배열돌리기1_윤호운 {
	static int n,m;
	public static void move (int[][] newarr,int[][] origin,int index) {
		//왼 
		for(int i=index+1;i<n-index;i++) {
			newarr[i][index]=origin[i-1][index];
		}
		//위 
		for(int i=index;i<m-1-index;i++) {
			newarr[index][i]=origin[index][i+1];
		}
		//오 . 열고정
		for(int i=index;i<n-1-index;i++) {
			newarr[i][m-index-1]=origin[i+1][m-index-1];
		}
		//아래 . 행고정
		for(int i=index+1;i<m-index;i++) {
			newarr[n-index-1][i]=origin[n-index-1][i-1];
		}
		
		
//		for(int i=0;i<n;i++) {
//			for(int j=0;j<m;j++) {
//				System.out.print(newarr[i][j]+" ");
//			}
//			System.out.println();
//		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    int r = Integer.parseInt(st.nextToken());
	    //입력받기
	    int[][] arr = new int[n][m];
	    for(int i=0;i<n;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=0;j<m;j++) {
	    		arr[i][j]= Integer.parseInt(st.nextToken());
	    	}
	    }
	    
	    for(int i=0;i<r;i++) {
	    	int k=0;
	    	int[][] temp = new int[n][m];
	    	while(true) {
	    		if(temp[k][k]!=0)
	    			break;
	    		move(temp,arr,k++);
	    	}
	    	arr = temp;
	    }
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<m;j++) {
	    		sb.append(arr[i][j]+" ");
	    	}
	    	sb.append("\n");
	    }
	    
	    System.out.println(sb);
	}
}
