
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Consulta de Produto</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/ConsultarProduto.css" />
</head>

<body>
    <div class="area">
        <form class="quadro" class="form" autocomplete="off">

            <fieldset class="form">
                <legend> Consulta de Produto </legend>
            
            <div class="form1">

                <label for="Titulo">Titulo:</label>
                <input type="text" class="form-control" id="Titulo" name="titulo"><br><br>

                <label for="Autor">Autor:</label>
                <input type="text" class="form-control" id="Autor" name="autor"><br><br>

            </div>

            <div class="form2">
                
                <label for="Editora">Editora:</label>
                <input type="text" class="form-control" id="Editora" name="editora"><br><br>

                <label for="Categoria">Categoria:</label>
                <select name="categoria">
                    <option value="Selecione"> Selecione </option>
                    <option value="Terror"> Terror </option>
                    <option value="Ficção Cientifica"> Ficção Cientifica </option>
                    <option value="Ação"> Ação </option>
                    <option value="Drama"> Drama </option>
                    <option value="Biografias"> Biografias </option>
                </select>

            </div>

        <div class="pull-right"><br>
            <form>
            <input type="submit" value="Consultar">
            </form>
        </div>

            <fieldset>
                <legend> Resultado da Consulta </legend>
                    <table border="0" class="tabela">
                        <tr>
                            <th width="110">Titulo</th>
                            <th width="110">Autor</th>
                            <th width="110">Editora</th>
                            <th width="110">Edição</th>
                            <th width="110">ISBN</th>
                            <th width="110">Categoria</th>
                        </tr>
                        <tr>
                            <td align="center">teste</td>
                            <td align="center">teste</td>
                            <td align="center">teste</td>
                            <td align="center">teste</td>
                            <td align="center">teste</td>
                            <td align="center">teste</td>
                        </tr>
                    </table>
            </fieldset>


        </form>
    </div>

    <div class="navbar">
        <a style="text-decoration: none" href="TelaPrincipal.html"><h1 class="title"></h1></a>
        
        <div class="menu">
            <ul>
                <li><a class="button" id="home" href="Produto.html">Retornar</a></li>
            </ul>
    </div>

</body>
</html>
