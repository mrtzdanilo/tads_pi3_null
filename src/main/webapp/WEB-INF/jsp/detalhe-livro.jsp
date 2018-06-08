<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="utf-8" />
    <title>Detalhe do Produto</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/DetalheLivro.css" />
</head>

<body>

<body>
  
  <form class="formAletarar" action="${pageContext.request.contextPath}/atualizar-livro"
                  method="post" >
	    <h1>Detalhe do Produto</h1>

    <div class="contentform">

	    <h2 align="center"> Identificação do Produto </h2>

	    	<div class="leftcontact">
			<div class="form-group">
			<p>Categoria <span>*</span></p>
				<select type="text" name="categoria" required="true" />
                                
				<c:forEach items="${categorias}" var="categoria">                                
                                    <option  value="${categoria.id}" <c:if test="${categoria.id==livro.categoria.id}">selected</c:if> > ${categoria.nome} </option>              
                                </c:forEach>
            	</select>
			</div>

			<div class="form-group">
			<p>Titulo<span>*</span></p>
			<input type="text" name="titulo" id="titulo" required="true" value="${livro.titulo}" />
       </div> 

            <div class="form-group">
            <p>Valor <span>*</span></p>
				<input type="number" name="valor" id="valor" required="true" value="${livro.valor}" />
			</div>

			<p>Descrição <span>*</span></p>
			<textarea name="descricao" required="true"> ${livro.descricao}</textarea>	

			<div class="form-group">
			<p>Número de Paginas <span>*</span></p>
				<input type="number" name="numeroPaginas" id="numpaginas" required="true" value="${livro.numeroPaginas}"/>
			</div>
	</div>

	<div class="rightcontact">

			<div class="form-group">
			<p>Idioma <span>*</span></p>
				<select type="text" name="idioma" required="true" />
                                        
                                <c:forEach items="${idiomas}" var="idiomaLivro">                                
                                    <option  <c:if test="${idiomaLivro==livro.idioma}">selected</c:if> > ${idiomaLivro} </option>                
                                </c:forEach>
                                
                                    
            	</select>
			</div>

			<div class="form-group">
			<p>Autor <span>*</span></p>
				<input type="text" name="autor" id="autor" required="true" value="${livro.autor}" />
			</div>	

			<div class="form-group">
			<p>Editora<span>*</span></p>	
				<input type="text" name="editora" id="editora" required="true" value="${livro.editora}" />
			</div> 

			<div class="form-group">
			<p>Edição <span>*</span></p>	
                <input type="number" name="edicao" id="edicao" required="true" value="${livro.edicao}" />
			</div>

			<div class="form-group">
			<p>ISBN<span>*</span></p>	
                <input type="number" name="isbn" id="isbn" required="true" value="${livro.isbn}" />
			</div>

	</div>
	</div>

<input type="hidden" name="id_livro" value="${livro.id}">
<button type="submit" class="botao-alterar">Alterar Dados</button>


</form>	
        <form class="botaoEstoque" action="${pageContext.request.contextPath}/estoque?"
          method="get">
            <input type="hidden" name="id" value="${livro.id}">
            <button type="submit" class="botao-estoque">Gerenciar Estoque</button>
        </form>
        <form class="botaoExcluir" action="${pageContext.request.contextPath}/excluir-livro"
          method="post">
            <input type="hidden" name="id_livro" value="${livro.id}">
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