<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Cadastro de Filial</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/CadastrarFilial.css" />
</head>

<body>

<body>
  
  <form action="${pageContext.request.contextPath}/cadastrar-filial"
                  method="post">
	    <h1>Cadastro de Filial</h1>

    <div class="contentform">

	    <h2> Identifica��o da Filial </h2>

    	<div class="leftcontact">
			<div class="form-group">
			<p>Nome Fantasia<span>*</span></p>
			<input type="text" name="nomeFantasia" id="nomefantasia" required="true" />
       </div> 

            <div class="form-group">
            <p>CNPJ <span>*</span></p>
				<input type="text" name="cnpj" id="cnpj" required="true" />
			</div>

			<div class="form-group">
			<p>Email <span>*</span></p>
				<input type="email" name="email" id="email" required="true" />
			</div>	

			<div class="form-group">
			<p>Inscri��o Estadual <span>*</span></p>
				<input type="text" name="inscricaoEstadual" id="insestadual" required="true" />
			</div>

			<div class="form-group">
			<p>Telefone <span>*</span></p>
				<input type="text" name="telefone" id="telefone" required="true" />
			</div>

			<div class="form-group">
			<p>Fax <span></span></p>
				<input type="text" name="fax" id="fax"/>
			</div>

	</div>

		    <h2 align="center" class="formatatit"> Endere�o </h2>

	<div class="rightcontact">

			<div class="form-group">
			<p>Rua <span>*</span></p>
				<input type="text" name="rua" id="rua" required="true" />
			</div>	

			<div class="form-group">
			<p>Cidade<span>*</span></p>	
				<input type="text" name="cidade" id="cidade" required="true" />
			</div> 

			<div class="form-group">
			<p>N�mero <span>*</span></p>	
                <input type="text" name="numero" id="numero" required="true" />
			</div>

			<div class="form-group">
			<p>Bairro<span>*</span></p>	
                <input type="text" name="bairro" id="bairro" required="true" />
			</div>

			<div class="form-group">
			<p>Estado <span>*</span></p>
				<select type="text" name="estado" required="true" />
					<option value="Selecione"> Selecione</option>
					<option value="AC">Acre</option>
					<option value="AL">Alagoas</option>
					<option value="AP">Amap�</option>
					<option value="AM">Amazonas</option>
					<option value="BA">Bahia</option>
					<option value="CE">Cear�</option>
					<option value="DF">Distrito Federal</option>
					<option value="ES">Esp�rito Santo</option>
					<option value="GO">Goi�s</option>
					<option value="MA">Maranh�o</option>
					<option value="MT">Mato Grosso</option>
					<option value="MS">Mato Grosso do Sul</option>
					<option value="MG">Minas Gerais</option>
					<option value="PA">Par�</option>
					<option value="PB">Para�ba</option>
					<option value="PR">Paran�</option>
					<option value="PE">Pernambuco</option>
					<option value="PI">Piau�</option>
					<option value="RJ">Rio de Janeiro</option>
					<option value="RN">Rio Grande do Norte</option>
					<option value="RS">Rio Grande do Sul</option>
					<option value="RO">Rond�nia</option>
					<option value="RR">Roraima</option>
					<option value="SC">Santa Catarina</option>
					<option value="SP">S�o Paulo</option>
					<option value="SE">Sergipe</option>
					<option value="TO">Tocantins</option>
            	</select>
			</div>


			<div class="form-group">
			<p>CEP<span>*</span></p>	
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