package ps.math;

import java.math.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시험감독
 * https://www.acmicpc.net/problem/13458
 * @author Howoon
 *
 */
public class 시험감독_13458 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    int n=Integer.parseInt(br.readLine());
	    int[] arr = new int[n];
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for(int i=0;i<n;i++) {
	    	arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    int b = Integer.parseInt(st.nextToken());
	    int c = Integer.parseInt(st.nextToken());
	    
	    long sum=0;
	    for(int i=0;i<n;i++) {
	    	
	    	arr[i]=arr[i]-b;
	    	sum++;
	    
	    	if(arr[i]<=0)
	    		continue;

	    	sum=sum+arr[i]/c;
	    	if(arr[i]%c>0)
	    		sum++;
	    	
	    }
	    
	    System.out.println(sum);
	    
	    
	    
	}

}
