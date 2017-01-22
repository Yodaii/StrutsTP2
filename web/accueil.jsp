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
            <h3> Bienvenue dans l'annuaire <s:property value="#session.annuaire.getNom()" />,  <s:property value="#session.unAbon.getIdentifiant()" /></h3>
            <div style="margin-bottom:2%">
                <h4>Poster un message</h4>
                <s:form method="post" action="ValiderMessage.action">
                    <s:textfield key="accueil.objet" name="objet" cssClass="input" />
                    <s:textarea key="accueil.corps" name="corps" cssClass="input" />
                    <s:submit value="Poster" />
                </s:form>
                <s:if test="hasErrors()">
                    <div id="message_erreur">
                        <s:fielderror />
                    </div>
                </s:if>
            </div>
            <div>
                <table>
                    <tr>
                        <td>
                            Liste d'Abonnes
                        </td>
                        <td>
                            <select name="abonne">
                                <s:iterator value="#session.abonnes" var="abonne">
                                    <option value="<s:property value="#abonne.getIdentifiant()"/>"><s:property value="#abonne.getIdentifiant()"/></option> 
                                </s:iterator>
                            </select>
                        </td>
                    </tr>
                </table>
            </div>
            <ul style="list-style-type:none;">
                <s:iterator value="#session.messages" var="message">
                    <li style="border:1px solid black;padding:1%;">
                        <h4 style="margin-bottom:1%"><s:property value="#message.getObjet()"/><i style="font-size:12px;margin-left:2%">posté par <s:property value="#message.getAbonne().getIdentifiant()"/></i></h4>
                        <p><s:property value="#message.getCorps()"/></p>
                    </li>
                </s:iterator>
            </ul>
            <s:url action="Desinscription" var="desinscription" ></s:url>
            <s:a href="%{desinscription}">Désinscription</s:a>
        </div>
    </body>
</html>
