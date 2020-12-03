package board.gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class BoardMain extends JFrame{
	//사용할 페이지 구성 
	Page[] pageList=new Page[Pages.values().length]; //enum에 등록된 페이지 만큼생성
	
	public BoardMain() {
		//페이지 생성 
		pageList[0] = new BoardList(this);
		pageList[1] = new BoardWrite(this);
		pageList[2] = new BoardContent(this);
		
		setLayout(new FlowLayout()); //프레임에 여러개의 컴포넌트가 부착되려면 플로우로~
		
		//페이지들 부착 
		for(Page page: pageList) {
			add(page);
		}
		
		setSize(900,700);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BoardMain();
	}

}
