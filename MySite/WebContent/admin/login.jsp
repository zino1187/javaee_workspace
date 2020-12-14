<%@ page contentType="text/html;charset=utf-8"%>
<%
	String admin_id="scott";
	String admin_pass = "1234";
	
	/*
	원래는 데이터베이스에서 조회를 해야 하지만, 추후 하기로 하고 
	일단은 스트링으로 비교 해본다..
	*/
	String mid = request.getParameter("mid");
	String password = request.getParameter("password");
	
	//아이디가 같고, 비번까지 같다면..
	if(mid.equals(admin_id) &&  password.equals(admin_pass)){
		//로그인 성공에 대한 보상!!
	}else{
		//로그인 실패에 대한 욕!!
	}
%>