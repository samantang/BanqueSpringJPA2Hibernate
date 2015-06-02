
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
					<th>Code Groupe</th><th>Nom Groupe</th><th>Employés</th>
				</tr>
				<c:forEach items="${form.groupes}" var="gr">
				<tr>
					<td>${gr.codeGroupe}</td>
					<td>${gr.nomGroupe}</td>
					<td><a href="groupeDtail?code=${gr.codeGroupe}">Détails</a></td>
 				 </tr>
				</c:forEach>
			</table>
		</div>
		<div>
			<f:form action="addGroupe" modelAttribute="form">
				<f:hidden path="addGroupe" value="nom"/>
				<tr>
					<td>Nom du Groupe</td>
					<f:input path="nomGoupe"/>
				</tr>
				<tr>
					<td><input type="submit" value="Ajouter"></td>
				</tr>
			</f:form>
		</div>
		</div>
</body>
</html>