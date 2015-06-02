<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ma banque</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css" >
</head>
<body>
	<div id="menuGauche">
		<%@include file="menu.jsp" %>
	</div>
		<div id="contenuClients">
			 	
			 <div class=addClient1>
			 		<p>Les Comptes du Client</p>
			 	
			 	<f:form action="client" modelAttribute="form">
			 		<f:hidden path="findClient" value="yep"/>
			 		<table>
			 			<tr>
			 				<f:input path="idClient"/>
			 			</tr>
			 			<tr>
			 				<td><input type="submit" value="chercher"></td>
			 			</tr>
			 		</table>
			 	</f:form>
			 	<c:if test="${not empty form.findClient }">	
			 		<f:form action="client" modelAttribute="form">
					 	<table >
					 		<tr>
					 			<th>Code Compte</th><th>Solde</th>
					 		</tr>
					 			<c:forEach items="${form.client.comptes }" var="cp">
					 				<tr>
						 				<td>${cp.codeCompte }</td>
						 				<td>${cp.solde}</td>
					 				</tr>
					 			</c:forEach>
					 	</table>
				 	</f:form>
			 	</c:if>
			 	</div >
			 </div>
</body>
</html>