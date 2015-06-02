
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
					<th>Code employe</th><th>Nom Emp</th><th>Employe sup</th>
				</tr>
				<c:forEach items="${form.groupe.employes}" var="emp">
				<tr>
					<td>${emp.idUser}</td>
					<td>${emp.nomEmploye}</td>
					<td>${emp.employeSup.nomEmploye}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		</div>
</body>
</html>