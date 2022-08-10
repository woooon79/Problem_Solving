package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class BJ_16935_배열돌리기3_윤호운 {
	static int n,m;
	public static int[][] move (int[][] newarr,int[][] origin,int number) {
		
		switch(number) {
		case 1: //상하반전
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					newarr[i][j]=origin[n-i-1][j];
				}
			}
			break;
		case 2: //좌우반전
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					newarr[i][j]=origin[i][m-j-1];
				}
			}
			break;
		case 3: // 새로운 배열 행/열 크기 바꿔야함!
			newarr = new int[origin[0].length][origin.length];
			for(int j=0;j<m;j++) {
				for(int i=0;i<n;i++) {
					newarr[j][i]=origin[n-1-i][j];
				}
			}
			m = origin.length;
			n = origin[0].length;
			break;
		case 4:// 새로운 배열 행/열 크기 바꿔야함!
			
			newarr = new int[origin[0].length][origin.length];
			for(int j=0;j<m;j++) {
				for(int i=0;i<n;i++) {
					newarr[j][i]=origin[i][m-1-j];
				}
			}
			m = origin.length;
			n = origin[0].length;
			break;
		case 5:
		case 6: //일단 그룹별로 나눠줌
			int[][] g1 = new int[n/2][];
			int[][] g2 = new int[n/2][];
			int[][] g3 = new int[n/2][];
			int[][] g4 = new int[n/2][];
			int i=0;
			int p=0;
			for(int[] row: origin) {
				if(i<n/2) {
					g1[i]=Arrays.copyOfRange(row, 0, m/2);
					g2[i]=Arrays.copyOfRange(row, m/2, m);
				}
				else {
					g4[p]=Arrays.copyOfRange(row, 0, m/2);
					g3[p]=Arrays.copyOfRange(row, m/2, m);
					p++;
				}	
				i++;
			}
			//새로운 2차원 배열에 삽입
			/**
			 * 4 1
			 * 3 2
			 */
			if(number==5) {
				i=0;
				for(int k=0;k<n/2;k++) {
					int[] row = new int[m];
					System.arraycopy(g4[k], 0, row, 0, g4[k].length);
					System.arraycopy(g1[k], 0, row, g4[k].length, g1[k].length);
					newarr[i++]=row;
				}
				for(int k=0;k<n/2;k++) {
					int[] row = new int[m];
					System.arraycopy(g3[k], 0, row, 0, g3[k].length);
					System.arraycopy(g2[k], 0, row, g3[k].length, g2[k].length);
					newarr[i++]=row;
				}
			}
			/**
			 * 2 3
			 * 1 4
			 */
			else if(number==6) {
				i=0;
				for(int k=0;k<n/2;k++) {
					int[] row = new int[m];
					System.arraycopy(g2[k], 0, row, 0, g2[k].length);
					System.arraycopy(g3[k], 0, row, g2[k].length, g3[k].length);
					newarr[i++]=row;
				}
				for(int k=0;k<n/2;k++) {
					int[] row = new int[m];
					System.arraycopy(g1[k], 0, row, 0, g1[k].length);
					System.arraycopy(g4[k], 0, row, g1[k].length, g4[k].length);
					newarr[i++]=row;
				}
			}
			break;

		}
		
		return newarr;
		
//
//		for(int i=0;i<newarr.length;i++) {
//			for(int j=0;j<newarr[0].length;j++) {
//				System.out.print(newarr[i][j]+" ");
//			}
//			System.out.println();
//		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    
	    //입력받기
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    int r = Integer.parseInt(st.nextToken());
	    
	    int[][] arr = new int[n][m];
	    for(int i=0;i<n;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=0;j<m;j++) {
	    		arr[i][j]= Integer.parseInt(st.nextToken());
	    	}
	    }
	    st = new StringTokenizer(br.readLine());
	    
	    
	    for(int i=0;i<r;i++) {
	    	int num = Integer.parseInt(st.nextToken());
	    	 arr = move(new int[n][m],arr,num);
	    }

	    for(int i=0;i<arr.length;i++) {
	    	for(int j=0;j<arr[0].length;j++) {
	    		sb.append(arr[i][j]+" ");
	    	}
	    	sb.append("\n");
	    }
	    
	    System.out.println(sb);
	}
}
