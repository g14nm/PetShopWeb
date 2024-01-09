<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Modifica Animale</title>
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
            <c:if test="${sessionScope.ruolo eq 'm'}">
                <li><a href="animali">Animali</a></li>
            </c:if>
            <li><a href="logout">Logout</a></li>
        </ul>
    </nav>
</header>
<form action="modificaAnimale" method="post">
    <div>
        <label for="nome">Nome:</label>
        <span><input type="text" id="nome" name="nome" value="${animale.nomeAnimale}"></span>
    </div>
    <div>
        <label for="tipo">Tipo:</label>
        <span><input type="text" id="tipo" name="tipo" value="${animale.tipoAnimale}"></span>
    </div>
    <div>
        <label for="prezzo">Prezzo:</label>
        <span><input type="text" id="prezzo" name="prezzo" value="${animale.prezzo}"></span>
        <span>${erroreConversioneNumero}</span>
    </div>
    <input type="hidden" name="matricola" value="${animale.matricola}">
    <div>
        <button type="submit">Conferma</button>
    </div>
</form>
</body>
</html>
