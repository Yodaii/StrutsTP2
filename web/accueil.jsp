<%-- 
    Document   : accueil
    Created on : 11 sept. 2014, 13:11:17
    Author     : gilles
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<title><s:text name="accueil.label"/></title>
<style type="text/css">@import url(css/styles.css);</style>
</head>
<body>
<s:debug/>
<div id="enveloppe">
    <P> 
     <h4> <s:text name="accueil.label"/> </h4>
          <s:text name="accueil.identifiant"/> : <s:property value="identifiant"/> <br/>
          <s:text name="accueil.motdepasse"/> : <s:property value="motdepasse"/><br/>     
</div>
</body>
</html>
