<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Escola</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/styles/style.css" type="text/css"/>
        <link rel="stylesheet" href="resources/styles/style-index.css" type="text/css"/>
    </head>
    <body>
        <div>
            <div class="menu-holder"> 
                <ul>
                    <li>
                        <a href="index.jsp" class="menu-item-selected" id="home-item"><img src="resources/images/home.ico" class="home-image"></a>
                    </li>
                    <li>
                        <a href="CadastroAlunos" >Cadastro de Alunos</a>
                    </li>
                    <li>
                        <a href="CadastroResponsaveis">Cadastro de Responsáveis</a>
                    </li>
                    <li>
                        <a href="EditarAluno">Editar Aluno</a>
                    </li>
                    <li>
                        <a href="EditarResponsavel">Editar Responsável</a>
                    </li>
                    <li>
                    	<a href="Remover">Remover</a>
                    </li>
                    <li>
                        <a href="Busca" id="search-item"><img src="resources/images/search-item.png" class="search-image"></a>
                    </li>
                    
                </ul>
            </div>
            <div class="conteudo">
                <div class="descricao">
                <div class="desc"><h3>Exerício do uso de servlets em java WEB </h3></div>
                	<table>
                		<tr>
                			<th>Nomes</th>
                			<th>RA</th>
                		</tr>
                		<tr>
                			<td>João Vitor Araki Gonçalves</td>
                			<td>13176</td>
                		</tr>
                		<tr>
                			<td>Marina Guimarães</td>
                			<td>13185</td>
                		</tr>
                	</table>
                </div>
            </div>
        </div>
    </body>
</html>