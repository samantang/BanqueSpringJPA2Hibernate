<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css" >
<title>Page EmpSup</title>
</head>
<body>
                    <div id="leftcolumn_box02">
                    	<c:if test="${empty sessionScope.formClient }">
                        
                            <h2>Clients</h2>
                            <ul>
                                <li><a href="addClient">Ajouter un client</a></li>
                                <li><a href="addToClient">Ajouter un compte à un client</a></li>
                                <li><a href="showClients">Consulter les clients</a></li>

                            </ul>
                            <h2>Comptes</h2>
                            <ul>
                                <li><a href="addToClient">Ajouter un compte à un client</a></li>
                                <li><a href="showComptes">Afficher tous les comptes</a></li>
                                <li><a href="comptesCourants">Afficher les comptes courant</a></li>
                                <li><a href="comptesEpargnes">Afficher les comptes épargne</a></li>
                            </ul>
                            
                            <h2>Employés</h2>
                            <ul>
                                <li><a href="getEmployes">Afficher tous les employés</a></li>
                                 <c:if test="${!empty sessionScope.form }">
	                                <li><a href="addtEmploye">Ajouter un Empl</a></li>
	                                <li><a href="addEmpToGroup">Ajouter Empl à un Groupe</a></li>
	                             </c:if>   
                            </ul>
                            
                             <h2>Groupes</h2>
                            <ul>
                                <li><a href="getGoupes">Afficher tous les groupes</a></li>
                                <c:if test="${!empty sessionScope.form }">
                                	<li><a href="addGroupe">Ajouter un Groupe</a></li>
                                </c:if>
                            </ul>
                         </c:if> 
                         <c:if test="${not empty sessionScope.formClient }"> 
	                          <h2>Mes Comptes</h2>
	                            <ul>
	                                <li><a href="addOperationCli">Faire une Operation</a></li>
	                                <li><a href="myComptes">Mes comptes</a></li>
	                            </ul>
                           </c:if>   
                    </div>

</body>
</html>