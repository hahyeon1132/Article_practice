package Controller;

import java.util.Scanner;
import Container.Container;
import Dto.Member;
import Service.MemberService;
import Session.Session;

public class MemberController  {

	private Scanner sc;
	private MemberService memberService;
	private Member Member;
	private Session session;

	public MemberController() {
		sc = Container.scanner;
		memberService = Container.memberService;
		Member = new Member();
		session = Container.session;

	}

	public void memberController(String command) {
		if (command.equals("member join")) {
			memberjoin(command);
		} else if (command.equals("member whoami")) {
			memberwhoami(command);
		} else if (command.equals("member login")) {
			memberlogin(command);
		}else if(command.equals("member logout")) {
			memberlogout();
		}

	}

	private void memberlogout() {
		if(session.LoginId == 0) {
			System.out.printf("로그인된 계정이 없습니다.\n");
			return;
		}
		Member member = MemberService.memberlogout();
		System.out.printf("%s님 계정 %s가 로그아웃 되었습니다\n",member.name,member.LoginId);
	}

	private void memberlogin(String command) {
		if (session.LoginId > 0) {
			System.out.printf("이미 로그인 되있습니다.\n");
			return;
		}
		System.out.printf("아이디 : \n");
		String loginid = sc.nextLine();
		Member Member = MemberService.checkloginid(loginid);
		if (Member == null) {
			System.out.printf("존재하지 않는 아이디입니다.\n");
			return;
		}
		System.out.printf("비밀번호 : \n");
		String loginpw = sc.nextLine();
		if (Member.LoginPw.equals(loginpw)) {
			session.LoginId = Member.Id;
			System.out.printf("%s님 환영합니다.\n", Member.name);
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
	}

	private void memberwhoami(String command) {
		Member member = MemberService.memberwhoami();

		if (member == null) {
			System.out.printf("로그아웃 상태입니다. 로그인 후 이용해주세요.\n");
		}else {
			System.out.printf("아이디 : %s\n",member.LoginId);
			System.out.printf("이름 : %s\n",member.name);
		}
	}

	private void memberjoin(String command) {

		System.out.printf("아이디 : \n");
		String memberid = sc.nextLine();

		if (false == memberService.checkableId(memberid)) {
			System.out.printf("이미 가입된 아이디입니다\n");
			return;
		}

		System.out.printf("비밀번호 : \n");
		String memberpw = sc.nextLine();
		System.out.printf("이름 : \n");
		String name = sc.nextLine();

		MemberService.memberjoin(memberid, memberpw, name);

		System.out.printf("회원가입이 완료 되었습니다 %s님 환영합니다.\n", name);

	}

	
	

}
