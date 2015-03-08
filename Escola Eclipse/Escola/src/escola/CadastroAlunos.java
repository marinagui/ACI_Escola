package escola;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CadastroAlunos
 */
@WebServlet("/CadastroAlunos")
public class CadastroAlunos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CadastroAlunos() {
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroAlunos</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"resources/styles/style.css\" type=\"text/css\"/>");
            out.println("<link rel=\"stylesheet\" href=\"resources/styles/style-cadastro-alunos.css\" type=\"text/css\"/>");
            out.println("<script src=\"resources/scripts/script-cadastro-alunos.js\"> </script");
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            
            out.println("<div class=\"menu-holder\"> \n" +
"                <ul>\n" +
"                    <li>\n" +
"                        <a href=\"index.jsp \"  id=\"home-item\"><img src=\"resources/images/home.ico\" class=\"home-image\"></a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"CadastroAlunos\" class=\"menu-item-selected\" >Cadastro de Alunos</a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"CadastroResponsaveis\">Cadastro de Responsáveis</a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"EditarAluno\">Editar Aluno</a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"EditarResponsavel\">Editar Responsável</a>\n" +
"                    </li>\n"
                   + "<li>\n" +
"                        <a href=\"index.jsp\" id=\"search-item\"><img src=\"resources/images/search-item.png\" class=\"search-image\"></a>\n" +
"                    </li>" +
"                </ul>\n" +
"            </div>");
            out.println("<div class='conteudo'");
            out.println("<form id='formulario' class='rounded' method='post' action=''>");
            out.println("<h2>Cadastro de Alunos</h2>");
            out.println("<div class='field'><label for='RA'>RA:</label><input type='text' class='input' name='ra' id='ra' maxlength='5'/><p class='hint'>Insira seu RA</p></div>");
            out.println("<div class='field'><label for='nomeAluno'>Nome do aluno:</label><input type='text' class='input' name='nomeAluno' id='nomeAluno' maxlength='50'/><p class='hint'>Nome completo</p></div>");
            out.println("<div class='field'><label for='emailAluno'>Email:</label><input type='text' class='input' name='emailAluno' id='emailAluno' maxlength='100'/><p class='hint'>Insira o seu email</p></div>");
            out.println("<div class='field'><label for='telefoneAluno'>Telefone/celular:</label><input type='text' class='input' name='telefoneAluno' id='telefoneAluno' maxlength='15'/><p class='hint'>Insira seu número de telefone fixo ou celular</p></div>");
            out.println("<div class='field'><label for='enderecoAluno'>Endereço:</label><input type='text' class='input' name='enderecoAluno' id='enderecoAluno' maxlength='100'/><p class='hint'>Insira seu endereço</p></div>");
            out.println("<div class='field'><label for='emailResp'>Email do Responsável:</label><input type='text' class='input' name='emailResp' id='emailResp' maxlength='100'/><p class='hint'>Insira o email de seu responsável</p></div>");
            out.println("<input type='submit' name='Submit'  class='submit' value='Submit' />");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }finally{
            out.close();
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
