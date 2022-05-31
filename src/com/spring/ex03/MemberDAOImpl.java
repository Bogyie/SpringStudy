package com.spring.ex03;

public class MemberDAOImpl implements MemberDAO {
	boolean isAuth;

	public MemberDAOImpl(boolean isAuth) {
		this.isAuth = isAuth;
	}

	@Override
	public void listMembers() {
		System.out.println("listMembers  메서드 호출");
		if (isAuth){
			System.out.println("회원정보를 조회합니다.");
		} else {
			System.out.println("로그인이 필요합니다.");
		}
	}
}
