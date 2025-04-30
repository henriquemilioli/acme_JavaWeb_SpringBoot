<%--
  Created by IntelliJ IDEA.
  User: henry
  Date: 29/04/2025
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Cotações para ${produto.nome}</title>
</head>
<body>
<h2>Cotações de <strong><c:out value="${produto.nome}"/></strong></h2>
<a href="${pageContext.request.contextPath}/cotacoes/novo/${produto.id}">
    Nova Cotação
</a>
|
<a href="${pageContext.request.contextPath}/cotacoes/export/${produto.id}">
    Exportar CSV
</a>
<br/><br/>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Data</th>
        <th>Fornecedor</th>
        <th>Valor (R$)</th>
        <th>Ações</th>
    </tr>
    <c:forEach var="c" items="${cotacoes}">
        <tr>
            <td>${c.id}</td>
            <td><fmt:formatDate value="${c.dataCotacao}" pattern="dd/MM/yyyy"/></td>
            <td>${c.fornecedor}</td>
            <td><fmt:formatNumber value="${c.valor}" type="currency" currencySymbol="R$"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/cotacoes/excluir/${c.id}"
                   onclick="return confirm('Confirma exclusão?');">
                    Excluir
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="${pageContext.request.contextPath}/produtos">Voltar a Produtos</a>

</body>
</html>
