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
		
		 //�湮�� ����ŭ 
			try {
				while(true) {
				rnd =  new Random().nextInt()* GameMainFrame.VISITOR;
				 icon = new ImageIcon(rnd+"m.PNG");				
			
				for(int i=0; i<10; i++) {
				Thread.sleep(10000); //10��
				count ++; //������ 10�� ���� ī��Ʈ 10 ����
				}
				
			 
				if(Timer.msg.equals("TIME OVER!")){
					break;
					}
				}
			} catch (InterruptedException e) {
				
					e.printStackTrace();
			}
		}
		
		
		
		//�湮�ڴ� 10�ʵ��� ��ٸ���.
		//10�ʰ� �� �����ų� �κ��� ������ �� ���� ������ �ٽ� ���ư���.
		
	}
	
	//�κ��� �Ѱ� �� ��(�ϼ�)
	//������ Ʋ���� �� �ٽ� ����


