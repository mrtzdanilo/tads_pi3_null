<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="utf-8" />
    <title>Detalhes da Filial</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/DetalheFilial.css" />
</head>

<body>

<body>
  
  <form action="${pageContext.request.contextPath}/atualizar-filial"
                  method="post" >
	    <h1>Detalhes da Filial</h1>

    <div class="contentform">

	    <h2> Identificação da Filial </h2>

    	<div class="leftcontact">
			<div class="form-group">
			<p>Nome Fantasia<span>*</span></p>
			<span class="icon-case"></span>
			<input type="text" name="nomeFantasia" id="nomefantasia" required="true" value="${filial.nomeFantasia}" />
       </div> 

            <div class="form-group">
            <p>CNPJ <span>*</span></p>
            <span class="icon-case"></span>
				<input type="text" name="cnpj" id="cnpj" required="true" value="${filial.cnpj}" />
			</div>

			<div class="form-group">
			<p>Email <span>*</span></p>
			<span class="icon-case"></span>
				<input type="email" name="email" id="email" required="true" value="${filial.email}" />
			</div>	

			<div class="form-group">
			<p>Inscrição Estadual <span>*</span></p>
			<span class="icon-case"></span>
				<input type="text" name="inscricaoEstadual" id="insestadual" required="true" value="${filial.inscricaoEstadual}" />
			</div>

			<div class="form-group">
			<p>Telefone <span>*</span></p>
			<span class="icon-case"></span>
				<input type="text" name="telefone" id="telefone" required="true" value="${filial.telefone}" />
			</div>

			<div class="form-group">
			<p>Fax <span></span></p>
			<span class="icon-case"></span>
				<input type="text" name="fax" id="fax" value="${filial.fax}"/>
			</div>

	</div>

		    <h2 align="center" class="formatatit"> Endereço </h2>

	<div class="rightcontact">

			<div class="form-group">
			<p>Rua <span>*</span></p>
			<span class="icon-case"></span>
				<input type="text" name="rua" id="rua" required="true" value="${endereco.rua}"/>
			</div>	

			<div class="form-group">
			<p>Cidade<span>*</span></p>	
			<span class="icon-case"></span>
				<input type="text" name="cidade" id="cidade" required="true" value="${endereco.cidade}" />
			</div> 

			<div class="form-group">
			<p>Número <span>*</span></p>	
			<span class="icon-case"></span>
                <input type="text" name="numero" id="numero" required="true" value="${endereco.numero}" />
			</div>

			<div class="form-group">
			<p>Bairro<span>*</span></p>	
			<span class="icon-case"></span>
                <input type="text" name="bairro" id="bairro" required="true" value="${endereco.bairro}" />
			</div>


			<div class="form-group">
			<p>CEP<span>*</span></p>	
			<span class="icon-case"></span>
                <input type="text" name="cep" id="cep" required="true" value="${endereco.cep}" />
			</div>

			<div class="form-group">
			<p>Estado <span>*</span></p>
			<span class="icon-case"></span> 
				<select type="text" name="estado" required="true" />
					<option value="Selecione"> Selecione</option>
					<option value="AC">Acre</option>
					<option value="AL">Alagoas</option>
					<option value="AP">Amapá</option>
					<option value="AM">Amazonas</option>
					<option value="BA">Bahia</option>
					<option value="CE">Ceará</option>
					<option value="DF">Distrito Federal</option>
					<option value="ES">Espírito Santo</option>
					<option value="GO">Goiás</option>
					<option value="MA">Maranhão</option>
					<option value="MT">Mato Grosso</option>
					<option value="MS">Mato Grosso do Sul</option>
					<option value="MG">Minas Gerais</option>
					<option value="PA">Pará</option>
					<option value="PB">Paraíba</option>
					<option value="PR">Paraná</option>
					<option value="PE">Pernambuco</option>
					<option value="PI">Piauí</option>
					<option value="RJ">Rio de Janeiro</option>
					<option value="RN">Rio Grande do Norte</option>
					<option value="RS">Rio Grande do Sul</option>
					<option value="RO">Rondônia</option>
					<option value="RR">Roraima</option>
					<option value="SC">Santa Catarina</option>
					<option value="SP">São Paulo</option>
					<option value="SE">Sergipe</option>
					<option value="TO">Tocantins</option>
            	</select>
			</div>

	</div>
	</div>

<button type="submit" class="botao-alterar">Alterar Dados</button>
<button type="submit" class="botao-excluir">Excluir Cadastro</button>

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