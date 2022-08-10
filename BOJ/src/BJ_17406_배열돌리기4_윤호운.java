package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//회전 연산 담는 클래스
class Operation{
	int r,c,s;
	public Operation(int r, int c, int s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}
}
public class BJ_17406_배열돌리기4_윤호운 {
	static int n,m;
	static int ans = Integer.MAX_VALUE;
	static int[][] arr;
	static Operation[] opers;
	//최소 배열 A값 구하는 메서드
	public static void getMin(int[][] result) {
		int min=Integer.MAX_VALUE;
		for(int i=1;i<=n;i++) {
			int sum=0;
			for(int j=1;j<=m;j++) {
				sum+=result[i][j];
			}
			if(sum<min)
				min=sum;
		}
		if(min<ans)
			ans=min;
		
	}
	//회전연산 메서드
	public static int[][] rotate (int[][] newarr,int[][] origin,int si,int sj,int fi,int fj) {
		//왼 , 열 고정
		for(int i=si;i<fi;i++) {
			newarr[i][sj]=origin[i+1][sj];
		}
		//아래 . 행고정
		for(int i=sj;i<fj;i++) {
			newarr[fi][i]=origin[fi][i+1];
		}
		//위 , 행고정
		for(int i=sj+1;i<=fj;i++) {
			newarr[si][i]=origin[si][i-1];
		}
		//오 . 열고정
		for(int i=si+1;i<=fi;i++) {
			newarr[i][fj]=origin[i-1][fj];
		}

		return newarr;

	}

	//주어진 모든 회전연산 수행
	public static void move(int[] output) {
		int[][] nowarr = arr.clone();
		
		for(int p=0;p<output.length;p++) {
			Operation o = opers[output[p]];
			int[][] newarr = new int[n+1][m+1];
			int si = o.r-o.s;
			int sj =o.c-o.s;
			int fi=o.r+o.s;
			int fj=o.c+o.s;
			//외부네모~내부네모 회전하기
			while(true) {
				if(newarr[si][sj]!=0) //만약 시작점이 0이아니면 외부네모~내부네모 다 회전마친것이므로 탈출
					break;
				newarr=rotate(newarr,nowarr,si,sj,fi,fj); 
				//내부 네모 구하기 위해서 => 시작점을 오른쪽대각선아래한칸 , 끝점을 왼쪽대각선위로 한칸
				si++;
				sj++;
				fi--;
				fj--;
				//만약 시작점==끝점이면 값이 한개이므로 그냥 대입
				if((si==fi)&&(sj==fj))
					newarr[si][sj]=nowarr[si][sj];
			}
			//회전 연산 수행한 네모 이외의 배열값들 채워주기
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					if(newarr[i][j]==0)
						newarr[i][j]=nowarr[i][j];
						
				}
			}
			nowarr = newarr.clone();
		}
		//모든 회전 연산 끝낸후 최솟값 A 구하기
		getMin(nowarr);
		
	}
	
	
	//주어진 모든 회전연산 순서 정하기
	static void perm(int[] output, boolean[] visited, int depth, int n) {
		//순서 정할때마다 연산 수행
	    if (depth == n) {
	        move(output);
	        return;
	    }
	 
	    for (int i=0; i<n; i++) {
	        if (visited[i] != true) {
	            visited[i] = true;
	            output[depth] = i;
	            perm(output, visited, depth + 1, n);       
	            visited[i] = false;;
	        }
	    }
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    int k = Integer.parseInt(st.nextToken());
	    //입력받기
	    arr = new int[n+1][m+1];
	    for(int i=1;i<=n;i++) {
	    	st = new StringTokenizer(br.readLine());
	    	for(int j=1;j<=m;j++) {
	    		arr[i][j]= Integer.parseInt(st.nextToken());
	    	}
	    }
	    //회전 연산들 담는 배열
	    opers = new Operation[k];
	    for(int i=0;i<k;i++) {
	    	st= new StringTokenizer(br.readLine());
	    	opers[i] = new Operation(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
	    }
	    //회전연산들 순열 구하기 
	    perm(new int[k],new boolean[k],0,k);
	    
	    System.out.println(ans);
	}
}
