<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="utf-8" />
    <title>Consulta de Cliente</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/ConsultarCliente.css" />
</head>

<body>

<body>
  
  <form action="${pageContext.request.contextPath}/consultar-cliente"
                  method="post">
        <h1>Consulta de Cliente</h1>
        
    <div class="contentform">

        <div>
            <div class="form-group">
            <p> Nome <span>*</span></p>
            <span class="icon-case"></span>
            <input type="text" name="nome" id="nome" required="true" />
       </div> 

            <div class="form-group">
            <p>Sobrenome<span>*</span></p>
            <span class="icon-case"></span>
                <input type="text" name="sobrenome" id="sobrenome" required="true" />
            </div>

    <div class="rightcontact">

            <div class="form-group">
            <p>CPF<span>*</span></p>
            <span class="icon-case"></span>
                <input type="text" name="cpf" id="cpf" required="true" />
            </div>
    </div>

        <div class="tabela">
            <table>
              <tr>
                <th>Nome</th>
                <th>Sobrenome</th>
                <th>CPF</th>
              </tr>
              <tr>
                <td> System Null </td>
                <td> Null </td>
                <td> 000.000.000-00 </td>
              </tr>
              <tr>
                <td> System Null </td>
                <td> Null </td>
                <td> 000.000.000-00 </td>
              </tr>
            </tr>
            </table>
        </div>
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
