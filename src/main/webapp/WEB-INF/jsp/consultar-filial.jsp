<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="utf-8" />
    <title>Consulta de Filial</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/ConsultarFilial.css" />
</head>

<body>

<body>
  
  <form>
        <h1>Consulta de Filial</h1>
        
    <div class="contentform">

        <div>
            <div class="form-group">
            <p> Nome Fantasia <span>*</span></p>
            <span class="icon-case"></span>
            <input type="text" name="nomefantasia" id="nomefantasia" required="true" />
       </div> 

            <div class="form-group">
            <p>Inscri��o Estadual<span>*</span></p>
            <span class="icon-case"></span>
                <input type="text" name="insestadual" id="insestadual" required="true" />
            </div>

    <div class="rightcontact">

            <div class="form-group">
            <p>CNPJ<span>*</span></p>
            <span class="icon-case"></span>
                <input type="text" name="cnpj" id="cnpj" required="true" />
            </div>
    </div>

        <div class="tabela">
            <table>
                
            <tr>
                <th>Nome Fantasia</th>
                <th>Inscri��o Estadual</th>
                <th>CNPJ</th>
                <th>Telefone</th>
                <th>Email</th>
            </tr>
            
            <c:forEach items="${filial}" var="filial">
                
            <tr>
                <td> <a href="${pageContext.request.contextPath}/detalhe-filial?id=<c:out value="${livro.id}"/>"><c:out value="${livro.titulo}"/> <a/></td>
                <td value="${filial.inscricaoEstadual}">  </td>
                <td value="${filial.cnpj}"> </td>
                <td value="${filial.telefone}"> </td>
                <td value="${filial.email}"> </td>
            </tr>
            
            </c:forEach>
                
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