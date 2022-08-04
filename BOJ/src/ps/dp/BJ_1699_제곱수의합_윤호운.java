package ps.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_1699_제곱수의합_윤호운 {
	public static void main(String[] args)throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		 int num=Integer.parseInt(br.readLine());
		 int result;

		 //d[i]: d까지 제곱수의 합
		 int[] d=new int[num+1];
		 //dp 처음값
		 d[1]=1;
		 
		 //d[i] = 1+d[i-j^2]
		 for(int i=2;i<=num;i++) {
			 int sqrt =(int)(Math.pow(i,0.5));
			 int min=i;
			 for(int j=1;j<=sqrt;j++) {
			      int tmp=(int)Math.pow(j, 2);
			      if(min>d[i-tmp])
			          min=d[i-tmp];
			 }
			 //최소값 대입
			 d[i]=min+1;
		 }
		 
		 System.out.println();
		 System.out.print(d[num]);
		 
	}
}

