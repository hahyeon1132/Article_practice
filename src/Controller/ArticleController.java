package Controller;

import java.util.List;
import java.util.Scanner;
import Service.ArticleService;
import Service.MemberService;
import Session.Session;
import Container.Container;
import Dto.Article;

public class ArticleController  {

	private ArticleService ArticleService;
	private Scanner sc;
	private Session session;
	
	public ArticleController() {
		ArticleService = Container.articleService;
		sc = Container.scanner;
		session = Container.session;
	}

	public void articleController(String command) {
		if(command.equals("article add")) {
			add();
		}else if(command.equals("article list")) {
			list();
		}
		
	}

	private void list() {
		List<Article> articles = ArticleService.list();
		if(articles == null) {
			System.out.printf("작성된 개시글이 없습니다.\n");
			return;
		}
		System.out.printf("== 개시글 리스트 ==\n");
		System.out.printf("번호 / 제목 / 작성 \n");
		for(Article article : articles) {
			String Writer = MemberService.FindWriter(article.LoginId);
			System.out.printf("%d / %s / %s\n",article.id,article.title,Writer);
		}
		
	}

	private void add() {
		if (session.LoginId == 0) {
			System.out.printf("로그인 후 이용해주세요. \n");
			return;
		}
		System.out.printf("제목 : \n");
		String title = sc.nextLine().trim();
		if (title.length() == 0) {
			System.out.printf("제목을 입력해주세요.\n");
			return;
		}
		System.out.printf("내용 : \n");
		String body = sc.nextLine().trim();		
		
		ArticleService.add(title,body,session.LoginId);
		
		System.out.printf("개시글이 등록되었습니다.\n");
	}

	

	

}
