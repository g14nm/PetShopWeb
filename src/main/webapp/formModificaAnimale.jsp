<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
	            <li><a href="animali">Animali</a></li>
	            <li><a href="logout">Logout</a></li>
	        </ul>
	    </nav>
	</header>
	<section class="admin-form">
		<form action="modificaAnimale" method="post">
			<div>Modifica animale</div>
		    <div>
		        <div>
		        	<label for="nome">Nome:</label>
		        	<input type="text" id="nome" name="nome" value="${animale.nomeAnimale}">
		        </div>
		    </div>
		    <div>
		    	<div>
			        <label for="tipo">Tipo:</label>
			        <input type="text" id="tipo" name="tipo" value="${animale.tipoAnimale}">
			    </div>
		    </div>
		    <div>
		    	<div>
			        <label for="prezzo">Prezzo:</label>
			        <input type="text" id="prezzo" name="prezzo" value="${animale.prezzo}">
		        </div>
		        <div>${erroreConversioneNumero}</div>
		    </div>
		    <p>
		    	<button type="submit">Conferma</button>
		    </p>
		</form>
	</section>
</body>
</html>
