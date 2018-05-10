<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="utf-8" />
    <title>Cadastro de Produto</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/CadastroProduto.css" />
</head>

<body>
	<div class="area">
            <form class="quadro" class="form" autocomplete="off" 
                  action="${pageContext.request.contextPath}/cadastrar-livro"
                  method="post">

			<fieldset>
				<legend> Cadastro de Produto </legend>
                                
                                <c:if test="${not empty sessionScope.message}">
                                    ${sessionScope.message}
                                </c:if>     
			
			<div class="form1">

				<label for="Categoria">Categoria:</label><br>
                                <select name="categoria">
                                
                                <c:forEach items="${categorias}" var="categoria">                                
                                    <option value="${categoria.id}"> ${categoria.nome} </option>              
                                </c:forEach>
                                    
                                </select><br><br>
				
				<label for="titulo">Titulo:</label>
				<input type="text" class="form-control" id="Titulo" name="titulo"><br><br>
				
				<label for="Valor">Valor:</label>
				<input type="number" class="form-control" id="Valor" name="valor"><br><br>
				
				<label for="Descrição">Descrição:</label>
				<input type="text" class="form-control" id="Descrição" name="descricao"><br><br>
				
				<label for="idioma">Idioma:</label><br>
				<select name="idioma">
					<option value="Selecione"> Selecione </option>
					<option value="Portugues"> Portugues </option>
					<option value="Inglês"> Inglês </option>
					<option value="Espanhol"> Espanhol </option>
				</select>

			</div>

			<div class="form2">


				<label for="Autor">Autor:</label>
				<input type="text" class="form-control" id="Autor" name="autor"><br><br>
				
				<label for="Editora">Editora:</label>
				<input type="text" class="form-control" id="Editora" name="editora"><br><br>
			
				<label for="Edição">Edição:</label>
				<input type="text" class="form-control" id="Edição" name="edicao"><br><br>
			
				<label for="Número de Paginas">Número de Paginas:</label>
				<input type="text" class="form-control" id="numPag" name="numeroPaginas"><br><br>
				
				<label for="ISBN">ISBN:</label>
				<input type="text" class="form-control" id="ISBN" name="isbn"><br><br>

			</div>

			<div class="pull-left"><br><br>
				<button type="submit" class="btn btn-primary" onclick="alert('Cadastro realizado com sucesso!'); return true">
     			<span class="glyphicon glyphicon-thumbs-up"></span>
     			Confirmar Cadastro
 				</button>
 			</div>

			<div class="pull-right"><br><br>
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
                <li><a class="button" id="home" >Retornar</a></li>
            </ul>
    </div>
    
</body>
</html>
