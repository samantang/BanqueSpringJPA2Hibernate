<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ma banque</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css" >
</head>
<body>
	<div id="">
				<%@include file="acceuil.jsp" %>
	</div> 
	<div id="menuGauche">
		<%@include file="menu.jsp" %>
	</div>
		<div id="contenuClients">
			 	<%-- <f:form action="addToClient" method="post"  modelAttribute="form">
			 		<div>
			 			<table>
				 			 <tr>
				 				<td>codeClient</td>
				 				<td><f:input path="codeClient"/></td>
				 				<td><f:errors path="codeClient"></f:errors></td>
				  			</tr>
				 			<tr>
				 				<td>codeEmpl</td>
				 				<td><f:input path="codeEmpl"/></td>
				 				<td><f:errors path="codeEmpl"></f:errors></td>
				 			</tr>
				 			<tr>
				 				<td>codeCompte</td>
				 				<td><f:input path="codeCompte"/></td>
				 				<td><f:errors path="codeCompte"></f:errors></td>
				 			</tr>
				 			
				 			<tr>
				 				<td>soldeCompte</td>
				 				<td><f:input path="soldeCompte"/></td>
				 				<td><f:errors path="soldeCompte"></f:errors></td>
				 			</tr>
				 			<tr>
				 				<td><input type="submit" value="OK"></td>
				 			</tr>
				 		</table>
			 		</div>
			 	</f:form> --%>
			<!--  </div>
			 <div> -->
			 <div class=addClient1>
			 		<p>Les clients crées</p>
			 	<table >
			 		<tr>
			 			<th>codeClient</th><th>nomClient</th><th>adresseClient</th>
			 		</tr>
			 			<c:forEach items="${form.employe.clients }" var="cli">
			 				<tr>
				 				<td>${cli.idUser }</td>
				 				<td><a href="clientDetails?code=${cli.idUser}">${cli.nomClient }</a></td>
				 				<td>${cli.adresseClient}</td>
			 				</tr>
			 			</c:forEach>
			 	</table>
			 	</div >
			 </div>
</body>
</html>