package randomitem;

import java.util.Random;

import timer.Timer;

public class ItemThread {

	String word[] = { "팥", "크림", "반죽", "고구마" };
	int rnd = 0;
	String quiz = "";
	int count = 0;

	//JLabel qRnd를 return 해서 호출하는걸로 바꾸기
	public void setQuiz(String quiz) {
		while (true) {
			try {
				rnd = new Random().nextInt(3);
				quiz = word[rnd]; // 문자열에 랜덤 저장
				count++; // 1증가
				Thread.sleep(2000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (count == 4 || Timer.msg.equals("TIME OVER!")) {
				break;
			}

		}
			
	}

	public String getQuiz() {
		return quiz;
	}


}
