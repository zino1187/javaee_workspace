package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBManager;

public class NewsDAO {
	DBManager manager=new DBManager();
	
	public List selectAll() {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList list = new ArrayList();
		
		con=manager.getConnection();
		StringBuilder sb = new StringBuilder();
		sb.append("select  n.news_id as news_id, writer, title , regdate, hit,count(comments_id) as cnt");
		sb.append("from news n , comments c ");
		sb.append("where n.news_id = c.news_id"); 
		sb.append("group by n.news_id,writer, title , regdate, hit order by t.news_id desc");

		try {
			pstmt=con.prepareStatement(sb.toString());
			rs=pstmt.executeQuery();
			while(rs.next()) {
				News news = new News();
				news.setNews_id(rs.getInt("news_id"));
				news.setWriter(rs.getString("writer"));
				news.setTitle(rs.getString("title"));
				news.setRegdate(rs.getString("regdate"));
				news.setHit(rs.getInt("hit"));
				news.setCnt(rs.getInt("cnt"));
				
				list.add(news);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.release(con, pstmt, rs);
		}
		return list;
	}
	
	public News select(int news_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		News news=null;
		
		con=manager.getConnection();
		String sql="select * from news where news_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, news_id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				news = new News();
				news.setNews_id(rs.getInt("news_id"));
				news.setWriter(rs.getString("writer"));
				news.setTitle(rs.getString("title"));
				news.setContent(rs.getString("content"));
				news.setRegdate(rs.getString("regdate"));
				news.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.release(con, pstmt, rs);
		}		
		return news;
	}
	public int insert(News news) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		con=manager.getConnection();
		String sql="insert into news(writer, title, content) values(?,?,?)";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, news.getWriter());
			pstmt.setString(2, news.getTitle());
			pstmt.setString(3, news.getContent());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.release(con, pstmt);
		}
		return result;
	}
	
	public int update(News news) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		con=manager.getConnection();
		String sql="update news set writer=?, title=?, content=? where news_id=?";
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, news.getWriter());
			pstmt.setString(2, news.getTitle());
			pstmt.setString(3, news.getContent());
			pstmt.setInt(4, news.getNews_id());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.release(con, pstmt);
		}
		return result;
	}
	public int delete(int news_id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int result=0;
		
		con=manager.getConnection();
		String sql="delete from news where news_id=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, news_id);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			manager.release(con, pstmt);
		}
		return result;
	}
}







