<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="./css/style.css">
</head>
<body>
	<header>
		<div>Pet Shop</div>
	</header>
	<div style="text-align: center; margin-top: 50px;">
		Non sei registrato? <a href="registrazione">Registrati</a>
	</div>
	<section class="login-form">
		<form action="login" method="post">
			<div>Accedi</div>
			<div>
				<label for="username_email"></label> 
				<span><input type="text" id="username_email" name="username_email" value="${param['username_email']}" placeholder="username/email" required></span> 
				<span class="error-text">${messaggiErrore["username_email"]}</span>
			</div>
			<div>
				<label for="password"></label> 
				<span><input type="password" id="password" name="password" placeholder="password" required></span>
				<span class="error-text">${messaggiErrore["password"]}</span>
			</div>
			<div>
				<button type="submit">Accedi</button>
			</div>
		</form>
	</section>
</body>
</html>