package JaDgaja;


import Controller.Controller;
import java.util.Scanner;
import Container.Container;
import Controller.ArticleController;
import Controller.MemberController;

public class App {
	Scanner sc = Container.scanner;
	private MemberController MemberController;
	private ArticleController articleController ;
	
	
	public App() {
		MemberController = new MemberController();
		articleController = new ArticleController();
		
	}
	public void run() {
		while(true) {
		System.out.printf("명령어 : \n");
		String command = sc.nextLine();
		if(command.equals("system exit")) {
			break;
		}
		
		getControllerByCommand(command);
		
		}
		
	}
	
	
	
	
	
	private Controller getControllerByCommand(String command) {
		if(command.startsWith("member ")) {
			MemberController.memberController(command);
		}else if(command.startsWith("article ")) {
			articleController.articleController(command);
		}
		return null;
	}
	
	

}
