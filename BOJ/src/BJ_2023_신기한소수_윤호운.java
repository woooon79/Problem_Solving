import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2023_신기한소수_윤호운 {
	public static int num;
	public static StringBuilder ans=new StringBuilder();
	// 소수 판별 메서드
	public static boolean isPrime(int num) {
		for(int i=2;i<=Math.sqrt(num);i++) {
				if(num%i==0)
					return false;
			}
		return true;
	}
	// num 길이의 소수를 찾으면 반환하는 재귀메서드
	// 매개변수를 String 타입으로 준 후 0-9 까지의 수를 뒤에 붙여가면서 소수인지아닌지 판별하고 num 길이가 되면 정답에 추가하고 리턴
	public static void solve(String s) {
		if(s.length()==num) {
			ans.append(s+"\n");
			return;
		}
		for(int i=0;i<=9;i++) {
			int temp=Integer.parseInt(s+i);
			if(isPrime(temp)) {
				solve(s+i);
			}
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    num = Integer.parseInt(br.readLine());
	    // 첫째자리 소수 찾는 for문
	    for(int i=2;i<=9;i++) {
	    	if(isPrime(i)) { // 소수면 그 수를 String타입으로 변환후 solve메서드의 매개변수로 solve 호출
	    		solve(String.valueOf(i));
	    	}
	    }
	    System.out.println(ans);
	}
}
