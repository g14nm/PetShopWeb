<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Animali cliente</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/style.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
</head>
<body>
<c:set var="ruolo_autenticato" value="${sessionScope.ruolo}"></c:set>
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
            <li><a href="clienti">Clienti</a></li>
            <c:if test="${ruolo_autenticato eq 'm'}">
                <li><a href="animali">Animali</a></li>
            </c:if>
            <li><a href="logout">Logout</a></li>
        </ul>
    </nav>
</header>
<section class="table-section">
    <h1>Lista degli animali di ${param["nome"]} ${param["cognome"]} idCliente ${param["id"]}</h1>
    <table>
        <thead>
        <tr>
            <th scope="col">Matricola</th>
            <th scope="col">Nome</th>
            <th scope="col">Tipo animale</th>
            <th scope="col">Data acquisto</th>
            <th scope="col">Prezzo</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="animale" items="${animali}">
            <tr>
                <td>${animale.matricola}</td>
                <td>${animale.nomeAnimale}</td>
                <td>${animale.tipoAnimale}</td>
                <td>${animale.dataAcquisto}</td>
                <td>${animale.prezzo}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>
