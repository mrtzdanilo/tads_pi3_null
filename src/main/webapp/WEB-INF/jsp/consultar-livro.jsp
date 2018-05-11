<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="utf-8" />
    <title>Consulta de Produto</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/ConsultarLivro.css" />
</head>

<body>

<body>
  
  <form>
        <h1>Consulta de Produto</h1>
        
    <div class="contentform">

        <div>
            <div class="form-group">
            <p> Titulo <span>*</span></p>
            <input type="text" name="titulo" id="titulo" />
       </div> 

            <div class="form-group">
            <p>Autor<span>*</span></p>
                <input type="text" name="autor" id="autor" />
            </div>

    <div class="rightcontact">

            <div class="form-group">
            <p>Editora<span>*</span></p>
                <input type="text" name="editora" id="editora"  />

            <div class="form-group">
            <p>Categoria<span>*</span></p>
                <select type="text" name="categoria" />
                    <option value="Selecione"> Selecione </option>
                    <option value="Terror"> Terror </option>
                    <option value="Ficção Cientifica"> Ficção Cientifica </option>
                    <option value="Ação"> Ação </option>
                    <option value="Drama"> Drama </option>
                    <option value="Biografias"> Biografias </option>
                </select>
            </div>
        </div>
    </div>

        <div class="tabela">
            <table>
              <tr>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Editora</th>
                <th>Categoria</th>
              </tr>
              <c:forEach items="${listaLivros}" var="livro">   
                <tr>
                  <td ><a href="${pageContext.request.contextPath}/detalhe-livro?id=<c:out value="${livro.id}"/>"><c:out value="${livro.titulo}"/> <a/></td>
                  <td> <c:out value="${livro.autor}"/> </td>
                  <td> <c:out value="${livro.editora}"/></td>
                  <td> <c:out value="${livro.categoria.nome}"/> </td>
                </tr>
              </c:forEach>
              
            </table>
        </div>

<div>
<button type="submit" class="botao-consultar">Consultar</button>
</div>

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