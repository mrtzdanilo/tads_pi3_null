<%-- 
    Document   : cadastro livro
    Created on : 06/04/2018, 14:54:38
    Author     : Danilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
<head>
	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<title>Livros</title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width">

	<link rel="icon" href="imagens/favicon.png">
	<link rel="stylesheet" href="./site/reset.css">
	<link rel="stylesheet" href="./site/produto.css">
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Crimson+Text:400,400italic,600">
	<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:700">

</head>
<body class="fullheight">

	<div>


		<h1>Cadastro Livro</h1>

	</div>

	<main class="" style=" 
	padding-bottom: 0px;
	padding-top: 0px;
	height: 700px;
	">

	<form action="${pageContext.request.contextPath}/cadastrar-livro"
	    method="post">

		<div>
			<select class="aa" name="Categoria">
				<option value="Livros">Livros</option>
			</select>

		</div>	
		<div class="input-titulo">
			<label for = "input4" class="format, livro"> Titulo: </label>
                        <input type="text" id= "input4" name="titulo">	
		</div>

		<div class="input-autor">

			<label for = "input3" class="format, livro"> Autor: </label>
                        <input type="text" id= "input3" name="autor">
		</div>	
            
                <div class="input-autor">

			<label for = "input3" class="format, livro"> Numero de Páginas </label>
                        <input type="text" id= "input3" name="numeroPaginas">
		</div>	

		<div class="input-edit">

			<label for = "input2" class="format, livro"> Editora: </label>
                        <input type="text" id= "input2" name="editora">

		</div>

		<div class="input-isbn">

			<label for = "input1" class="format, livro"> ISBN: </label>
                        <input type="text" id= "input1" name="isbn">

		</div>

		<div class="input-edicao">
			<label for = "input5" class="format, livro"> Edição: </label>
			<input type="text" id= "input5" name="edicao">
		</div>

		<div class="format" style="">
			<table class="format">
				<div>

					<label id="genero" class="format, livro"> Gênero: </label>
					<select name="categoria">
						<option value="Masculino">Masculino</option>
						<option value="Feminino">Feminino</option>
						<option value="indefinido">Indefinido</option>
						<option value="LGBT">LGBT</option>
					</select>
				</div>

				<div>

					<label id="genero" class="format, livro"> Idioma: </label>
					<select name="idioma">
						<option value="Português-Br">Português-Br</option>
						<option value="Ingles">Inglês</option>
						<option value="outros">Outros</option>
					</select>
				</div>
			</table>
		</div>	

	</div>
	<div class="posi-bt">

		<input class="bt" type="submit" value="Pesquisar" />
		<input class="bt" type="reset" value="Cancelar" />
		<input class="bt" type="submit" value="Salvar" />
	</div>

	
</form>

</main>

<aside class="" style="
padding-bottom: 0px;
padding-top: 0px;
height: 90px;
background-position: 0px 0px;
">
<h1>Xgh Books</h1>
<nav>
	<ul>
		<li><a href="index.html">Home</a></li>
		<li><a href="contato.html">Contato</a></li>
	</ul>
</nav>
<ul>
	<li>
		<a href="https://github.com/joaodasilva">
			<img src="site/imagens/github.png" alt="Github">
		</a>
	</li>
	<li>
		<a href="https://twitter.com/joaodasilva">
			<img src="site/imagens/twitter.png" alt="Twitter">
		</a>
	</li>
	<li>
		<a href="https://br.linkedin.com/pub/joão-da-silva/32/4/508">
			<img src="site/imagens/linkedin.png" alt="LinkedIn">
		</a>
	</li>
</ul>

<footer>
	&copy; Null - 2018
</footer>
</body>
</html>
