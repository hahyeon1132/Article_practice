package Dao;

import java.util.ArrayList;
import java.util.List;
import Dto.Article;

public class ArticleDao {
	List<Article> articles;
	int lastid;
	public ArticleDao() {
		lastid = 0;
		articles = new ArrayList<>();
		for (int i = 0 ; i < 5 ; i++) {
			add("aaa"+i,"aaa"+i,1);
		}
		for (int i = 5; i < 10 ; i++) {
			add("bbb"+i,"bbb"+i,2);
		}
	}

	public void add(String title, String body, int loginId) {
		Article article = new Article();
		
		article.id = lastid + 1;
		article.title = title;
		article.body = body;
		article.LoginId = loginId;
		
		articles.add(article);
		lastid = article.id;
		
	}

	public List<Article> list() {
		return articles;
	}

}
