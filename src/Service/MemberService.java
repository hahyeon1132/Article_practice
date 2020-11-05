package Service;

import Dto.Member;
import Dao.MemberDao;
import Container.Container;

public class MemberService {

	
	private MemberDao memberDao;

	public MemberService() {
		memberDao = Container.memberDao;
	}

	public static void memberjoin(String memberid, String memberpw, String name) {
		MemberDao.memberjoin(memberid, memberpw, name);
	}

	public boolean checkableId(String memberid) {
		return memberDao.checkableId(memberid);
	}

	public static Member checkloginid(String loginid) {
		return MemberDao.checkloginid(loginid);
	
	}

	public static Member memberwhoami() {
		return MemberDao.memberwhoami();
	}

	public static Member memberlogout() {
		return MemberDao.memberlogout();
	}

	public static String FindWriter(int loginId) {
		return MemberDao.FindWriter(loginId);
	}

}
