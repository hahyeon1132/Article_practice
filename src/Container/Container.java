package Container;

import java.util.Scanner;

import Dao.ArticleDao;
import Dao.MemberDao;
import Service.ArticleService;
import Service.MemberService;
import Session.Session;

public class Container {

	public static Scanner scanner;
	public static Session session;
	public static ArticleService articleService;
	public static MemberService memberService;
	public static MemberDao memberDao;
	public static ArticleDao articleDao;

	static {
		scanner = new Scanner(System.in);
		session = new Session();

		memberDao = new MemberDao();
		articleDao = new ArticleDao();

		articleService = new ArticleService();
		memberService = new MemberService();

	}
}
