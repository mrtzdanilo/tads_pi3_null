<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="utf-8" />
    <title>Cadastro de Cliente</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/CadastroCliente.css" />
</head>

<body>

<body>
  
  <form>
	    <h1>Cadastro de Cliente</h1>
	    
    <div class="contentform">

	    <h2> Identificação do Cliente </h2>

    	<div class="leftcontact">
			<div class="form-group">
			<p>Nome<span>*</span></p>
			<span class="icon-case"></span>
			<input type="text" name="nome" id="nome" required="true" />
       </div> 

            <div class="form-group">
            <p>Sobrenome <span>*</span></p>
            <span class="icon-case"></span>
				<input type="text" name="sobrenome" id="sobrenome" required="true" />
			</div>

			<div class="form-group">
			<p>Sexo <span>*</span></p>
			<span class="icon-case"></span>
				<select type="text" name="sexo" required="true" />
				<option value="Selecione"> Selecione </option>
				<option value="Masculino"> Masculino </option>
				<option value="Feminino"> Feminino </option>
            	</select>
			</div>

			<div class="form-group">
			<p>CPF <span>*</span></p>
			<span class="icon-case"></span>
				<input type="text" name="cpf" id="cpf" required="true" />
			</div>

			<div class="form-group">
			<p>RG <span></span></p>
			<span class="icon-case"></span>
				<input type="text" name="rg" id="rg"/>
			</div>

			<div class="form-group">
			<p>Data de Nascimento<span>*</span></p>
			<span class="icon-case"></span>
				<input type="text" name="datanascimento" id="datanascimento" required="true" />
			</div>


	</div>

		    <h2 align="center" class="formatatit"> Endereço </h2>

	<div class="rightcontact">	

			<div class="form-group">
			<p>Rua <span>*</span></p>
			<span class="icon-case"></span>
				<input type="text" name="rua" id="rua" required="true" />
			</div>	

			<div class="form-group">
			<p>Número: <span>*</span></p>	
			<span class="icon-case"></span>
				<input type="text" name="numero" id="numero" required="true" />
			</div> 

			<div class="form-group">
			<p>Complemento: <span></span></p>	
			<span class="icon-case"></span>
                <input type="text" name="complemento" id="complemento"/>
			</div>

			<div class="form-group">
			<p>Bairro: <span>*</span></p>	
			<span class="icon-case"></span>
                <input type="text" name="bairro" id="bairro" required="true" />
			</div>

			<div class="form-group">
			<p>Cidade: <span>*</span></p>	
			<span class="icon-case"></span>
                <input type="text" name="cidade" id="cidade" required="true" />
			</div>

			<div class="form-group">
			<p>CEP: <span>*</span></p>	
			<span class="icon-case"></span>
                <input type="text" name="cep" id="cep" required="true" />
			</div>
	</div>
	</div>

<button type="submit" class="botao-cadastrar">Cadastrar</button>
<button type="reset" class="botao-apagar">Limpar</button>

</form>	

  
</body>
</html>


    <div class="navbar">
        <a style="text-decoration: none" href="TelaPrincipal.html"><h1 class="title"></h1></a>
        
        <div class="menu">
            <ul>
                <li><a class="button" id="home" href="TelaPrincipal.html">Retornar</a></li>
            </ul>
    </div>

</body>
</html>