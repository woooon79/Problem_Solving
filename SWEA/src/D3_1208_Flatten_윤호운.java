package ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class D3_1208_Flatten_윤호운 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	    StringBuffer sb = new StringBuffer();
	    
	    for(int t=1;t<11;t++) {
	    	int ans=0;
	    	//while 문 편의를 위해 1더해줌
	    	int dump=Integer.parseInt(br.readLine())+1;
	    	//높이 저장
	    	int[] arr = new int[101];
	    	//최소 높이
	    	int min=101;
	    	//최대 높이
	    	int max=0;
	    	
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	//각 높이별 개수를 저장한 배열 arr 을 구하고, 높이의 최대 최소값을 구한다 
	    	for(int i=0;i<100;i++) {
	    		int h=Integer.parseInt(st.nextToken());
	    		arr[h]++;
	    		if(h<min)
	    			min=h;
	    		if(h>max)
	    			max=h;
	    	}
	    	
	    	// 최대최소값차이가 1이하면 평탄화 => 다음 테케로 넘어감
	    	if(max-min<=1) {
	    		sb.append("#"+t+" "+(max-min)+"\n");
	    		continue;
	    	}

	    			
	    	while(true) {
	    		//만약 최대-최소 1이하면 답 구하고 break
	    		if(max-min<=1) {
	    			ans = max-min;
	    			break;
	    		}
	    		//dump 횟 수 채우면 답 구하고 break
	    		if(dump==0) {
	    			ans= max-min;
	    			break;
	    		}
	    		
	    		//만약 현재 최대 높이값의 개수가 0이면 다음 최대길이 구하기
	    		if(arr[max]==0) {
	    			for(int i=max;i>=1;i--) {
	    				if(arr[i]!=0) {
	    					max=i;
	    					break;
	    				}
	    					
	    			}
	    		}
	    		//만약 현재 최소 높이값의 개수가 0이면 다음 최소길이 구하기
	    		if(arr[min]==0) {
	    			for(int i=min;i<101;i++) {
	    				if(arr[i]!=0) {
	    					min=i;
	    					break;
	    				}
	    					
	    			}
	    		}
	    		
	    		//최대 높이값개수 1게 빼주고 높이가 1 줄어들었으니까, max-1 길이 개수 1개 증가
	    		arr[max]--;
	    		arr[max-1]++;
	    		//최소 높이값개수 1게 빼주고 높이가 1 증가햇으니까, min+1 길이 개수 1개 증가
	    		arr[min]--;
	    		arr[min+1]++;
	    		
	    		//dump 횟수 하나 감소
	    		dump--;

	    	}

	    	sb.append("#"+t+" "+ans+"\n");
	    }
	    System.out.println(sb);
	}

}
