/*
  DAO란 ? 
  - Data Access Object를 의미하는 어플리케이션의 설계 분야 용어
  - Data Access란 데이터베이스와의 Create(=insert) Read(=select) UD작업을 전담한다는 의미  
 */
package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBManager;

public class NoticeDAO {
	DBManager dbManager=new DBManager();
	
	//재사용성 고려하지 않은 swing 만의 로직 작성 
	//insert 는 글 한건~~  하나의 VO
	public int regist(Notice notice) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0; //글 등록 후 그 결과값 보관
		
		con=dbManager.getConnection();
		
		String sql="insert into notice(author, title, content) values(?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, notice.getAuthor()); //작성자
			pstmt.setString(2, notice.getTitle()); //제목
			pstmt.setString(3, notice.getContent()); //내용
			
			result=pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt);
		}	
		return result;
	}	
	
	
	//게시물 1건 가져오기(상세보기)
	public ResultSet select(int notice_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from notice where notice_id=?";
		
		con=dbManager.getConnection(); //접속객체 얻기 
		try {
			pstmt=con.prepareStatement(sql); //쿼리준비
			pstmt.setInt(1, notice_id); //바인드 변수값 지정
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbManager.release(con, pstmt, rs);
		}
		return rs;
	}
}























