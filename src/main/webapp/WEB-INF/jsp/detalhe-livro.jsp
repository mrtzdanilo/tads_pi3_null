<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="utf-8" />
    <title>Detalhe do Produto</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/DetalheLivro.css" />
</head>

<body>
	<div class="area">
            
                <form class="quadro" class="form" autocomplete="off" 
                  action="${pageContext.request.contextPath}/atualizar-livro"
                  method="post" id="form_livro">

			<fieldset>
				<legend> Detalhe do Produto </legend>
                                
                                <c:if test="${not empty sessionScope.message}">
                                    ${sessionScope.message}
                                </c:if>   
			
			<div class="form1">

				<label for="Categoria">Categoria:</label><br>
                                <select name="categoria">
                                
                                <c:forEach items="${categorias}" var="categoria">                                
                                    <option value="${categoria.id}" <c:if test="${categoria.id==livro.categoria.id}">selected</c:if> > ${categoria.nome} </option>              
                                </c:forEach>
                                    
                                </select><br><br>

				<label for="Titulo">Titulo:</label>
				<input type="text" class="form-control" id="Titulo" name="titulo" value="${livro.titulo}"><br><br>
				
				<label for="Valor">Valor:</label>
                                <input type="text" class="form-control" id="Valor" name="valor" value="${livro.valor}"><br><br>
				
				<label for="Descrição">Descrição:</label>
				<input type="text" class="form-control" id="Descrição" name="descricao" value="${livro.descricao}"><br><br>
				
				<label for="idioma">Idioma:</label><br>
				<select name="idioma">
					<option value="idioma"> Selecione </option>
					<option value="idioma"> Portugues </option>
					<option value="idioma"> Inglês </option>
					<option value="idioma"> Espanhol </option>
				</select>
                                
                                <input type="hidden" name="id_livro" value="${livro.id}">

			</div>

			<div class="form2">


				<label for="Autor">Autor:</label>
                                <input type="text" class="form-control" id="Autor" name="autor" value="${livro.autor}"><br><br>
				
				<label for="Editora">Editora:</label>
				<input type="text" class="form-control" id="Editora" name="editora" value="${livro.editora}"><br><br>
			
				<label for="Edição">Edição:</label>
				<input type="text" class="form-control" id="Edição" name="edicao" value="${livro.edicao}"><br><br>
			
				<label for="Número de Paginas">Número de Paginas:</label>
				<input type="text" class="form-control" id="numPag" name="numeroPaginas" value="${livro.numeroPaginas}"><br><br>
				
				<label for="ISBN">ISBN:</label>
				<input type="text" class="form-control" id="ISBN" name="isbn" value="${livro.isbn}"><br><br>

			</div>
			</fieldset>
                                
                        <div class="pull-right"><br><br>
                            <button type="submit" form="form_livro">ALTERAR DADOS</button>
 			</div>

		</form>
                                
                                
                                
                <form class="form" autocomplete="off" 
                  action="${pageContext.request.contextPath}/excluir-livro"
                  method="post">
                    
                    <input type="hidden" name="id_livro" value="${livro.id}">
                    
                    <button type="submit">DELETE 2</button>
                    
                </form>
	</div>

    <div class="navbar">
        <a style="text-decoration: none" href="TelaPrincipal.html"><h1 class="title"></h1></a>
        
        <div class="menu">
            <ul>
                <li><a class="button" id="home" href="Produto.html">Retornar</a></li>
            </ul>
    </div>

</body>
</html>