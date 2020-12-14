<%@ page import="common.file.FileManager"%>
<%@ page import="board.model.BoardDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp" %>
<%
	//넘겨받은 board_id 를 이용하여 글 한건삭제 
	String board_id = request.getParameter("board_id");
	String filename = request.getParameter("filename");

	BoardDAO dao = new BoardDAO();
	//이미지 삭제하고, db 레코드 지우기
	String path=application.getRealPath("/data");
	if(FileManager.deleteFile(path+"/"+filename)){
		int result = dao.delete(Integer.parseInt(board_id));
		if(result==0){
			out.print(getMsgBack("게시물 삭제실패"));	
		}else{
			out.print(getMsgURL("삭제성공", "list.jsp"));
		}
	}else{
		out.print(getMsgBack("파일을 삭제할 수 없습니다."));
	}
%>



