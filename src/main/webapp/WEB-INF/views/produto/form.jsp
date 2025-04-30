<%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 29/04/2025
  Time: 20:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Cadastro de Produto</title>
</head>
<body>
<h2><c:out value="${produto.id != null ? 'Editar' : 'Novo'}"/> Produto</h2>

<form:form method="post"
           action="${pageContext.request.contextPath}/produtos/salvar"
           modelAttribute="produto">

    <table>
        <tr>
            <td><form:label path="nome">Nome:</form:label></td>
            <td>
                <form:input path="nome"/>
                <form:errors path="nome" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="descricao">Descrição:</form:label></td>
            <td>
                <form:input path="descricao"/>
                <form:errors path="descricao" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="preco">Preço (R$):</form:label></td>
            <td>
                <form:input path="preco"/>
                <form:errors path="preco" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td><form:label path="dataCadastro">Data Cadastro:</form:label></td>
            <td>
                <form:input path="dataCadastro"/>
                <form:errors path="dataCadastro" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Salvar"/>
                <a href="${pageContext.request.contextPath}/produtos">Cancelar</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
