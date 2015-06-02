
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
		
		<div id="contenuDroite">
			<table class="table">
				<tr>
					<th>Code</th><th>nom client</th><th>cree par</th><th>compte(s)</th><th>Solde</th><th>date creation</th>
				</tr>
				<tr>
					<td>${client.idUser}</td>
					<td>${client.nomClient }</td>
					<td>${client.employe.nomEmploye }</td>
					<td>
					 <c:forEach items="${client.comptes }" var="cp">
						<a href="operations?code=${cp.codeCompte }">${cp.nomCompte }</a><br>
					</c:forEach> 
					</td>
					<td>
					 <c:forEach items="${client.comptes }" var="cp">
						${cp.solde }<br>
					</c:forEach> 
					</td>
					<td>
					 <c:forEach items="${client.comptes }" var="cp">
						${cp.dateCreation }<br>
					</c:forEach> 
					</td>
				</tr>
			</table>
		</div>
		</div>
</body>
</html>