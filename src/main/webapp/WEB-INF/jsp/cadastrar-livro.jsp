<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="utf-8" />
    <title>Cadastro de Produto</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/CadastrarLivro.css" />
</head>

<body>

<body>
  
  <form action="${pageContext.request.contextPath}/cadastrar-livro"
                  method="post">
	    <h1>Cadastro de Produto</h1>

    <div class="contentform">

	    <h2 align="center"> Identificação do Produto </h2>

	    	<div class="leftcontact">
			<div class="form-group">
			<p>Categoria <span>*</span></p>
			<span class="icon-case"></span>
                            <select type="text" name="categoria" required="true" />
                                <c:forEach items="${categorias}" var="categoria">                                
                                    <option value="${categoria.id}"> ${categoria.nome} </option>              
                                </c:forEach>
                            </select>
			</div>

			<div class="form-group">
			<p>Titulo<span>*</span></p>
			<span class="icon-case"></span>
			<input type="text" name="titulo" id="titulo" required="true" />
       </div> 

            <div class="form-group">
            <p>Valor <span>*</span></p>
            <span class="icon-case"></span>
				<input type="number" name="valor" id="valor" required="true" />
			</div>

			<p>Descrição <span>*</span></p>
			<span class="icon-casedesc"></span>
			<textarea name="descricao" required="true"> </textarea>	

			<div class="form-group">
			<p>Número de Paginas <span>*</span></p>
			<span class="icon-case"></span>
				<input type="number" name="numeroPaginas" id="numpaginas" required="true" />
			</div>
	</div>

	<div class="rightcontact">

			<div class="form-group">
			<p>Idioma <span>*</span></p>
			<span class="icon-case"></span>
				<select type="text" name="idioma" required="true" />
					<option value="Selecione"> Selecione </option>
					<option value="Portugues"> Portugues </option>
					<option value="Inglês"> Inglês </option>
					<option value="Espanhol"> Espanhol </option>
            	</select>
			</div>

			<div class="form-group">
			<p>Autor <span>*</span></p>
			<span class="icon-case"></span>
				<input type="text" name="autor" id="autor" required="true" />
			</div>	

			<div class="form-group">
			<p>Editora<span>*</span></p>	
			<span class="icon-case"></span>
				<input type="text" name="editora" id="editora" required="true" />
			</div> 

			<div class="form-group">
			<p>Edição <span>*</span></p>	
			<span class="icon-case"></span>
                <input type="number" name="edicao" id="edicao" required="true" />
			</div>

			<div class="form-group">
			<p>ISBN<span>*</span></p>	
			<span class="icon-case"></span>
                <input type="number" name="isbn" id="isbn" required="true" />
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


