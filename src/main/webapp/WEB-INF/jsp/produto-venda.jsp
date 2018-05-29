<!DOCTYPE html>
<html lang="br" >

<head>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <meta charset="UTF-8">
  <title>Produto</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
  
      <link rel="stylesheet" href="./css/Venda.css">
  
</head>

<body>

<form class="steps" accept-charset="UTF-8" enctype="multipart/form-data" novalidate="">
  <ul id="progressbar">
    <li class="active">Cliente</li>
    <li class="active">Produto / Carrinho </li>
    <li>Confirmação</li>
  </ul>

  <h1> VENDA </h1>
  <fieldset>
    <h2 class="fs-title">Produto <i class="fa fa-book" style="font-size: 30px;"></i></h2>

        <div>
        
          <label>Titulo <a>*</a></label>

          <input name="titulo" required="required" type="text" data-rule-required="true" data-msg-required="Favor inserir Titulo do livro." >
          <span class="error1" style="display: none;">
              <i class="error-log fa fa-exclamation-triangle"></i>
          </span>
        </div>

<button type="submit" class="botao-consultar  ">Consultar</button>

    <div class="tabela">
      <table>
        <tr>
          <th>Selecionar</th>
          <th>Titulo</th>
          <th>Autor</th>
          <th>Editora</th>
          <th>Genêro</th>
          <th>Edição</th>
          <th>Estoque</th>
          <th>Valor</th>
          <th>Quantidade</th>

        </tr>
                
        <c:forEach items="${listaLivros}" var="livro">       
        <tr>
          <td><input style="width: 25px; height: 15px;" type="checkbox" name="selecionar"></td>  
          <td> ${livro.titulo} </td>
          <td> ${livro.autor} </td>
          <td> ${livro.editora} </td>
          <td> ${livro.categoria.nome} </td>
          <td> ${livro.edicao} </td>
          <td> ARRUMAR ESTOQUE </td>
          <td> ${livro.edicao}</td>
          <td><input class="estoque" type="number" name="quantidade" min="1" max="999"></td>
        </tr>
        </c:forEach>
      </table>
    </div>

    <h2 class="fs-titleCar"> Carrinho <i class="fa fa-shopping-cart" style="font-size: 30px;"></i></h2>
    <div class="tabela">
      <table>
        <tr>
          <th>Titulo</th>
          <th>Autor</th>
          <th>Editora</th>
          <th>ISBN</th>
          <th>Quantidade</th>
          <th>Valor</th>
          <th>Retirar</th>
        </tr>
        <tr>
          <td> System of Thrones </td>
          <td> System</td>
          <td> System Editors </td>
          <td> 000000000</td>
          <td> 99 </td>
          <td> R$ 99,99</td>
          <td><i class="fa fa-remove" style="font-size: 30px; color: red"></i></td>
        </tr>
      </table>
    </div>

<button type="submit" class="botao-cancelar">Cancelar Venda</button>
<button type="submit" class="botao-avancar">Avançar</button>

</fieldset>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js'></script>
<script src='https://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.js'></script>

<script  src="./js/Avisos.js"></script>

    </form>

</body>

</html>

