package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DBManager;

public class CommentsDAO {
	DBManager manager = new DBManager();
	
	//댓글 등록
	public int insert(Comments comments) {
		Connection con = null;
		PreparedStatement pstmt=null;
		int result=0;
		
		con=manager.getConnection();
		String sql="insert into comments(news_id, author, msg) values(?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt( 1, comments.getNews_id());
			pstmt.setString(2, comments.getAuthor());
			pstmt.setString(3, comments.getMsg());
			result = pstmt.executeUpdate(); //실행
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.release(con, pstmt);
		}
		return result;
	}
}







