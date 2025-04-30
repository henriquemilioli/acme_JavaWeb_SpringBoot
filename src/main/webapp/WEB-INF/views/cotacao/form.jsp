<%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 29/04/2025
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title><c:out value="${cotacao.id != null ? 'Editar' : 'Nova'}"/> Cotação
        para <strong><c:out value="${cotacao.produto.nome}"/></strong>
    </title>
</head>
<body>
<form:form method="post"
           action="${pageContext.request.contextPath}/cotacoes/salvar"
           modelAttribute="cotacao">

    <form:hidden path="produto.id"/>

    <table>
        <tr>
            <td><form:label path="dataCotacao">Data:</form:label></td>
            <td>
                <form:input path="dataCotacao"/>
                <form:errors path="dataCotacao" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="fornecedor">Fornecedor:</form:label></td>
            <td>
                <form:input path="fornecedor"/>
                <form:errors path="fornecedor" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="valor">Valor (R$):</form:label></td>
            <td>
                <form:input path="valor"/>
                <form:errors path="valor" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Salvar"/>
                <a href="${pageContext.request.contextPath}/cotacoes/produto/${cotacao.produto.id}">
                    Cancelar
                </a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
