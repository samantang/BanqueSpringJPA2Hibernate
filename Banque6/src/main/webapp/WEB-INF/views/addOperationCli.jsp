
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
					<f:form modelAttribute="form" action="addOperationCli" >
		 		<table>
		 			<tr>
			 			<td>choisir le compte à débiter</td>
			 				   <td> <f:select path="nomCompte"> 
			 				    	<c:forEach items="${form.cli.comptes }" var="cp">
			 							<f:option value="${cp.nomCompte }"></f:option>
			 						</c:forEach>	
			 					</f:select></td>
		 			</tr>
		 			<tr>
		 				<td> le montant</td>
		 				<td><f:input path="montant"/></td>
		 			</tr>
		 			<tr>
			 			<td>choisir le compte à créditer</td>
			 				  <td> <f:select path="nomCompte2">
			 				   		<c:forEach items="${form.cli.comptes }" var="cp">
			 							<f:option value="${cp.nomCompte }"></f:option>
			 						</c:forEach>	
			 					</f:select></td>
		 			</tr>
		 			<tr>
		 				<td><input type="submit" value="Transferer"></td>
		 			</tr>	
		 			</table>
		 		</f:form>	
		</div>
		
		
		</div>
</body>
</html>