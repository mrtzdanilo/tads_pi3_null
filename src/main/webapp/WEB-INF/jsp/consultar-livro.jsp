
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="utf-8" />
    <title>Consulta de Produto</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/ConsultarProduto.css" />
</head>

<body>
    <div class="area">
        <form class="quadro" class="form" autocomplete="off">

            <fieldset class="form">
                <legend> Consulta de Produto </legend>
            
            <div class="form1">

                <label for="Titulo">Titulo:</label>
                <input type="text" class="form-control" id="Titulo" name="titulo"><br><br>

                <label for="Autor">Autor:</label>
                <input type="text" class="form-control" id="Autor" name="autor"><br><br>

            </div>

            <div class="form2">
                
                <label for="Editora">Editora:</label>
                <input type="text" class="form-control" id="Editora" name="editora"><br><br>

                <label for="Categoria">Categoria:</label><br>
                <select name="categoria">  
                    <option value="0">Todas</option>
                    <c:forEach items="${categorias}" var="categoria">                                
                        <option value="${categoria.id}"> ${categoria.nome} </option>              
                    </c:forEach>                    
                </select><br><br>

            </div>

        <div class="pull-right"><br>
            <form>
            <input type="submit" value="Consultar">
            </form>
        </div>
               
            <fieldset>
                <legend> Resultado da Consulta </legend>
                    <table border="0" class="tabela">
                        <tr>
                            <th width="110">Titulo</th>
                            <th width="110">Autor</th>
                            <th width="110">Editora</th>
                            <th width="110">Edição</th>
                            <th width="110">ISBN</th>
                        </tr>
                            <c:forEach items="${listaLivros}" var="livro">                                
                                <tr>
                                    <td align="center"><a href="${pageContext.request.contextPath}/detalhe-livro?id=<c:out value="${livro.id}"/>"><c:out value="${livro.titulo}"/> <a/></td>
                                    <td align="center"><c:out value="${livro.autor}"/></td>
                                    <td align="center"><c:out value="${livro.editora}"/></td>
                                    <td align="center"><c:out value="${livro.edicao}"/></td>
                                    <td align="center"><c:out value="${livro.isbn}"/></td>
                                    
                                </tr>
                                 
                            </c:forEach>
                    </table>
            </fieldset>

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
