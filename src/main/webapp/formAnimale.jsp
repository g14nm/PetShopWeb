<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuovo Animale</title>
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
	                <div>Manager</div>
	    		</div>
    		</div>
	        <ul>
	            <li><a href="utenti">Utenti</a></li>
	            <li><a href="clienti">Clienti</a></li>
	            <li><a href="animali">Animali</a></li>
	            <li><a href="logout">Logout</a></li>
	        </ul>
	    </nav>
	</header>
	<section class="admin-form">
		<form action="registrazioneAnimale" method="post">
			<div>Nuovo animale</div>
		    <div>
		        <div>
		        	<label for="nome">Nome:</label>
		        	<input type="text" id="nome" name="nome" value="${param['nome']}">
		        </div>
		    </div>
		    <div>
		    	<div>
			        <label for="tipo">Tipo:</label>
			        <input type="text" id="tipo" name="tipo" value="${param['tipo']}">
			    </div>
		    </div>
		    <div>
		    	<div>
			        <label for="prezzo">Prezzo:</label>
			        <input type="text" id="prezzo" name="prezzo" value="${param['prezzo']}">
		        </div>
		        <div>${erroreConversioneNumero}</div>
		    </div>
		    <p>
		    	<button type="submit">Aggiungi</button>
		    </p>
		</form>
	</section>
</body>
</html>
