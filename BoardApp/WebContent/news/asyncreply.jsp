<%@page import="board.model.Comments"%>
<%@page import="java.util.List"%>
<%@page import="board.model.CommentsDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp" %>
<%
	//여기서 쿼리실행할 것은 아니지만, 계획을 세우기 위해 ....
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="comments" class="board.model.Comments"/>
<jsp:setProperty property="*" name="comments"/>
<%
	CommentsDAO dao = new CommentsDAO();
	int result=dao.insert(comments);
	
	StringBuilder sb = new StringBuilder();
	
	if(result==0){
		sb.append("{");
		sb.append("\"resultCode\":"+result);
		sb.append("}");
	}else{
		//목록 조회 
		List<Comments> list = dao.selectAll(comments.getNews_id());//뉴스기사에 소속된 모든 댓글 목록 가져오기!!
		//out.print(list); // html로 구성된 클라이언트가 이해할 수 잇는 포맷으로 보내자!!! json 대표적!!
		sb.append("{");
		sb.append("\"resultCode\":"+result+", ");
		sb.append("\"commentsList\" : [");
		sb.append("{");
		sb.append("\"comments_id\":23,");
		sb.append("\"author\":\"batman\",");
		sb.append("\"msg\":\"집회좀 하지마\",");
		sb.append("\"cdate\":\"2020-12-10\"");
		sb.append("},");
		sb.append("{");
		sb.append("\"comments_id\":23,");
		sb.append("\"author\":\"batman\",");
		sb.append("\"msg\":\"집회좀 하지마\",");
		sb.append("\"cdate\":\"2020-12-10\"");
		sb.append("}");	
		sb.append("]");
		sb.append("}");		
	}
	out.print(sb.toString());
%>







