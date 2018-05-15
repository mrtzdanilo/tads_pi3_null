<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="utf-8" />
    <title>Cadastro de Usuario</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/CadastroUsuario.css" />
</head>

<body>

<body>
  
  <form>
	    <h1>Cadastro de Usuario</h1>
	    
    <div class="contentform">

	    <h2> Identificação do Usuario </h2>

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
			<p>Telefone <span>*</span></p>
			<span class="icon-case"></span>
				<input type="text" name="telefone" id="telefone" required="true" />
			</div>



	</div>

		    <h2 align="center" class="formatatit"> Setor </h2>

	<div class="rightcontact">	

			<div class="form-group">
			<p>Função <span>*</span></p>
			<span class="icon-case"></span>
				<select type="text" name="funcao" required="true" />
					<option value="Teste"> Teste </option>
            	</select>
			</div>

			<div class="form-group">
			<p>Admissão: <span>*</span></p>	
			<span class="icon-case"></span>
                <input type="date" name="dtAdmissao" id="admissao" required="true" />
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
