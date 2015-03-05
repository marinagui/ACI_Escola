package escola;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banco_de_dados.BD;

/**
 * Servlet implementation class CadastroResponsaveis
 */
@WebServlet("/CadastroResponsaveis")
public class CadastroResponsaveis extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroResponsaveis() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try{
        	if(request.getParameter("nomeResp")!=null){
        		String nomeResp,telefoneResp,enderecoResp;
        		nomeResp = request.getParameter("nomeResp");
        		telefoneResp = request.getParameter("telefoneResp");
        		enderecoResp = request.getParameter("enderecoResp");
        		try{
	        		BD banco = new BD("com.microsoft.sqlserver.jdbc.SQLServerDriver",
	        				"jdbc:sqlserver://regulus:1433;databasename=BD13185",
	        				"BD13185", "GeorgeOrwell");
	        		banco.execComando("insert into ACI_Responsavel values('" + nomeResp + "','"+ telefoneResp+"','"
	        				+ enderecoResp +"')");
        		}catch(Exception e){
        			out.println(e.getMessage());
        		}
            	
            }else{
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
	"                        <a href=\"CadastroResponsaveis\" class=\"menu-item-selected\">Cadastro de Respons�veis</a>\n" +
	"                    </li>\n" +
	"                    <li>\n" +
	"                        <a href=\"EditarAluno\" >Editar Aluno</a>\n" +
	"                    </li>\n" +
	"                    <li>\n" +
	"                        <a href=\"EditarResponsavel\" >Editar Respons�vel</a>\n" +
	"                    </li>\n"
	                    + "<li>\n" +
	"                        <a href=\"index.jsp\" id=\"search-item\"><img src=\"resources/images/search-item.png\" class=\"search-image\"></a>\n" +
	"                    </li>" +
	"                </ul>\n" +
	"            </div>");
	            
	            out.println("</div>");
	            out.println("<div class='conteudo'>");
	            out.println("<form id='formulario' class='rounded' method='post' action='CadastroResponsaveis'>");
	            out.println("<h2>Cadastro de Respons�veis</h2>");
	            out.println("<div class='field'><label for='nomeResp'>Nome:</label><input type='text' class='input' name='nomeResp' id='nomeResp' maxlength='50'/><p class='hint'>Nome completo</p></div>");
	            out.println("<div class='field'><label for='telefoneResp'>Telefone/celular:</label><input type='text' class='input' name='telefoneResp' id='telefoneResp' maxlength='15'/><p class='hint'>Insira seu n�mero de telefone fixo ou celular</p></div>");
	            out.println("<div class='field'><label for='enderecoResp'>Endere�o:</label><input type='text' class='input' name='enderecoResp' id='enderecoResp' maxlength='100'/><p class='hint'>Insira seu endere�o</p></div>");
	            out.println("<input type='submit' name='Submit'  class='submit' title='Submit' />");
	            out.println("</form>");
	            out.println("</div>");
	            out.println("</body>");
	            out.println("</html>");
            }
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
