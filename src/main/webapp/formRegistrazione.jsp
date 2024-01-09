<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
	<section class="registration-form">
		<form action="registrazione" method="post">
			<div>Registrati</div>
			<div>	    
				<div><label for="nome">Nome:</label></div>
		        <div><input type="text" id="nome" name="nome" value="${param['nome']}" required></div>
		        <div>${messaggiErrore["nome"]}</div>
		    </div>
		    <div>
		        <div><label for="cognome">Cognome:</label></div>
		        <div><input type="text" id="cognome" name="cognome" value="${param['cognome']}" required></div>
		        <div>${messaggiErrore["cognome"]}</div>
		    </div>
		    <div>
		        <div><label for="email">Email:</label></div>
		        <div><input type="email" id="email" name="email" value="${param['email']}" required></div>
		        <div>${messaggiErrore["email"]}</div>
		    </div>
		    <div>
		        <div><label for="cellulare">Cellulare:</label></div>
		        <div><input type="text" id="cellulare" name="cellulare" value="${param['cellulare']}" maxlength="10" placeholder="10 caratteri" required></div>
		        <div>${messaggiErrore["cellulare"]}</div>
		    </div>
		    <div>
		        <div><label for="data">Data di nascita:</label></div>
		        <div><input type="date" id="data" name="data_di_nascita" value="${param['data_di_nascita']}" required></div>
		        <div>${messaggiErrore["data_di_nascita"]}</div>
		    </div>
		    <div>
		        <div><label for="password">Password:</label></div>
		        <div><input type="password" id="password" name="password" minlength="8" placeholder="almeno 8 caratteri senza spazi vuoti" required></div>
		        <div>${messaggiErrore["password"]}</div>
		    </div>
		    <button type="submit">Conferma</button>
		</form>
	</section>
</body>
</html>
