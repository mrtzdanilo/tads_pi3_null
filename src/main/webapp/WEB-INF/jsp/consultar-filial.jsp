<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Consulta de Filial</title>
    <link rel="stylesheet" type="text/css" media="screen" href="./css/ConsultarFilial.css" />
</head>

<body>
    <div class="area">
        <form class="quadro" class="form" autocomplete="off">

            <fieldset class="form">
                <legend> Consulta de Filial </legend>
            
            <div class="form1">

                <label for="Nome Fantasia">Nome Fantasia:</label>
                <input type="text" class="form-control" id="Nome Fantasia" name="Nome Fantasia"><br><br>

                <label for="Inscrição Estadual">Inscrição Estadual:</label>
                <input type="text" class="form-control" id="Inscrição Estadual" name="Inscrição Estadual"><br><br>

            </div>

            <div class="form2">
                
                <label for="CNPJ">CNPJ:</label>
                <input type="text" class="form-control" id="CNPJ" name="CNPJ"><br><br>

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
                            <th width="110">Nome Fantasia</th>
                            <th width="110">Inscrição Estadual</th>
                            <th width="110">CNPJ</th>
                            <th width="110">Telefone</th>
                            <th width="110">Email</th>
                        </tr>
                        <tr>
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
                <li><a class="button" id="home" href="Filial.html">Retornar</a></li>
            </ul>
    </div>

</body>
</html>
