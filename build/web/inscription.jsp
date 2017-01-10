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
	<s:form method="post" action="ValiderInscription.action">
		<s:textfield key="inscription.identifiant" name="identifiant" cssClass="input" />
                <s:password key="inscription.motdepasse" name="motdepasse" cssClass="input" />   
                <s:textfield key="inscription.nom" name="nom" cssClass="input" /> 
                <s:textfield key="inscription.prenom" name="prenom" cssClass="input" />  
                <s:submit value="Inscription" />
	</s:form>  
        <s:url action="Identification" var="identification" ></s:url>
        <s:a href="%{identification}">Identification</s:a>   
        
        <s:if test="hasErrors()">
            <div id="message_erreur">
                <s:fielderror />
            </div>
        </s:if>
</div>
</body>
</html>
