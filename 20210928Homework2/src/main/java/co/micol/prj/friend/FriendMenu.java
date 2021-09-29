package co.micol.prj.friend;

import java.util.Scanner;

public class FriendMenu {
	private Scanner sc = new Scanner(System.in);
	private Friend[] friends = new Friend[100];

	private void mainMenu() {
		System.out.println("=================");
		System.out.println("== 1. 입력 하기 ===");
		System.out.println("== 2. 수정 하기 ===");
		System.out.println("== 3. 조회 하기 ===");
		System.out.println("== 4. 종료 하기 ===");
		System.out.println("=================");
		System.out.print("원하는 작업 번호를 입력하세요 : ");
	}

	private void firstMenu() {
		Friend fri = null;
		System.out.println("=========================");
		System.out.println("==여기는 입력하는 화면입니다.===");
		System.out.println("1.학교친구 | 2. 직장동료\n추가할 유형을 선택하여 주십시오: ");
		int selectType = sc.nextInt();
		sc.nextLine();
		String name = readStr("이름을 입력해주세요 : ");
		String tel = readStr("전화번호를 입력해주세요 : ");
		String address = readStr("주소를 입력해주세요 :");

		if (selectType == 1) {
			fri = new SchoolFriend(name, tel, address);
		} else if (selectType == 2) {
			fri = new CompanyFriend(name, tel, address);
		} else {
			System.out.println("잘못된 입력입니다.");
		}
		
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] == null) {
				friends[i] = fri;
				break;
			}
		}
		System.out.println("추가가 완료되었습니다.");
		System.out.println("=========================");
		System.out.println("==메인메뉴는 아무키나 누르세요.==");
		System.out.println("=========================");
		sc.nextLine();
	}

	private void secondMenu() {
		System.out.println("=========================");
		System.out.println("==여기는 수정하는 화면입니다.===");
		System.out.println("        [친구목록]");
		for(int i = 0; i < friends.length; i++) {
			if(friends[i] != null) {
				System.out.println("[" + i + "]" + friends[i].friendPrint());
			}
		} // for end
		System.out.print("수정할 친구의 번호를 입력하세요 : ");
		int selectNum = sc.nextInt();
		sc.nextLine();

		if (friends[selectNum] != null) {
			String tel = readStr("새로운 전화번호를 입력하세요 : ");
			String address = readStr("새로운 주소를 입력하세요 : ");
			if(!tel.equals("")) {
				friends[selectNum].setTel(tel);
			}
			
			if(!address.equals("")) {
				friends[selectNum].setAddress(address);
			}
		} else {
			System.out.println("잘못된 입력입니다.");
		}
		
		System.out.println("수정 완료.");
		System.out.println("=========================");
		System.out.println("==메인메뉴는 아무키나 누르세요.==");
		System.out.println("=========================");
		sc.nextLine();
	}

	private void thirdMenu() {
		System.out.println("=========================");
		System.out.println("==여기는 조회하는 화면입니다.===");
		
		System.out.println("1. 전체조회 | 2. 직접조회\n조회할 유형을 선택하여 주십시오: ");
		int selectType = sc.nextInt();
		sc.nextLine();
		
		if(selectType == 1) {
			for(int i = 0; i < friends.length; i++) {
				if(friends[i] != null) {
					System.out.println("[" + i + "]" + friends[i].friendPrint());
				}
			} // for end
		} else if(selectType == 2) {
			String name = readStr("조회할 이름을 입력해주세요 : ");
			for(int i = 0; i < friends.length; i++) {
				if(friends[i] != null) {
					if(friends[i].getName().equals(name)) {
						System.out.println(friends[i].friendPrint());
						break;
					}
				} else {
					System.out.println(name + " 이름을 가진 친구가 등록되어 있지 않습니다.");
					break;
				}
			} // for end
		} else {
			System.out.println("잘못된 입력입니다.");
		} //if end
		System.out.println("=========================");
		System.out.println("==메인메뉴는 아무키나 누르세요.==");
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
		friends[0] = new SchoolFriend("홍길동", "123-456", "대구광역시");
		friends[1] = new CompanyFriend("김영희", "555-987", "부산광역시");
		friendsMenu();
		sc.close();
	}

	public String readStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
}
