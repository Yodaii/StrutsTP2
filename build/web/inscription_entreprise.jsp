<%-- 
    Document   : inscription_entreprise
    Created on : 10 janv. 2017, 17:56:34
    Author     : Yohann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title>Inscription Entreprise</title>
<style type="text/css">@import url(css/styles.css);</style>
</head>
<body>
<div id="enveloppe">									
	<h3><s:text name="inscription_entr.titre"/></h3>    
	<s:form method="post" action="ValiderInscriptionEntr.action">
		<s:textfield key="inscription.identifiant" name="identifiant" cssClass="input" />
                <s:password key="inscription.motdepasse" name="motdepasse" cssClass="input" />   
                <s:textfield key="inscription_entr.rs" name="raisonSociale" cssClass="input" />
                <s:submit value="Inscription" />
	</s:form>  
        
        <s:url action="Identification" var="identification" ></s:url>
        <s:a href="%{identification}">Identification</s:a> 
        
        <s:url action="InscriptionPart" var="inscription" ></s:url>
        <s:a href="%{inscription}">Inscription Particulier</s:a>
        
        <s:if test="hasErrors()">
            <div id="message_erreur">
                <s:fielderror />
            </div>
        </s:if>
</div>
</body>
</html>
