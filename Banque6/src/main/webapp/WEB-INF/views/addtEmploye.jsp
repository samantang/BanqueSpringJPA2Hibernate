
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
					<f:form modelAttribute="form" action="addtEmploye" >
		 		<table>
		 			<c:if test="${empty form.codeSup }">
			 			<tr>
				 			<td>Nom Employe</td>
				 			<td><f:input path="nomEmploye"/></td>
			 			</tr>
			 			<tr>
				 			<td>identifiant</td>
				 			<td><f:input path="userName"/></td>
			 			</tr>
			 			<tr>
				 			<td>Mot de passe</td>
				 			<td><f:input path="passWord"/></td>
			 			</tr>
			 			<tr>
				 			<td>Code Sup</td>
				 			<td><f:input path="codeSup"/></td>
			 			</tr>
			 			<tr>
			 				<td><input type="submit" value="Ajouter"></td>
			 			</tr>
		 			</c:if>
		 		</table>
		 			<c:if test="${!empty form.codeSup }">
		 			<p>L'employe ${form.nomEmploye} a bien été Ajouté</p>
		 			<a href="getEmployes">Consulter les Employés</a>
		 			</c:if>
		 			
		 		</f:form>	
		</div>
		
		</div>
</body>
</html>