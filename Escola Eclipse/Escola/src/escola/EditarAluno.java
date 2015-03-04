package escola;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditarAluno
 */
@WebServlet("/EditarAluno")
public class EditarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarAluno() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try  {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastroAlunos</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"resources/styles/style.css\" type=\"text/css\"/>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div>");
            
            out.println("<div class=\"menu-holder\"> \n" +
"                <ul>\n" +
"                    <li>\n" +
"                        <a href=\"index.jsp \"  id=\"home-item\"><img src=\"resources/images/home.ico\" class=\"home-image\"></a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"CadastroAlunos\"  >Cadastro de Alunos</a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"CadastroResponsaveis\">Cadastro de Responsáveis</a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"EditarAluno\" class=\"menu-item-selected\">Editar Aluno</a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"EditarResponsavel\">Editar Responsável</a>\n" +
"                    </li>\n"
                    + "<li>\n" +
"                        <a href=\"index.jsp\" id=\"search-item\"><img src=\"resources/images/search-item.png\" class=\"search-image\"></a>\n" +
"                    </li>" +
"                </ul>\n" +
"            </div>");
            
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
