<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Connexion</title>
</head>
<body>
<body>
<c:set var="context" value="${pageContext.request.contextPath}" /> 
<%@ include file="menu.jsp" %>
<div class="container">
	<form method="post" action="${context}/login">
	     <fieldset>
	         <legend>Connexion</legend>
	
	         <label for="pseudo"> Pseudo <span class="requis">*</span></label>
	         <input type="text" id="pseudo" name="pseudo" value="${param.pseudo}" size="20" maxlength="60" />
	         <br />
	
	         <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
	         <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
	         <br />
	
	         <input type="submit" value="Connexion" class="btn btn-default" />
	         <br />
	     </fieldset>
	</form>
		<br>
</div>
<%@ include file="Footer.jsp" %>
</body>
</html>
