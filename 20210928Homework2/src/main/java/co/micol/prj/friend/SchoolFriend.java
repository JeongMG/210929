package co.micol.prj.friend;

public class SchoolFriend extends Friend {
	
	public SchoolFriend(String name, String tel, String address) {
		super(name, tel, address);
	}
	
	@Override
	public String friendPrint() {
//		System.out.println("�̸� : " + name);
//		System.out.println("��ȭ��ȣ : " + tel);
//		System.out.println("�ּ� : " + address);
//		System.out.println("���� : �б� ģ��");
		
		return "�̸� : " + this.getName() + ", ��ȭ��ȣ : " + this.getTel() + ", �ּ� : " + this.getAddress() +", ���� : �б� ģ��";
	}

}
