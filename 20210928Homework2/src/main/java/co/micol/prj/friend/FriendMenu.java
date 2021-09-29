package co.micol.prj.friend;

import java.util.Scanner;

public class FriendMenu {
	private Scanner sc = new Scanner(System.in);
	private Friend[] friends = new Friend[100];

	private void mainMenu() {
		System.out.println("=================");
		System.out.println("== 1. �Է� �ϱ� ===");
		System.out.println("== 2. ���� �ϱ� ===");
		System.out.println("== 3. ��ȸ �ϱ� ===");
		System.out.println("== 4. ���� �ϱ� ===");
		System.out.println("=================");
		System.out.print("���ϴ� �۾� ��ȣ�� �Է��ϼ��� : ");
	}

	private void firstMenu() {
		Friend fri = null;
		System.out.println("=========================");
		System.out.println("==����� �Է��ϴ� ȭ���Դϴ�.===");
		System.out.println("1.�б�ģ�� | 2. ���嵿��\n�߰��� ������ �����Ͽ� �ֽʽÿ�: ");
		int selectType = sc.nextInt();
		sc.nextLine();
		String name = readStr("�̸��� �Է����ּ��� : ");
		String tel = readStr("��ȭ��ȣ�� �Է����ּ��� : ");
		String address = readStr("�ּҸ� �Է����ּ��� :");

		if (selectType == 1) {
			fri = new SchoolFriend(name, tel, address);
		} else if (selectType == 2) {
			fri = new CompanyFriend(name, tel, address);
		} else {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
		
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] == null) {
				friends[i] = fri;
				break;
			}
		}
		System.out.println("�߰��� �Ϸ�Ǿ����ϴ�.");
		System.out.println("=========================");
		System.out.println("==���θ޴��� �ƹ�Ű�� ��������.==");
		System.out.println("=========================");
		sc.nextLine();
	}

	private void secondMenu() {
		System.out.println("=========================");
		System.out.println("==����� �����ϴ� ȭ���Դϴ�.===");
		System.out.println("        [ģ�����]");
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] != null) {
				System.out.println("[" + i + "]" + friends[i].friendPrint());
			}
		} // for end
		System.out.print("������ ģ���� ��ȣ�� �Է��ϼ��� : ");
		int selectNum = sc.nextInt();
		sc.nextLine();

		if (friends[selectNum] != null) {
			String tel = readStr("���ο� ��ȭ��ȣ�� �Է��ϼ��� : ");
			String address = readStr("���ο� �ּҸ� �Է��ϼ��� : ");
			if(!tel.equals("")) {
				friends[selectNum].setTel(tel);
			}
			
			if(!address.equals("")) {
				friends[selectNum].setAddress(address);
			}
		} else {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
		
		System.out.println("���� �Ϸ�.");
		System.out.println("=========================");
		System.out.println("==���θ޴��� �ƹ�Ű�� ��������.==");
		System.out.println("=========================");
		sc.nextLine();
	}

	private void thirdMenu() {
		System.out.println("=========================");
		System.out.println("==����� ��ȸ�ϴ� ȭ���Դϴ�.===");
		
		System.out.println("1. ��ü��ȸ | 2. ������ȸ\n��ȸ�� ������ �����Ͽ� �ֽʽÿ�: ");
		int selectType = sc.nextInt();
		sc.nextLine();
		
		if(selectType == 1) {
			for(int i = 0; i < friends.length; i++) {
				if(friends[i] != null) {
					System.out.println("[" + i + "]" + friends[i].friendPrint());
				}
			} // for end
		} else if(selectType == 2) {
			String name = readStr("��ȸ�� �̸��� �Է����ּ��� : ");
			for(int i = 0; i < friends.length; i++) {
				if(friends[i] != null) {
					if(friends[i].getName().equals(name)) {
						System.out.println(friends[i].friendPrint());
						break;
					}
				} else {
					System.out.println(name + " �̸��� ���� ģ���� ��ϵǾ� ���� �ʽ��ϴ�.");
					break;
				}
			} // for end
		} else {
			System.out.println("�߸��� �Է��Դϴ�.");
		} //if end
		System.out.println("=========================");
		System.out.println("==���θ޴��� �ƹ�Ű�� ��������.==");
		System.out.println("=========================");
		sc.nextLine();
	}

	private void endMenu() {
		System.out.println("====Good Bye====");
	}

	private void friendsMenu() {
		boolean b = false;

		do {
			mainMenu();
			int key = sc.nextInt();
			sc.nextLine();
			switch (key) {
			case 1:
				firstMenu();
				break;
			case 2:
				secondMenu();
				break;
			case 3:
				thirdMenu();
				break;
			case 4:
				endMenu();
				b = true;
				break;
			}
		} while (!b);
	}

	public void run() {
		friends[0] = new SchoolFriend("ȫ�浿", "123-456", "�뱸������");
		friends[1] = new CompanyFriend("�迵��", "555-987", "�λ걤����");
		friendsMenu();
		sc.close();
	}

	public String readStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
}
