package randomitem;

import java.util.Random;

import timer.Timer;

public class ItemThread {

	String word[] = { "��", "ũ��", "����", "����" };
	int rnd = 0;
	String quiz = "";
	int count = 0;

	//JLabel qRnd�� return �ؼ� ȣ���ϴ°ɷ� �ٲٱ�
	public void setQuiz(String quiz) {
		while (true) {
			try {
				rnd = new Random().nextInt(3);
				quiz = word[rnd]; // ���ڿ��� ���� ����
				count++; // 1����
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
