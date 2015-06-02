
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css" >
<title></title>
</head>
<body>
		<div id="menuGauche">
			<%@include file="menu.jsp" %>
		</div>
		<div id="contenuDroite">
		
		<div>
			<table class="table">
				<tr>
					<th>N OP</th><th>OP</th><th>Date</th><th>Montant</th>
				</tr>
				<c:forEach items="${form.operations}" var="op">
				<tr>
					<td>${op.numeroOperation}</td>
 					<td>${op}</td>
 					<td>${op.dateOperation}</td>
 					<td>${op.montant}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		</div>
</body>
</html>