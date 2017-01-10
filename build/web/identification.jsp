<%-- 
    Document   : identification
    Created on : 11 sept. 2014, 10:14:31
    Author     : gilles
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Identification</title>
<style type="text/css">@import url(css/styles.css);</style>
</head>
<body>
<div id="enveloppe">									
	<h3><s:text name="identification.titre"/></h3>    
	<s:form method="post" action="ValiderIdentification">
		<s:textfield key="identification.identifiant" name="identifiant" cssClass="input" />
                <s:password key="identification.motdepasse" name="motdepasse" cssClass="input" />        
                <s:submit key="identification.submit" />
	</s:form>
        
        <s:url action="InscriptionPart" var="inscription" ></s:url>
        <s:a href="%{inscription}">Inscription Particulier</s:a> 
        
        <s:url action="InscriptionEntr" var="inscription" ></s:url>
        <s:a href="%{inscription}">Inscription Entreprise</s:a>
        
        <s:if test="hasErrors()">
            <div id="message_erreur">
                <s:fielderror />
            </div>
        </s:if>
</div>
</body>
</html>