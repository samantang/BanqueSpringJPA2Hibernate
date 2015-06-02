
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
		
		<div style="display: inline-block; vertical-align: top;">
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
		
		<div style="display: inline-block; vertical-align: top;">
			<table class="table">
				<tr>
					<th>Code Groupe</th><th>Groupe</th><th>Employés</th>
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
			<f:form action="addEmpToGroup"  modelAttribute="form">
				<table>
					<tr>
						<td>Code Empl</td>
						<td><f:input path="codeEmpl"/></td>
					</tr>
					<tr>
						<td>Code Groupe</td>
						<td><f:input path="codeGroupe"/></td>
					</tr>
					<tr>
						<td><input type="submit" value="Ajouter"></td>
					</tr>
				</table>
			</f:form>	
		</div>
		
		</div>
</body>
</html>