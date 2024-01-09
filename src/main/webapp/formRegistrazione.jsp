<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrazione</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<header>
    <div>Pet Shop</div>
    <nav>
        <ul>
            <li><a href="login">Login</a></li>
        </ul>
    </nav>
</header>
	<form action="registrazione" method="post">
	    <div>
	        <label for="nome">Nome:</label>
	        <span><input type="text" id="nome" name="nome" value="${param['nome']}"></span>
	    </div>
	    <div>
	        <label for="cognome">Cognome:</label>
	        <span><input type="text" id="cognome" name="cognome" value="${param['cognome']}"></span>
	    </div>
	    <div>
	        <label for="email">Email:</label>
	        <span><input type="email" id="email" name="email" value="${param['email']}"></span>
	        <span>${messaggiErrore["email"]}</span>
	    </div>
	    <div>
	        <label for="cellulare">Cellulare:</label>
	        <span><input type="text" id="cellulare" name="cellulare" value="${param['cellulare']}"></span>
	    </div>
	    <div>
	        <label for="data">Data di nascita:</label>
	        <span><input type="date" id="data" name="data_di_nascita" value="${param['data_di_nascita']}"></span>
	    </div>
	    <div>
	        <label for="password">Password:</label>
	        <span><input type="password" id="password" name="password"></span>
	    </div>
	    <div>
	        <button type="submit">Conferma</button>
	    </div>
	</form>
</body>
</html>
