package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
1
3 7
***....
*-..#**
#<.****
7
SURSSSS
 * 
 */

/**
문자	의미
.	평지(전차가 들어갈 수 있다.)
*	벽돌로 만들어진 벽
#	강철로 만들어진 벽
-	물(전차는 들어갈 수 없다.)
^	위쪽을 바라보는 전차(아래는 평지이다.)
v	아래쪽을 바라보는 전차(아래는 평지이다.)
<	왼쪽을 바라보는 전차(아래는 평지이다.)
>	오른쪽을 바라보는 전차(아래는 평지이다.


문자	동작
U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
*/

public class D3_1873_상호의배틀필드_윤호운 {
	
	static String tank ="^v<>";
	static int h,w;

	public static String solve(char[][] map, int n_i,int n_j,char[] list) {
		char state = map[n_i][n_j];
		
		int s_i=n_i;
		int s_j=n_j;
		
		//처음 전차 있는 위치를 평지로 바꿔줌
		map[s_i][s_j]='.';
		
		for(int i=0;i<list.length;i++) {
			char order = list[i];

			if(order=='U') {
				state='^';
				if(n_i>0&&map[n_i-1][n_j]=='.') { //위가 평지라면		
					n_i--;
				}
				
			}
			else if(order=='D') {
				state='v';
				if(n_i<h-1&&map[n_i+1][n_j]=='.') { //아래가 평지라면
					n_i++;
				};
			}
			else if(order=='L') {
				state='<';
				if(n_j>0&&map[n_i][n_j-1]=='.') { //왼쪽이 평지라면
					n_j--;
				}
			}
			else if(order=='R') {
				state='>';
				if(n_j<w-1&&map[n_i][n_j+1]=='.') { //오른쪽이 평지라면
					n_j++;
				}
			}
			else { //포탄발사..
				if(state=='^') {
					for(int k=n_i-1;k>=0;k--) {
						if(map[k][n_j]=='.'||map[k][n_j]=='-') {
							continue;
						}
						else if(map[k][n_j]=='*') {
							map[k][n_j]='.';
							break;
						}
						else 
							break;
					}
				}
				
				else if(state=='v') {
					for(int k=n_i+1;k<h;k++) {
						//평지거나 물일때 무시
						if(map[k][n_j]=='.'||map[k][n_j]=='-')
							continue;
						//벽돌 벽 부심
						else if(map[k][n_j]=='*') {
							map[k][n_j]='.';
							break;
						}
						//나머지면 나가기
						else 
							break;
					}
				}
				else if(state=='<') {
					for(int k=n_j-1;k>=0;k--) {
						if(map[n_i][k]=='.'||map[n_i][k]=='-')
							continue;
						else if(map[n_i][k]=='*') {
							map[n_i][k]='.';
							break;
						}
						else 
							break;
					}
				}
				else {
					for(int k=n_j+1;k<w;k++) {
						if(map[n_i][k]=='.'||map[n_i][k]=='-')
							continue;
						else if(map[n_i][k]=='*') {
							map[n_i][k]='.';
							break;
						}
						else 
							break;
					}
				}
			}
			

		}

		//마지막 전차 상태 map에 대입
		map[n_i][n_j]=state;

		String new_map ="";
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				new_map+=map[i][j];
			}
			new_map+="\n";
		}
		
		return new_map;
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    int tc = Integer.parseInt(br.readLine());
	    String ans ="";
	   
	    
	    for(int t=1;t<=tc;t++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	h = Integer.parseInt(st.nextToken());
	    	w = Integer.parseInt(st.nextToken());
	    	
	    	char[][] map = new char[h][w];
	    	
	    	
	    	for(int i=0;i<h;i++) {
	    		map[i]=br.readLine().toCharArray();
	    	}
	    	
	    	int num = Integer.parseInt(br.readLine());
	    	char[] order = br.readLine().toCharArray();
	    	
	    	int n_i=0;
	    	int n_j=0;
	    	boolean chk=false;
	    	for(int i=0;i<h;i++) {
	    		for(int j =0;j<w;j++) {
	    			if(tank.contains(Character.toString(map[i][j]))) {
	    				ans=solve(map,i,j,order);
	    				chk=true;
	    				break;
	    			}
	    		}
	    		if(chk)
	    			break;
	    	}
	    	
	    	sb.append("#"+t+" "+ans);
	    }
	    System.out.println(sb);
	}
}
