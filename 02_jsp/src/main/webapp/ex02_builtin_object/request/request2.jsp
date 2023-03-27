<%@page import="java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		
		request.setCharacterEncoding("UTF-8");
		String model = request.getParameter("model");
		//String price = request.getParameter("price"); //값이 있거나 null값인 애들은 class Optional로 한번 감쌀 수 있음 
		Optional<String> opt = Optional.ofNullable(request.getParameter("price"));	//request.getPramater가 없다면 0을 쓰겠다라는 코드임 근데 빈 문자열을 잡는다면 못잡는다 
		int price = Integer.parseInt(opt.orElse("0"));
		
	%>
	
	<h1>모델 : <%=model%></h1>
	<h1>가격 : <%=price%></h1>
	
</body>
</html>