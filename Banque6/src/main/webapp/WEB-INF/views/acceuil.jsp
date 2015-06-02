<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ma banque</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/style1.css" >
</head>
<body>
	<div id="templatemo_header">
                <div id="logosection" >
                    <div class="sitelogo"></div>
                    <div class="sitename">
            			MABANQUE<span></span>
            		</div>
                </div>
                <div id="header">
                    <div class="title">
                        SALIOU BANQUE<br />
                        <span class="bigtext">Ma nouvelle banque</span><br />
    	    			Pour réussir ma vie professionelle.           
                    </div>
                </div>
            </div>
            <div>
	            <div id="connexion_gauche" >
	            	<p style="color: silver;">lkfffffffffffffffjhhhhjjjjjjjjjjjjjjjhhhhhhhhhhh</p>
	            </div>
	            <div id="connexion_droit" >
	            	<div class="logout" style="text-align: right; margin-right: 15px; margin-top: 5px">
	            		<c:if test="${not empty sessionScope }">
	            			<a href="${pageContext.request.contextPath}/j_spring_security_logout">Déconnexion</a>
	            		</c:if>
	            	</div>
	            </div>
            </div>
            <c:if test="${empty sessionScope }">
	            <div id="utilisateur" style="text-align: center; margin-top: 25px;">
	            	<a href="/banque/client/index" style="font-size: 25px">Vous êtes client</a><br>
	            	<a href="/banque/empl/index" style="font-size: 25px">Vous êtes employe</a><br>
	            	<a href="/banque/emplSup/index" style="font-size: 25px">Vous êtes cadre</a>
	            </div>
	        </c:if>
            
           
</body>
</html>