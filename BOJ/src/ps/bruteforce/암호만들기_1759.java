package ps.bruteforce;

import java.lang.*;
import java.io.*;
import java.util.*;
//
/**
 * https://www.acmicpc.net/problem/1759
 * @author Howoon
 *
 */


public class 암호만들기_1759{
     //암호만들기
     //L개의 서로다른 알파벳 소문자 (최소 한개 모음 & 최소 두개 자음)
     //오름차순
     // C개 문자들 중 L개


    static StringBuilder ans=new StringBuilder();

    public static void solve(String[] arr,int C,int L,StringBuilder sb,int start){
    	//ans에 L 길이만큼 문자가 생성되면 모음과 자음개수 구한 후 sb에 추가
        if(sb.length()==L){
            int count=0;
            for(int i=0;i<L;i++){
                char temp=sb.charAt(i);
                if(temp=='i'||temp=='a'||temp=='e'||temp=='o'||temp=='u'){
                count++;
                }

            }

            if(count>=1 && L-count>=2)
                ans.append(sb.toString()+"\n");
            
            return;
        }
        
        
        //문자별로 두가지 경우 고려(삽입/제외) =>  재귀 호출
        for(int i=start;i<C;i++){
            sb.append(arr[i]);
            solve(arr,C,L,sb,i+1);
            sb.deleteCharAt(sb.length()-1);
        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int L=Integer.parseInt(st.nextToken());
        int C=Integer.parseInt(st.nextToken());

       // C개 문자배열
        String[] arr=br.readLine().split(" ");

        Arrays.sort(arr);
        solve(arr,C,L,new StringBuilder(),0);
        System.out.println(ans);




    }  
}





