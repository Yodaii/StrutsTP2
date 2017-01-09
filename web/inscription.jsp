<%-- 
    Document   : inscription
    Created on : 29 nov. 2016, 15:00:05
    Author     : Yohann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Inscription</title>
<style type="text/css">@import url(css/styles.css);</style>
</head>
<body>
<div id="enveloppe">									
	<h3><s:text name="inscription.titre"/></h3>    
	<s:form method="post" action="ValiderInscription">
		<s:textfield name="inscription.identifiant" label="identifiant" cssClass="input" />
                <s:password name="inscription.motdepasse" label="motdepasse" cssClass="input" />   
                <s:textfield name="inscription.nom" label="nom" cssClass="input" /> 
                <s:textfield name="inscription.prenom" label="prenom" cssClass="input" />  
                <s:textfield name="inscription.age" label="age" cssClass="input" />   
                <s:submit value="Inscription" />
	</s:form>  
        <s:url action="Identification" var="identification" ></s:url>
        <s:a href="%{identification}">Identification</s:a>   
</div>
</body>
</html>
