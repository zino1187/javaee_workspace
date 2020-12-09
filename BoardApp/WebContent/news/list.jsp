<%@ page contentType="text/html;charset=utf-8"%>
<%
	int totalRecord=26; //총 레코드 수
	int pageSize=10; //페이지당 보여질 레코드수(개발자가 임의로 지정 가능)
	int totalPage = (int)Math.ceil((float)totalRecord/pageSize);//총 페이지 수
	int blockSize=10; //블럭당 보여질 페이지 수 (개발자가 임의로 지정 가능) 	
	int currentPage=1; //현재 페이지(디폴트는 첫 페이지이다!!! 따라서 1)
	if(request.getParameter("currentPage")!=null){//파라미터로 페이지가 전달된다면...
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	int firstPage=currentPage - (currentPage-1)%blockSize;
	int lastPage=firstPage+(blockSize-1);
	int curPos = (currentPage-1)*pageSize;
	int num=totalRecord -  curPos;//페이지당 시작 번호
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
table{
	width:100%;
	border:1px solid #cccccc; 	
}
td{
	border:1px solid #cccccc; 
}
a{text-decoration:none;}

.pageNum{
	font-size:20pt;
	color:blue;
	font-weight:bold;
}
</style>
<script>
</script>
</head>
<body>

	<table>
		<tr>
			<td width="5%">No</td>
			<td width="70%">제목</td>
			<td width="10%">작성자</td>
			<td width="10%">등록일</td>
			<td width="5%">조회수</td>
		</tr>
		<%for(int i=1;i<=pageSize;i++){%>
		<%if(num<1)break; %>
		<tr>
			<td><%=num-- %></td>
			<td>제목 나올곳</td>
			<td>홍길동</td>
			<td>2020-12-20</td>
			<td>31</td>
		</tr>	
		<%} %>
		<tr>
			<td colspan="5" align="center">
				<a href="list.jsp?currentPage=<%=firstPage-1%>">◀</a>
				<%for(int i=firstPage;i<=lastPage;i++){ %>
					<%if(i>totalPage)break;//총 페이지수를 넘어서면... %>	
					<a  <%if(currentPage==i){%>class="pageNum"<%}%>   href="list.jsp?currentPage=<%=i%>">[<%=i %>]</a>
				<%} %>
				<a href="list.jsp?currentPage=<%=lastPage+1%>">▶</a>
			</td>
		</tr>
	</table>
</body>
</html>











