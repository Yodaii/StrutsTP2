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
<title>Identification</title>
</head>
<body>
<div id="enveloppe">									
	<h3><s:text name="identification.titre"/></h3>    
	<s:form method="post" action="ValiderIdentification">
		<s:textfield key="identification.identifiant" name="identifiant" cssClass="input" />
                <s:password key="identification.motdepasse" name="motdepasse" cssClass="input" />        
                <s:submit key="identification.submit" />
	</s:form>
    
</div>
</body>
</html>