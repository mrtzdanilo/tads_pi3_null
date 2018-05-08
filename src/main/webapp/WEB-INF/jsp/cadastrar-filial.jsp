<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Cadastro de Filial</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/CadastroFilial.css" />
</head>

<body>
	<div class="area">
            <form class="quadro" class="form" autocomplete="off" 
                  action="${pageContext.request.contextPath}/cadastrar-filial" method="post">

			<fieldset>
				<legend> Cadastro de Filial </legend>
			
			<div class="form1">

				<label for="Nome Fantasia">Nome Fantasia:</label>
				<input type="text" class="form-control" id="Nome Fantasia" name="nome_fantasia"><br><br>
				
				<label for="CNPJ">CNPJ:</label>
				<input type="text" class="form-control" id="CNPJ" name="cnpj"><br><br>
				
				<label for="Email">Email:</label>
				<input type="text" class="form-control" id="Email" name="email"><br><br>

			</div>

			<div class="form2">


				<label for="Inscrição Estadual">Inscrição Estadual:</label>
				<input type="text" class="form-control" id="Inscrição Estadual" name="inscricao_estadual"><br><br>
				
				<label for="Telefone">Telefone:</label>
				<input type="text" class="form-control" id="Telefone" name="telefone"><br><br>
			
				<label for="Fax">Fax:</label>
				<input type="text" class="form-control" id="Fax" name="fax"><br><br>

			</div>

			</fieldset>

			<fieldset>
				<legend> Endereço </legend>

			<div class="form1">

				<label for="Rua">Rua:</label>
				<input type="text" class="form-control" id="Rua" name="rua"><br><br>
				
				<label for="Cidade">Cidade:</label>
				<input type="text" class="form-control" id="Cidade" name="cidade"><br><br>
				
				<label for="Numero">Numero:</label>
				<input type="text" class="form-control" id="Numero" name="numero"><br><br>

			</div>

			<div class="form2">


				<label for="Bairro">Bairro:</label>
				<input type="text" class="form-control" id="Bairro" name="bairro"><br><br>
				
				<label for="Estado">Estado:</label>
				<input type="text" class="form-control" id="Estado" name="estado"><br><br>
			
				<label for="CEP">CEP:</label>
				<input type="text" class="form-control" id="CEP" name="cep"><br><br>

			</div>


			<div class="pull-left"><br>
				<button type="submit" class="btn btn-primary" onclick="alert('Cadastro realizado com sucesso!'); return true">
     			<span class="glyphicon glyphicon-thumbs-up"></span>
     			Confirmar Cadastro
 				</button>
 			</div>

			<div class="pull-right"><br>
				<button type="reset" class="btn btn-primary" onclick="alert('Dados apagados com sucesso!'); return true">
     			<span class="glyphicon glyphicon-thumbs-up"></span>
     			Apagar Dados
 				</button>
 			</div>


			</fieldset>

		</form>
	</div>

    <div class="navbar">
        <a style="text-decoration: none" href="TelaPrincipal.html"><h1 class="title"></h1></a>
        
        <div class="menu">
            <ul>
                <li><a class="button" id="home" href="Filial.html">Retornar</a></li>
            </ul>
    </div>

</body>
</html>