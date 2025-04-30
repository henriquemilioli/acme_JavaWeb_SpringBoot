<%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 29/04/2025
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Lista de Produtos</title>
</head>
<body>
<h2>Produtos Cadastrados</h2>

<c:if test="${not empty sucesso}">
    <div style="color:green">${sucesso}</div>
</c:if>

<a href="${pageContext.request.contextPath}/produtos/novo">Novo Produto</a>
<br/><br/>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Preço (R$)</th>
        <th>Data Cadastro</th>
        <th>Ações</th>
    </tr>
    <c:forEach var="p" items="${produtos}">
        <tr>
            <td>${p.id}</td>
            <td>${p.nome}</td>
            <td>${p.descricao}</td>
            <td>
                <fmt:formatNumber value="${p.preco}" type="currency" currencySymbol="R$"/>
            </td>
            <td>
                <fmt:formatDate value="${p.dataCadastro}" pattern="dd/MM/yyyy"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/produtos/editar/${p.id}">Editar</a>
                |
                <a href="${pageContext.request.contextPath}/produtos/excluir/${p.id}"
                   onclick="return confirm('Confirma exclusão?');">
                    Excluir
                </a>
                |
                <a href="${pageContext.request.contextPath}/cotacoes/produto/${p.id}">
                    Ver Cotações
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
