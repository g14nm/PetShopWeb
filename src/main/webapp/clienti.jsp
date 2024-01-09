<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Clienti</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
<header>
    <div>Pet Shop</div>
    <nav>
    	<div>
    		<span class="material-symbols-outlined">account_circle</span>
    		<div>
    			<div>${sessionScope.username}</div>
    			<c:choose>
                	<c:when test="${ruolo_autenticato eq 'm'}">
                    	<div>Manager</div>
                    </c:when>
                    <c:otherwise>
                        <div>Guest</div>
                    </c:otherwise>
                </c:choose>
    		</div>
    	</div>
        <ul>
            <li><a href="utenti">Utenti</a></li>
            <c:if test="${sessionScope.ruolo eq 'm'}">
                <li><a href="animali">Animali</a></li>
            </c:if>
            <li><a href="logout">Logout</a></li>
        </ul>
    </nav>
</header>
<section class="table-section">
    <table>
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Nome</th>
            <th scope="col">Cognome</th>
            <th scope="col">Indirizzo</th>
            <th scope="col">Città</th>
            <th scope="col">Telefono</th>
            <th colspan="1"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cliente" items="${clienti}">
            <tr>
                <td>${cliente.id}</td>
                <td>${cliente.nome}</td>
                <td>${cliente.cognome}</td>
                <td>${cliente.indirizzo}</td>
                <td>${cliente.città}</td>
                <td>${cliente.telefono}</td>
                <td class="opzioni">
                    <c:url value="animaliCliente" var="url_animalicliente">
                        <c:param name="id" value="${cliente.id}"></c:param>
                        <c:param name="nome" value="${cliente.nome}"></c:param>
                        <c:param name="cognome" value="${cliente.cognome}"></c:param>
                    </c:url>
                    <a href="${url_animalicliente}">
                        <button type="button">
                            Visualizza acquisti
                        </button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>
