package ps.graph;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * 구슬탈출 2
 * https://www.acmicpc.net/problem/13460
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
}
//* 기울이는 동작을 그만하는 것은 더 이상 구슬이 움직이지 않을 때 까지이다. => 구슬이 벽에 닿을때까지 이동
//* 빨간 구슬이 구멍에 빠지면 성공이지만, 파란 구슬이 구멍에 빠지면 실패이다. => 빨간색 공이 먼저 빠지면 탐색 멈추기
//* 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패이다 => 하지만 같은 줄에 있을떄 동시에 빠지는지 검사
//
//*** 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다, 동시에 움직인다 => 구슬 이동 위치 동시에 봐야댐    *** 
// => 따로 bfs 불가 . 서로 이동할떄 영향을 줌 => bfs를 두개 동시에 =>visited, time배열  [빨간구슬, 파란구슬] 둘다 고려해야함 => 4차원 배열로 선언   

public class BJ_13460_구슬탈출2_윤호운 {
	static int n,m;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	
	
	public static int solve(Index red,Index blue,char[][] map) {
		
		//빨간 구슬 큐
		Queue<Index> q = new LinkedList<Index>();
		//파란 구슬 큐
		Queue<Index> b_q = new LinkedList<Index>();
		
		// +) 어차피 동시에 움직이니까 따로 안만들고 Index 클래스에 red 인덱스, blue 인덱스 둘다 변수로 놓고 큐하나만 사용해도됨

		//방문 했는지 안했는지
		boolean[][][][] rbvisited = new boolean[n][m][n][m];
		// 이동 횟수 저장
		int[][][][] rbtime = new int[n][m][n][m];
		
		//처음 빨간구슬, 파란구슬 위치 visited true로
		rbvisited[red.i][red.j][blue.i][blue.j]=true;
		
		// 두 구슬 위치를 각 큐에 삽입
		q.add(red);
		b_q.add(blue);
		
		//나중에 빨간구슬 성공했을때 while 문 탈출할 변수
		boolean chk=false;
		
		while(!q.isEmpty()) {
			Index now = q.poll();
			Index bnow = b_q.poll();
	
			//만약 현재 시간이 10 초과면 실패.
			if(rbtime[now.i][now.j][bnow.i][bnow.j]>10) {
				return -1;
			}

			//상,하,좌,우 탐색
			for(int k=0;k<4;k++) {
				int t_i=now.i;
				int t_j=now.j;
				int bt_i=bnow.i;
				int bt_j=bnow.j;
				chk=false;
				
				// blue랑 red 랑 같은 위치에 있을떄 처리해주기 위한 변수들
				int rcnt=0;
				int bcnt=0;
				
				//red 쭈우우ㅜㅇㄱ 이동
				while(true) {
					if(t_i+di[k]<0||t_j+dj[k]<0||t_i+di[k]>=n||t_j+dj[k]>=m||map[t_i+di[k]][t_j+dj[k]]=='#')
						break;
					t_i+=di[k];
					t_j+=dj[k];
					rcnt++;
					// 만약 red가 가다가 hole만나면 chk 변수를 참으로
					if(map[t_i][t_j]=='O') {
						chk=true;
					}
						
				}
				// blue 쭈우우우ㅜ웅ㄱ 이동
				boolean chk2 =false;
				while(true) {
					if(bt_i+di[k]<0||bt_j+dj[k]<0||bt_i+di[k]>=n||bt_j+dj[k]>=m||map[bt_i+di[k]][bt_j+dj[k]]=='#')
						break;
					bt_i+=di[k];
					bt_j+=dj[k];
					bcnt++;
					// 만약 blue가 가다가 hole 만나면 두가지 경우 => 1) red랑 동시에 탈출한 경우 2) blue만 탈출한 경우
					// 둘다 실패기 때문에 그냥 break 하고 continue로 다른 방향 탐색
					// => 바로 fail 처리 해버리면 안됨 -> red만 탈출할 수 있는 다른 방법이 있을수있기 때문
					if(map[bt_i][bt_j]=='O') {
						chk2=true;
						break;
					}
				}
				if(chk2)
					continue;
				
				
				
				// red와 blue 가 똑같은 위치에 있을떄(벽에 붙어있을떄) 처리 => 같은 위치에 있다는건 같은 줄에 있다는 뜻 => 이동횟수만 고려하면 된다 
				if(bt_i==t_i && bt_j==t_j) {
					//만약 blue가 더 많이 이동했으면 red가 벽에 붙어있고 그 뒤에 blue가 있다는 뜻 => blue를 이전값으로 이동
					if(rcnt<bcnt) {
						bt_i-=di[k];
						bt_j-=dj[k];
					}
					else if(rcnt>bcnt) {
						t_i-=di[k];
						t_j-=dj[k];
					}	
				}
				
				// chk true면 성공 !
				if(chk) {
					//이동횟수 10 이하 제한 검사하고 정답 리턴
					int time= rbtime[now.i][now.j][bnow.i][bnow.j]+1;
					if(time>10)
						return -1;
					else 
						return time;
				}

				//방문하지 않았으면 각 red, blue 위치 큐에 삽입하고, 이동횟수+1 , visited=true 로
				if(!rbvisited[t_i][t_j][bt_i][bt_j]) {
					    q.add(new Index(t_i,t_j));
						rbtime[t_i][t_j][bt_i][bt_j]=rbtime[now.i][now.j][bnow.i][bnow.j]+1; 
						b_q.add(new Index(bt_i,bt_j));
						rbvisited[t_i][t_j][bt_i][bt_j]=true;
					}

			}
		}
		
		return -1;

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    n = Integer.parseInt(st.nextToken());
	    m = Integer.parseInt(st.nextToken());
	    
	    char[][] map = new char[n][m];
	     for(int i=0;i<n;i++) {
	    	 map[i]=br.readLine().toCharArray();
	     }
	    
	     //blue, red 위치 찾기
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
	    	}
	    }

	  
	    System.out.println(solve(red,blue,map));
	}
}
