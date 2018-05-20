<!DOCTYPE html>
<html lang="br" >

<head>
  <meta charset="UTF-8">
  <title>Cliente</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
  
  
      <link rel="stylesheet" href="./css/Venda.css">

  
</head>

<body>

<form class="steps" accept-charset="UTF-8" enctype="multipart/form-data" novalidate="">
  <ul id="progressbar">
    <li class="active">Cliente</li>
    <li>Produto / Carrinho </li>
    <li>Confirmação</li>
  </ul>

  <h1> VENDA </h1>
  <fieldset>
    <h2 class="fs-title">Cliente <i class="fa fa-user" style="font-size: 30px;"></i></h2>

        <div>
        
          <label>Cliente <a>*</a></label>

          <input name="nome" required="required" type="text" data-rule-required="true" data-msg-required="Favor inserir nome do cliente." >
          <span class="error1" style="display: none;">
              <i class="error-log fa fa-exclamation-triangle"></i>
          </span>
        </div>

        <div>
        
          <label>CPF <a>*</a></label>

          <input name="cpf" required="required" type="text" data-rule-required="true" data-msg-required="Favor inseir CPF do cliente." >
          <span class="error1" style="display: none;">
              <i class="error-log fa fa-exclamation-triangle"></i>
          </span>
        </div>

<button type="submit" class="botao-pesquisar">Pesquisar</button>
<button type="submit" class="botao-cadastrar">Cadastrar Cliente</button>

</div>

    <div class="tabela">
      <table>
        <tr>
          <th>Selecionar</th>
          <th>Cliente</th>
          <th>CPF</th>
        </tr>
        <tr>
          <td><input style="width: 25px; height: 15px;" type="radio" name="selecionar"></td>
          <td> System Null </td>
          <td> 000.000.000-00 </td>
        </tr>
        <tr>
          <td><input style="width: 25px; height: 15px;" type="radio" name="selecionar"></td> 
          <td> System Null </td>
          <td> 000.000.000-00 </td>
        </tr>
      </table>
    </div>
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

