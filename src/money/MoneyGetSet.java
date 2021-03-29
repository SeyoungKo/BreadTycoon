package money;

import util.Tycoon;

public class MoneyGetSet implements Runnable {

	static int MONEY = 1000; // 돈
	 static int TOTAL = 5000; // 총시간
	static long STARTTIME = (System.currentTimeMillis())/ 1000;
	static long FINISHTIME = (System.currentTimeMillis())/ 1000;
	static long RUNTIME = (FINISHTIME - STARTTIME);
	

	
	public static int getMONEY() {
		return MONEY;
	}

	public static void setMONEY(int money) {
		/*if(Tycoon.SCORE +=10) {
			money +=500;  //5초에 클릭하면 500원 얻기
		}else if(RUNTIME == 0 || RUNTIME == 1 || RUNTIME == 2 || RUNTIME == 3 ||
					RUNTIME == 4) {
			
			money -=50; //시간 중 잘못누르면 50원 뺏기
			
		}
		MONEY = money;
		
*/	
		MONEY = money;
	
	}

	@Override
	public void run() {
	

		
	}

	
}
