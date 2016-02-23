<!DOCTYPE html>

<html lang="cs">
	<head>
		<meta charset="utf-8" />

		<title>BRACES</title>
		<meta name="description" content="" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="shortcut icon" href="./favicon.ico" />
		<meta name="author" content="Scorpio" />

		<meta name="robots" content="index, follow" />
		<meta name="googlebot" content="snippet, archive" />

		<link rel="stylesheet" href="./css/bootstrap.min.css" />
		<link rel="stylesheet" href="./css/style.css" />
		<script src="./js/jquery-1.12.0.min.js"></script>
		<script src="./js/script.js"></script>
	</head>
	<body>

<!--TOP-BAR-->
		<div id="top-bar">
			<!--
			<nav id="account-navigation">
				<a href="/ucet/">Přihlášení</a>
				<a href="/odhlaseni/">Registrace</a>
			</nav>-->
			<nav id="account-navigation">
				<a href="/ucet/">Účet</a>
				<a href="/odhlaseni/">Odhlášení</a>
			</nav>
			<nav id="language-navigation">
				<a href="/cs/" hreflang="cs" class="selected"><abbr lang="cs" title="Czech">cs</abbr></a>
				<a href="/en/" hreflang="en"><abbr lang="en" title="English">en</abbr></a>
			</nav>
		</div>

<!--HEADER-->
		<header id="main-header">
			<img src="./images/logo.png" alt="BRACES" />
		</header>

		<div id="wrapper">

<!--NAVIGATION-->
			<nav id="main-navigation">
				<a href="">Zájezdy</a>
				<a href="">Smlouvy</a>
				<a href="">Reporty</a>
				<a href="">Export na Web</a>
				<a href="">Rezervace</a>
					<a href="">Jízdenky</a>
					<a href="">Letenky</a>
					<a href="">Hotely</a>
				<a href="">Účetnictví</a>
				<a href="">Pojištění</a>
			</nav>

<!--MAIN-CONTENT-->
			<main>
				<!--HLAVNÍ OBSAH WEBU !!!!!!!!!!!!!!!!!!!!!-->
				<jsp:include page="${pageName}.jsp" flush="true"/>
			</main>
		</div>

<!--FOOTER-->
		<footer id="main-footer">
			&copy; 2016 BRACES | Scorpio
		</footer>
	</body>
</html>