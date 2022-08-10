package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author howoon
 *
 */

class Index{
	int d=5;
	int i,j;
	Index(int i,int j){
		this.i=i;
		this.j=j;
	}
	Index(int i,int j,int d){
		this.i=i;
		this.j=j;
		this.d=d;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i;
		result = prime * result + j;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Index other = (Index) obj;
		if (i != other.i)
			return false;
		if (j != other.j)
			return false;
		return true;
	}
	
	
}
//기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다.
// 동시에 움직인다 => 구슬 이동 위치 동시에 봐야댐
//* 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다. =>time 문제
//* 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다
//* 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다. =>while 문 같이 돌리기 
//* 또, 빨간 구슬과 파란 구슬의 크기는 한 칸을 모두 차지한다. 
//* 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다. =>이동문제
public class BJ_13460_구슬탈출2 {
	static int n,m;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	//파란 구슬을 구멍에 넣지 않고, 빨간 구슬만 넣기!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//파란색 최단거리는 고려할 필요없음 => visited x , time x
	
	public static int solve(Index red,Index hole,Index blue,char[][] map) {
		
		Queue<Index> q = new LinkedList<Index>();
		Queue<Index> b_q = new LinkedList<Index>();
		int[][] time = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		boolean[][] bvisited = new boolean[n][m];
		
		visited[red.i][red.j]=true;
		bvisited[blue.i][blue.j]=true;
		
		q.add(red);
		b_q.add(blue);
		int ans=-1;
		boolean chk=false;
		int num=0;
		
		while(!q.isEmpty()) {
			//빨간 구슬 주위 한 싸이클
			Index now = q.poll();
			Index bnow = b_q.poll();
			
			if(num>10) {
				return -1;
			}
				
			chk=false;
			for(int k=0;k<4;k++) {
				
//				int t_i=now.i+di[k];
//				int t_j=now.j+dj[k];
//				int bt_i=bnow.i+di[k];
//				int bt_j=bnow.j+dj[k];
				
				int t_i=now.i;
				int t_j=now.j;
				int bt_i=bnow.i;
				int bt_j=bnow.j;
				
				
				//red 쭈우우ㅜㅇㄱ 이동
				int rcnt=0;
				while(true) {
					if(t_i+di[k]<0||t_j+dj[k]<0||t_i+di[k]>=n||t_j+dj[k]>=m||map[t_i+di[k]][t_j+dj[k]]=='#')
						break;
					t_i+=di[k];
					t_j+=dj[k];
					rcnt++;
					if(map[t_i][t_j]=='O') {
						chk=true;
						//System.out.println("red");
						break;
					}
						
				}
				// blue 쭈우우우ㅜ웅ㄱ 이동
				int bcnt=0;
				while(true) {
					if(bt_i+di[k]<0||bt_j+dj[k]<0||bt_i+di[k]>=n||bt_j+dj[k]>=m||map[bt_i+di[k]][bt_j+dj[k]]=='#')
						break;
					bt_i+=di[k];
					bt_j+=dj[k];
					bcnt++;
					if(map[bt_i][bt_j]=='O') {
						//System.out.println("blue");
						break;
					}
				}
				
				
				
				// R과 B 가 붙어 있을때 처리 
				if(bt_i==t_i && bt_j==t_j) {
					System.out.println("nooooooo");
					System.out.println(rcnt+" "+bcnt);
					if(rcnt<bcnt) {
						bt_i-=di[k];
						bt_j-=dj[k];
					}
					if(rcnt>bcnt) {
						t_i-=di[k];
						t_j-=dj[k];
					}	
					//만약 r과 b 가 같이 들어간다면 실패
					if(chk) {
						return -1;	
					}
				
				}
				
				else if(chk) {
					return time[now.i][now.j]+1;
				}

				if(!visited[t_i][t_j]||!visited[bt_i][bt_j]) {
					continue;
				}
				
				//이동한 R과 B의 위치 구하기 완료
				
				
				q.add(new Index(t_i,t_j));
				visited[t_i][t_j]=true;
				time[t_i][t_j]=time[now.i][now.j]+1;
				b_q.add(new Index(bt_i,bt_j));
				bvisited[bt_i][bt_j]=true;
				
				
				
				//방향이 바뀔떄만 time 값을 조정한다
//				if(now.d==k)
//					time[t_i][t_j]=time[now.i][now.j];
//				else
//					time[t_i][t_j]=time[now.i][now.j]+1;
			}
			
			num++;
		}
		//System.out.println("really");
		return -1;
		
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    
	    
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    char[][] map = new char[n][m];
	     for(int i=0;i<n;i++) {
	    	 map[i]=br.readLine().toCharArray();
	     }
	    
	    Index blue=null;
	    Index red=null;
	    Index hole=null;
	    for(int i=0;i<n;i++) {
	    	for(int j=0;j<m;j++) {
	    		if(map[i][j]=='B') {
	    			blue=new Index(i,j);
	    		}
	    		else if(map[i][j]=='R') {
	    			red=new Index(i,j);
	    		}
	    		else if(map[i][j]=='O') {
	    			hole=new Index(i,j);
	    		}
	    	}
	    }

	  
	    System.out.println(solve(red,hole,blue,map));
	}
}
