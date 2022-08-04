import java.io.*;
import java.util.*;


public class 두개의문자열_1959 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    int num=Integer.parseInt(br.readLine());
	    StringBuffer sb=new StringBuffer();
	   
	    
	    for(int i=1;i<=num;i++) {
	    	StringTokenizer st=new StringTokenizer(br.readLine());
	    	int n= Integer.parseInt(st.nextToken());
	    	int m= Integer.parseInt(st.nextToken());
	    	
	    	int[] arr1=new int[n];
	    	int[] arr2=new int[m];
	    	
	    	st=new StringTokenizer(br.readLine());
	    	for(int k=0;k<n;k++) {
	    		arr1[k]=Integer.parseInt(st.nextToken());
	    	}
	    	st=new StringTokenizer(br.readLine());
	    	for(int k=0;k<m;k++) {
	    		arr2[k]=Integer.parseInt(st.nextToken());
	    	}
	    	
	    	//arr1이 더 짧
	    	if(arr1.length>arr2.length) {
	    		int[] temp;
	    		temp= arr1;
	    		arr1=arr2;
	    		arr2=temp;
	    	}
	    	
	    	
	    	int result=0;
	    	for(int k=0;k<arr2.length-arr1.length+1;k++) {
	    		int sum=0;
	    		for(int p=0;p<arr1.length;p++) {
	    			sum+=arr1[p]*arr2[p+k];
	    		}
	    		if(sum>result)
	    			result=sum;
	    	}
	    	
	    	sb.append("#"+i+" "+result+"\n");

	    	
	    	
	    }
	    
	    System.out.println(sb);
	    

	}

}
