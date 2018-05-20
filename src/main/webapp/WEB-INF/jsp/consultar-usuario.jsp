<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <meta charset="utf-8" />
        <title>Consulta de Usuario</title>
        <link rel="stylesheet" type="text/css" media="screen" href="./css/ConsultarCliente.css" />
    </head>

    <body>

    <body>

        <form action="${pageContext.request.contextPath}/consultar-usuario"
              method="get">
            <h1>Consulta de Usuario</h1>

            <div class="contentform">

                <div>
                    <div class="form-group">
                        <p> Nome <span>*</span></p>
                        <input type="text" name="nome" id="nome"/>
                    </div> 

                    <div class="form-group">
                        <p>Sobrenome<span>*</span></p>
                        <input type="text" name="sobrenome" id="sobrenome" />
                    </div>

                    <div class="rightcontact">

                        <div class="form-group">
                            <p>Telefone<span>*</span></p>
                            <input type="text" name="telefone" id="telefone" />
                        </div>
                    </div>

                    <div class="tabela">
                        <fmt:setLocale value="pt-BR"></fmt:setLocale>
                            <table>
                                <tr>
                                    <th>Nome</th>
                                    <th>Sobrenome</th>
                                    <th>Sexo</th>
                                    <th>Funcao</th>
                                    <th>Data Admissao</th>
                                    <th>Telefone</th>
                                </tr>

                            <c:forEach items="${listUsuario}" var="usuario">

                                <tr>
                                    <td> ${usuario.nome} </td>
                                    <td> ${usuario.sobrenome} </td>
                                    <td> ${usuario.sexo} </td>
                                    <td> ${usuario.funcaoNome} </td>
                                    <td> 
                                        <fmt:formatDate value="${usuario.dtAdmissao}" type="date" dateStyle="short"></fmt:formatDate>
                                        </td>
                                        <td> ${usuario.telefone} </td>
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
