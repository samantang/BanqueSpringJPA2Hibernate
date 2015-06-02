
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
					 <th>Code</th> <th>Date Création</th><th>Nom Compte</th><th>Solde</th><th>Nom Client</th><th>Operations</th>
				</tr>
				<c:forEach items="${form.comptes}" var="cpt">
				<tr>
 					<td>${cpt.codeCompte}</td>
 					<td>${cpt.dateCreation }</td>
 					<td>${cpt.nomCompte }</td>
					<td>${cpt.solde }</td>
					<td>${cpt.client.nomClient }</td>
					<td><a href="operations?code=${cpt.codeCompte}&solde=${cpt.solde }">Details</a> </td>
				</tr>
				</c:forEach>
			</table>
		</div>
		</div>
</body>
</html>