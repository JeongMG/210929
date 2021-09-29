package co.micol.prj.lotto;
import java.util.Scanner;

public class Lotto {
	Scanner sc = new Scanner(System.in);
	public void LottoNum() {
		int lottoNum[] = new int[6];
		int setNum = 0;
		for (int i = 0; i < lottoNum.length; i++) {
			lottoNum[i] = (int)(Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (lottoNum[i] == lottoNum[j]) {
					i--;
					break;
				}
			}
		} // for�� ��
		for (int i = 0; i < lottoNum.length; i++) {
			for (int j = 0; j < i; j++) {
				if (lottoNum[j] > lottoNum[i]) {
					setNum = lottoNum[i];
					lottoNum[i] = lottoNum[j];
					lottoNum[j] = setNum;
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			System.out.print(lottoNum[i] + " ");
		}
		System.out.println();
	}

	public void LottoGame() {
		int money = PayMoney();
		int tryNum = money / 1000;
		int change = money % 1000;
		if (money >= 1000) {
			for (int i = 0; i < tryNum; i++) {
				if (i % 5 == 0) {
					System.out.println("==================");
				}
				LottoNum();
			}
		} else {
			System.out.println("���� �����մϴ�.");
		}
		
		if(money >= 1000 && change > 0) {
			System.out.println("\n�Ž������� " + change + "�� �Դϴ�.");
		}
	}
	
	public int PayMoney() {
		System.out.print("�ζǸ� ������ �ݾ��� �Է����ּ���(1���� : 1000��) : ");
		int money = sc.nextInt();
		sc.nextLine();
		return money;
	}
}
