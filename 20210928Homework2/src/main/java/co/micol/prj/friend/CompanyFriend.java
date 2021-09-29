package co.micol.prj.friend;

public class CompanyFriend extends Friend {

	public CompanyFriend(String name, String tel, String address) {
		super(name, tel, address);
	}
	@Override
	public String friendPrint() {
//		System.out.println("이름 : " + name);
//		System.out.println("전화번호 : " + tel);
//		System.out.println("주소 : " + address);
//		System.out.println("구분 : 직장 동료");
		
		return "이름 : " + this.getName() + ", 전화번호 : " + this.getTel() + ", 주소 : " + this.getAddress() +", 구분 : 직장 동료";
	}

}
