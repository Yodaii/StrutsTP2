<%-- 
    Document   : accueil
    Created on : 11 sept. 2014, 13:11:17
    Author     : gilles
--%>

<%@page import="objet_metiers.Abonne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
        <title><s:text name="accueil.label"/></title>
        <style type="text/css">@import url(css/styles.css);</style>
    </head>
    <body>
        <div id="enveloppe">
            <P> 
            <h4> <s:text name="accueil.label"/> </h4>
            <s:text name="accueil.identifiant"/> : <s:property value="#session.unAbon.getIdentifiant()" /> <br/>
            
        </div>
    </body>
</html>
