<%-- 
    Document   : identification
    Created on : 11 sept. 2014, 10:14:31
    Author     : gilles
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<style type="text/css">@import url(css/styles.css);</style>
<title>Administrateur</title>
</head>
<body>
<div id="enveloppe">									
	<h3><s:text name="annuaire.titre"/></h3>    
	<s:form method="post" action="ValiderAnnuaire">
		<s:textfield key="annuaire.identifiant" name="identifiant" cssClass="input" />
                <s:submit key="annuaire.submit" />
	</s:form>
        
</div>
</body>
</html>