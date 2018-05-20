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
            <input type="text" name="nome" id="nome" required="true" />
       </div> 

            <div class="form-group">
            <p>Sobrenome<span>*</span></p>
                <input type="text" name="sobrenome" id="sobrenome" required="true" />
            </div>

    <div class="rightcontact">

            <div class="form-group">
            <p>CPF<span>*</span></p>
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
              
              <c:forEach items="${listaCliente}" var="cliente">
                
                <tr>
                    <td> <a href="${pageContext.request.contextPath}/detalhe-cliente?id=<c:out value="${cliente.id}"/>"><c:out value="${cliente.nome}"/> <a/></td>
                    <td> ${cliente.sobrenome} </td>
                    <td> ${cliente.cpf} </td>
                </tr>
            
            </c:forEach>
                
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
