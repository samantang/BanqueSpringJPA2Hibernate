
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
		<div id="">
				<%@include file="acceuil.jsp" %>
		</div> 
		<div id="menuGauche">
			<%@include file="menu.jsp" %>
		</div>
		<div id="contenuDroite">
		
		<div>
			<table class="table">
				<tr>
					<th>Code Empl</th><th>Nom Empl</th><th>Empl Sup</th>
				</tr>
				<c:forEach items="${form.employes}" var="em">
				<tr>
					<td>${em.idUser}</td>
					<td><a href="employeDetails?code=${em.idUser}">${em.nomEmploye}</a></td>
					<td>${em.employeSup.nomEmploye }</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		</div>
</body>
</html>