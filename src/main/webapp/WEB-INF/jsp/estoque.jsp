<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="utf-8" />
    <title>Gerenciamento de Estoque</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/Estoque.css" />
</head>

<body>

<body>
  
  <form action="${pageContext.request.contextPath}/estoque?id=${livro.id}"
          method="post">
        <h1>Gerenciamento de Estoque</h1>
        
    <div class="contentform">

        <div>
            <p> ${livro.titulo} <span></span></p>
            
       </div>

        <div class="tabela">
            <table>
              <tr>
                <th>FILIAL</th>
                <th>QUANTIDADE DISPON�VEL</th>
              </tr>
                <c:forEach items="${listaLivroFilial}" var="livroFilial">  
                <tr>
                    <td> ${livroFilial.filial.nomeFantasia} </td>
                    <td><input class="estoque" type="number" name="${livroFilial.filial.id}"
                               value="${livroFilial.estoque}" required="true" min="0"></td>
                </tr>
                </c:forEach>
            </tr>
            </table>
        </div>

<div>
<button type="submit" class="botao-estoque"> Atualizar Estoque</button>
</div>

</form> 

  
</body>
</html>


    <div class="navbar">
        <a style="text-decoration: none" href="TelaPrincipal.html"><h1 class="title"></h1></a>
        
        <div class="menu">
            <ul>
                <li><a class="button" id="home" href="ConsultarProduto.html">Retornar</a></li>
            </ul>
    </div>

</body>
</html>