<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Confirma��o</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
  
  
      <link rel="stylesheet" href="./css/Venda.css">

  
</head>

<body>

<form class="steps" accept-charset="UTF-8" enctype="multipart/form-data" novalidate="">
  <ul id="progressbar">
    <li class="active">Cliente</li>
    <li class="active">Produto / Carrinho </li>
    <li class="active">Confirma��o</li>
  </ul>

  <h1> VENDA </h1>
  <fieldset>
    <h2 class="fs-title">Confirma��o <i class="fa fa-check-circle" style="font-size: 30px; color: green"></i></h2>

</div>

    <div class="tabela">
      <table>
        <tr>
          <th>Produto</th>
          <th>Quantidade</th>
          <th>Valor Unit�rio</th>
          <th>Valor Total</th>

        </tr>
        <c:forEach items="${shopCart}" var="item">  
            <tr>
              <td> ${item.key.titulo} </td>
              <td> ${item.value}</td>
              <td> ${item.value} </td>
              <td> R$ 133,90 </td>
            </tr>
        </c:forEach>
      </table>
    </div>

<button type="submit" class="botao-cancelar">Cancelar Venda</button>
<button type="submit" class="botao-avancar">Confirmar Venda</button>

  </fieldset>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js'></script>
<script src='https://ajax.aspnetcdn.com/ajax/jquery.validate/1.13.1/jquery.validate.js'></script>

<script  src="./js/Avisos.js"></script>

    </form>

</body>

</html>

