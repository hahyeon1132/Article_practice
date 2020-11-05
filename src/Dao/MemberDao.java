package Dao;

import java.util.ArrayList;
import java.util.List;

import Dto.Member;
import Session.Session;
import Container.Container;

public class MemberDao {
	static List<Member> members;
	static int lastid;
	private static Session session;
	
	public MemberDao() {
		members = new ArrayList<>();
		lastid = 0;
		session = Container.session;
		//임시 회
		memberjoin("aaa","aaa","aaa");
		memberjoin("bbb","bbb","bbb");
	}

	public static void memberjoin(String memberid, String memberpw, String name) {
		Member member = new Member();
		
		member.Id = lastid+1;
		member.LoginId = memberid;
		member.LoginPw = memberpw;
		member.name = name;
		members.add(member);
		lastid = member.Id;
		
		
	}

	public boolean checkableId(String memberid) {
		for(Member member : members) {
			if (member.LoginId.equals(memberid)) {
				return false;
			}
		}return true;
	}

	public static Member checkloginid(String loginid) {
		for (Member member : members) {
			if(member.LoginId.equals(loginid)) {
				return member;
			}
		}return null;
	}

	public static Member memberwhoami() {
		for (Member member : members) {
			if (member.Id == session.LoginId);{
				
				return member;
			}
		}return null;
	}

	public static Member memberlogout() {
		for(Member member : members) {
			if(member.Id == session.LoginId) {
				session.LoginId = 0;
				return member;
				
			}
		}return null;
	}

	public static String FindWriter(int loginId) {
		for(Member member : members) {
			if(member.Id == loginId) {
				return member.name;
			}
		}return null;
	}

}
