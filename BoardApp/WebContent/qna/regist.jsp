<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//넘겨받은 파라미터를 이용하여 원글 등록!!
	//또한 원글의 team값을 곧바로 pk값으로 update 
	
	//파라미터 받기 
	request.setCharacterEncoding("utf-8");//전송된 파라미터들이 깨지지 않도록
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	
	
%>