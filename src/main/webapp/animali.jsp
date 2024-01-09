<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Animali</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
<header>
    <div>Pet Shop</div>
    <nav>
        <ul>
            <li><a href="utenti">Utenti</a></li>
            <li><a href="clienti">Clienti</a></li>
            <li><a href="logout">Logout</a></li>
        </ul>
    </nav>
</header>
<section class="table-section">
    <a href="registrazioneAnimale">
        <button>Aggiungi animale</button>
    </a>
    <table>
        <thead>
        <tr>
            <th scope="col">Matricola</th>
            <th scope="col">Nome</th>
            <th scope="col">Tipo animale</th>
            <th scope="col">Data acquisto</th>
            <th scope="col">Prezzo</th>
            <th colspan="1">Opzioni</th>
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
                <c:choose>
                    <c:when test="${empty animale.dataAcquisto}">
                        <td class="opzioni">
                            <c:url value="modificaAnimale" var="url_modifica">
                                <c:param name="matricola" value="${animale.matricola}"></c:param>
                            </c:url>
                            <a href="${url_modifica}">
                                <button type="button">Modifica</button>
                            </a>
                            <c:url value="eliminaAnimale" var="url_elimina">
                                <c:param name="matricola" value="${animale.matricola}"></c:param>
                            </c:url>
                            <a href="${url_elimina}">
                                <button type="button">Elimina</button>
                            </a>
                        </td>
                    </c:when>
                    <c:otherwise>
                        <td colspan="1"></td>
                    </c:otherwise>
                </c:choose>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>
