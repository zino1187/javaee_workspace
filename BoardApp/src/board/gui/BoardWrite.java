package board.gui;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BoardWrite extends Page{
	JTextField t_author;
	JTextField t_title;
	JTextArea area;
	JScrollPane scroll;
	JButton bt;
	
	public BoardWrite(BoardMain boardMain) {
		super(boardMain);
		//생성
		t_author = new JTextField();
		t_title = new JTextField();
		area = new JTextArea();
		scroll = new JScrollPane(area);
		bt = new JButton("등록");
		
		//스타일
		t_author.setPreferredSize(new Dimension((int)this.getPreferredSize().getWidth()-10, (int)this.getPreferredSize().getHeight()-10));
		t_title.setPreferredSize(new Dimension(boardMain.getWidth()-10, 25));
		scroll.setPreferredSize(new Dimension(boardMain.getWidth()-10, 600));
		
		//조립 
		add(t_author);
		add(t_title);
		add(scroll);
		add(bt);
	}
	
}






