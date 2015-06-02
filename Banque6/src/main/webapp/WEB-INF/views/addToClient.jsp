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
		<div id="contenuDroite">
			 	<f:form action="addToClient" method="post"  modelAttribute="form">
			 		<div class="addClient">
			 		
			 			<c:if test="${empty form.typeCompte }">
			 				<p style="margin: 10px;">Selectionez le type de Compte � ajouter pour le Client</p>
				 			<table>
					 				<tr>
						 				<td>courant<f:radiobutton path="typeCompte" value="courant" onclick="this.form.submit()"/></td>
						 				<td>�pargne<f:radiobutton path="typeCompte" value="epargne" onclick="this.form.submit()"/></td>
						 			</tr>
					 		</table>
				 		</c:if>
				 		<c:if test="${ not empty form.typeCompte }">
				 			<table>
				 			 <tr>
				 				<td>idUser</td>
				 				<td><f:input path="codeClient"/></td>
				 				<td><f:errors path="codeClient"></f:errors></td>
				  			</tr>
				 			<tr>
				 				<td>codeEmpl</td>
				 				<td><f:input path="codeEmpl" value="${sessionScope.idEmp}" /></td>
				 				<td><f:errors path="codeEmpl"></f:errors></td>
				 			</tr>
				 			<tr>
				 				<td>nomCompte</td>
				 				<td><f:input path="nomCompte"/></td>
				 				<td><f:errors path="nomCompte"></f:errors></td>
				 			</tr>
				 			
				 			<tr>
				 				<td>soldeCompte</td>
				 				<td><f:input path="soldeCompte"/></td>
				 				<td><f:errors path="soldeCompte"></f:errors></td>
				 			</tr>
				 			<c:if test="${form.typeCompte == 'courant' }">
					 			<tr>
 					 				<f:hidden path="compteCourant" value="courant"/>
					 				<td>d�couvert auto</td>
					 				<td><f:input path="decouvert"/></td>
					 				<td><f:errors path="decouvert"></f:errors></td>
					 			</tr>
					 			</c:if>
					 			<c:if test="${form.typeCompte == 'epargne' }">
					 			<f:hidden path="compteEpargne" value="epargne"/>
					 				<td>Taux</td>
					 				<td><f:input path="taux"/></td>
					 				<td><f:errors path="taux"></f:errors></td>
					 			</c:if>
					 			<f:hidden path="code" value="code"/>
				 			<tr>
				 				<td><input type="submit" value="OK"></td>
				 			</tr>
				 		</table>
				 	</c:if>
			 		</div>
			 	
			 
			 <div class="addClient1">
			 		<table>
			 			
					 		<tr>
					 			<th>idUser</th><th>nomClient</th><th>adresseClient</th>
					 		</tr>
					 			<c:forEach items="${clients }" var="cli">
					 				<tr>
						 				<td>${cli.idUser }</td>
						 				<td><a href="clientDetails?code=${cli.idUser}">${cli.nomClient }</a></td>
						 				<td>${cli.adresseClient}</td>
					 				</tr>
					 			</c:forEach>
				 	</table>
				 	</div>
		    </f:form>
		 </div>
</body>
</html>