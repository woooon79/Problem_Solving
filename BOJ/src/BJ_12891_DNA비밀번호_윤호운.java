
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A C G T

public class BJ_12891_DNA비밀번호_윤호운 {
	
	// 조건검사: 내가 가지고있는 문자가 조건 개수 이상이면  true 리턴
	public static boolean solve(int[] todo, int[] mine) {
		if(mine['A']>=todo['A']&&mine['C']>=todo['C']&&mine['G']>=todo['G']&&mine['T']>=todo['T'])
			return true;
		return false;
	}
	
public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    //A=65

	    //입력
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int s = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
	    int p = Integer.parseInt(st.nextToken()); // 부분 문자열 길이 
	    
	    //'T' 아스키코드가 100보다 작으므로  각 문자의 개수 넣을  길이 100짜리 int형 배열생성
	    int[] mine = new int[100]; //내꺼 dna 문자 개수 배열
	    int[] todo = new int[100]; // 넣어야되는 dna 문자 개수 배열
	    
	    char[] dna = br.readLine().toCharArray();
	    st = new StringTokenizer(br.readLine());
	    
	    // 조건 개수 삽입
	    todo['A']=Integer.parseInt(st.nextToken());
	    todo['C']=Integer.parseInt(st.nextToken());
	    todo['G']=Integer.parseInt(st.nextToken());
	    todo['T']=Integer.parseInt(st.nextToken());
	    
	    //정답 변수
	    int ans=0;
	    
	    for(int i=0;i<s-p+1;i++) {
	    	//처음 부분문자열 만들기
	    	if(i==0) {
	    	    for(int k=0;k<p;k++) {
	    	    	mine[dna[k]]++;
	    	    }
	    	}
	    	// 처음에 부분문자열 만든거가지고 앞 뒤 문자 개수만 조정 (슬라이딩 윈도우)
	    	else {
		    	mine[dna[i-1]]--;
		    	mine[dna[i+p-1]]++;
	    	}
	    	//조건검사 -> true면 ans+1
	    	if(solve(todo,mine))
	    		ans++;
	    }
	    
	    System.out.println(ans);
	    
	}
}
