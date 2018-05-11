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
  
  <form>
        <h1>Gerenciamento de Estoque</h1>
        
    <div class="contentform">

        <div>
            <div class="form-group">
            <p>Produto<span></span></p>
            <span class="icon-case"></span>
            <input type="text" name="produto" id="produto" required="true" />
       </div>

        <div class="tabela">
            <table>
              <tr>
                <th>Nome Fantasia</th>
                <th>Quantidade de Produto</th>
              </tr>
              <tr>
                <td> Matriz System of Null </td>
                <td><input class="estoque" type="number" name="quantidade"></td>
              </tr>
              <tr>
                <td> Filial 2 </td>
                <td><input class="estoque" type="number" name="quantidade"></td>
              </tr>
              <tr>
                <td> Filial 3 </td>
                <td><input class="estoque" type="number" name="quantidade"></td>
              </tr>
              <tr>
                <td> Filial 4 </td>
                <td><input class="estoque" type="number" name="quantidade"></td>
              </tr>
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