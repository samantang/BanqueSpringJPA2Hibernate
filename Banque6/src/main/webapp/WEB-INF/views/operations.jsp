
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
			<f:form modelAttribute="form" action="saveOperation" >
				<c:if test="${empty sessionScope.formClient }">
		
		<div>
					
		 		<f:hidden path="codeCompte"/>
		 		<table>
		 			<tr>
			 			<td>Versement: <f:radiobutton path="typeOperation"  value="VER" onclick="this.form.submit()"/></td>
			 			<td>Retrait: <f:radiobutton path="typeOperation" value="RET" onclick="this.form.submit()"/></td>
			 			<td>Virement: <f:radiobutton path="typeOperation" value="VIR" onclick="this.form.submit()"/></td>
		 			</tr>
		 			<c:if test="${not empty form.typeOperation}">
		 				<tr>
		 					<td>Montant</td>
		 					<td><f:input path="montant"/></td>
		 					<td><f:errors path="montant"></f:errors></td>
		 				</tr>
		 					<c:if test="${form.typeOperation=='VIR'}">
		 					<tr>
		 						<td>Vers le Compte:</td>
		 						<td><f:input path="codeCompte2"/></td>
		 						<td><f:errors path="codeCompte2"></f:errors></td>
		 					</tr>
		 					</c:if>
		 					<tr>
		 						<td><input type="submit" name="action" value="Ajouter"></td>
		 					</tr>
		 			</c:if>
		 			</table>
		 			
		</div>
				</c:if>
		<div>
			<table class="table">
				<tr>
					<th>N OP</th><th>OP</th><th>Date</th><th>Montant</th>
				</tr>
				<c:forEach items="${form.operations}" var="op">
				<tr>
					<td>${op.numeroOperation}</td>
 					<td>${op}</td>
 					<td>${op.dateOperation}</td>
 					<td>${op.montant}</td>
 					
				</tr>
				</c:forEach>
						<tr>
							<td>Solde</td>
							<td></td>
							<td></td>
							<td>${form.compte.solde}</td>
						</tr>
			</table>
		</div>
		</f:form>
		</div>
		
</body>
</html>