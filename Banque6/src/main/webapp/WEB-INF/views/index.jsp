<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css" >
<title>IndexEmp</title>
</head>
<body>
			 <div id="">
				<%@include file="acceuil.jsp" %>
			</div> 
			 <div id="menuGauche">
				<%@include file="menu.jsp" %>
			</div> 
	
</body>
</html>