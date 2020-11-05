package Service;

import java.util.List;

import Dao.ArticleDao;
import Dto.Article;
import Container.Container;

public class ArticleService {

	private ArticleDao ArticleDao;
	
	public ArticleService(){
		ArticleDao = Container.articleDao;
	}

	public void add(String title, String body, int loginId) {
		ArticleDao.add(title,body,loginId);
		
	}

	public List<Article> list() {
		return ArticleDao.list();
	}

}
