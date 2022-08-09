import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2563_색종이_윤호운 {
public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//색종이 놓은 자리 표시할 배열 (true)
		boolean[][] paper = new boolean[100][100];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); //x조ㅏ표
			int y = Integer.parseInt(st.nextToken()); //y좌표
			
			//색종이(10*10) 채우기
			for(int k=x;k<x+10;k++) {
				for(int p=y;p<y+10;p++ ) {
					paper[k][p]=true;
				}
			}
		}
		int result=0;
		//넓이 구하기
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++ ) {
				if(paper[i][j])
					result++;
			}
		}
	    System.out.println(result);
	}
}
