package visitor;

import java.util.Random;

import javax.swing.ImageIcon;

import gui.GameMainFrame;
import timer.Timer;

public class VisitorRandom implements Runnable{

	
	int rnd =0;
	int count =0;
	Timer t = new Timer();
	public static ImageIcon icon ;
	
	@Override
	public void run() {
		
		 //방문자 수만큼 
			try {
				while(true) {
				rnd =  new Random().nextInt()* GameMainFrame.VISITOR;
				 icon = new ImageIcon(rnd+"m.PNG");				
			
				for(int i=0; i<10; i++) {
				Thread.sleep(10000); //10초
				count ++; //쓰레드 10번 돌면 카운트 10 저장
				}
				
			 
				if(Timer.msg.equals("TIME OVER!")){
					break;
					}
				}
			} catch (InterruptedException e) {
				
					e.printStackTrace();
			}
		}
		
		
		
		//방문자는 10초동안 기다린다.
		//10초가 다 지나거나 인벤에 개수가 다 차면 랜덤이 다시 돌아간다.
		
	}
	
	//인벤에 한개 들어갈 때(완성)
	//순서를 틀렸을 때 다시 랜덤


