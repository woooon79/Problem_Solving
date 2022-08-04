package ps.data.structure;

/**
 * 트럭
 * https://www.acmicpc.net/problem/13335
 * 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

	//들어온시간:time
    //무게:weight
	class Truck{
		int time,weight;
		Truck(int w){
			weight=w;
		}
	}


public class 트럭_13335 {


	static BufferedReader br;
    static BufferedWriter bw;
    static Queue <Truck> q= new <Truck> LinkedList();
    static Queue <Truck> t_q= new <Truck> LinkedList();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		br =new BufferedReader(new InputStreamReader(System.in));
	    bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st=new StringTokenizer(br.readLine());
		int num=Integer.parseInt(st.nextToken());
		int w=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());

		 st=new StringTokenizer(br.readLine());

		 for(int i=0;i<num;i++) {
			 int weight=Integer.parseInt(st.nextToken());
			 q.offer(new Truck(weight));
		 }
		 
		 int time=0;
		 int total_w=0;
		 
		 while(true) {
	           //흐르는 시간 값
			   time++;
               
			   //다리에 트럭이 있을경우
			    if(!t_q.isEmpty()) {
			    	//흐른시간이 w값인경우
			    	if(time-t_q.peek().time==w) {
			    		//다리에서 트럭 뺀다
			    	   total_w=total_w-t_q.poll().weight;
	
			    	}
			    }
			    
			    //대기큐 및 다리 큐에 값이 없을경우
				 if(q.isEmpty()&&t_q.isEmpty())
					 break;
			    
				 //대기큐에 값이 있으면
			    if(!q.isEmpty()) {
			    	//대기큐에서 하나빼서
					 int truck_w=q.peek().weight;
					 //무게를 합한게 L이하인지,트럭개수가 w 이하인지 확인
				if(t_q.size()+1<=w&&total_w+truck_w<=L) {
					//맞으면 time값 바꿔주고 대기큐에서 뺀 후 다리 큐에 삽입
                    q.peek().time=time;
                     t_q.offer(q.poll());
                     total_w+=truck_w;

			     }
			    }


		 }
		 
		 System.out.println(time);
		 
		
	}
}