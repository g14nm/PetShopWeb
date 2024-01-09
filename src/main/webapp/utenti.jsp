<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Utenti</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/style.css">
</head>
<body>
<c:set var="ruolo_autenticato" value="${sessionScope.ruolo}"></c:set>
<header>
    <div>Pet Shop</div>
    <nav>
        <ul>
            <li><a href="clienti">Clienti</a></li>
            <c:if test="${ruolo_autenticato eq 'm'}">
                <li><a href="animali">Animali</a></li>
            </c:if>
            <li><a href="logout">Logout</a></li>
        </ul>
    </nav>
</header>
<form action="utenti" method="post">
    <section class="table-section">
        <table>
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Nome</th>
                <th scope="col">Cognome</th>
                <th scope="col">Username</th>
                <th scope="col">Email</th>
                <th scope="col">Cellulare</th>
                <c:if test="${ruolo_autenticato eq 'm'}">
                    <th scope="col">Password</th>
                </c:if>
                <th scope="col">Ruolo</th>
                <th scope="col">Stato</th>
                <c:if test="${ruolo_autenticato eq 'm'}">
                    <th colspan="1"></th>
                </c:if>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="utente" items="${utenti}">
                <tr>
                    <td>${utente.id}</td>
                    <td>${utente.nome}</td>
                    <td>${utente.cognome}</td>
                    <td>${utente.username}</td>
                    <td>${utente.email}</td>
                    <td>${utente.cellulare}</td>
                    <c:if test="${ruolo_autenticato eq 'm'}">
                    	<td>${utente.password}</td>
                	</c:if>
                    <c:choose>
                        <c:when test="${fn:substring(utente.ruolo, 0, 1) eq 'm'}">
                            <td>Manager</td>
                        </c:when>
                        <c:otherwise>
                            <td>Guest</td>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${fn:substring(utente.stato, 0, 1) eq 'a'}">
                            <td>Abilitato</td>
                        </c:when>
                        <c:otherwise>
                            <td>Disabilitato</td>
                        </c:otherwise>
                    </c:choose>
                    <c:if test="${ruolo_autenticato eq 'm'}">
                        <td class="opzioni">
                            <c:url value="cambiastato" var="url_stato">
                                <c:param name="username" value="${utente.username}"></c:param>
                            </c:url>
                            <c:choose>
                                <c:when test="${fn:substring(utente.stato, 0, 1) eq 'a'}">
                                    <a href="${url_stato}">
                                        <button type="button">Disabilita</button>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${url_stato}">
                                        <button type="button">Abilita</button>
                                    </a>
                                </c:otherwise>
                            </c:choose>
                            <c:url value="cambiaruolo" var="url_ruolo">
                                <c:param name="username" value="${utente.username}"></c:param>
                            </c:url>
                            <c:choose>
                                <c:when test="${fn:substring(utente.ruolo, 0, 1) eq 'g'}">
                                    <a href="${url_ruolo}">
                                        <button type="button">Manager</button>
                                    </a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${url_ruolo}">
                                        <button type="button">Guest</button>
                                    </a>
                                </c:otherwise>
                            </c:choose>
                            <button type="button" class="bottoneMostra" data-username="${utente.username}"
                                    data-email="${utente.email}" data-password="${utente.password}"
                                    data-cellulare="${utente.cellulare}">
                                Modifica
                            </button>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
</form>
</body>
<script>
    document.addEventListener('DOMContentLoaded', () => {
        let trNascosto; // Riferimento all'elemento <tr> nascosto

        const bottoni = document.querySelectorAll('.bottoneMostra');
        bottoni.forEach(bottone => {
            bottone.addEventListener('click', () => {
                // Se c'è già un tr nascosto, rimuovilo
                if (trNascosto) {
                    trNascosto.remove();
                }

                // Crea il nuovo tr nascosto
                trNascosto = document.createElement('tr');

                const spanTd = document.createElement('td');
                spanTd.colSpan = 4;
                trNascosto.appendChild(spanTd);

                const emailTd = document.createElement('td');
                const emailInput = document.createElement('input');
                emailInput.type = 'email';
                emailInput.name = `email`;
                emailInput.value = bottone.dataset.email;
                emailTd.appendChild(emailInput);
                trNascosto.appendChild(emailTd);

                const cellulareTd = document.createElement('td');
                const cellulareInput = document.createElement('input');
                cellulareInput.type = 'text';
                cellulareInput.name = `cellulare`;
                cellulareInput.value = bottone.dataset.cellulare;
                cellulareTd.appendChild(cellulareInput);
                trNascosto.appendChild(cellulareTd);

                const passwordTd = document.createElement('td');
                const passwordInput = document.createElement('input');
                passwordInput.type = 'text';
                passwordInput.name = `password`;
                passwordInput.value = bottone.dataset.password;
                passwordTd.appendChild(passwordInput);
                trNascosto.appendChild(passwordTd);

                const submitButtonTd = document.createElement('td');
                const submitButton = document.createElement('button');
                submitButton.type = 'submit';
                submitButton.textContent = 'salva modifiche';
                submitButtonTd.appendChild(submitButton);
                trNascosto.appendChild(submitButtonTd);

                const cancelButtonTd = document.createElement('td');
                const cancelButton = document.createElement('button');
                cancelButton.type = 'button';
                cancelButton.textContent = 'annulla';
                cancelButtonTd.appendChild(cancelButton);
                trNascosto.appendChild(cancelButtonTd);
                cancelButton.addEventListener('click', () => {
                    trNascosto.remove();
                })

                const usernameTd = document.createElement('td');
                const usernameInput = document.createElement('input');
                usernameInput.type = 'hidden';
                usernameInput.name = `username`;
                usernameInput.value = bottone.dataset.username;
                usernameTd.appendChild(usernameInput);
                trNascosto.appendChild(usernameTd);

                // Trova l'elemento <tr> antenato del bottone e inserisci il nuovo tr dopo di esso
                const elemento = bottone.parentElement.parentElement;
                elemento.insertAdjacentElement('afterend', trNascosto);
            });
        });
    });
</script>
</html>
