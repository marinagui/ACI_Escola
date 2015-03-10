package escola;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import banco_de_dados.dao.Alunos;
import banco_de_dados.dbo.Aluno;

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
        	out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Edição de Alunos</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"resources/styles/style.css\" type=\"text/css\"/>");
            out.println("<link rel=\"stylesheet\" href=\"resources/styles/style-cadastro-alunos.css\" type=\"text/css\"/>");
	        out.println("<script src='resources/scripts/jquery.js'> </script>");
	        out.println("<script src='resources/scripts/script-mascara.js'> </script>");           
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
"                        <a href=\"CadastroAlunos\" >Cadastro de Alunos</a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"CadastroResponsaveis\">Cadastro de Responsáveis</a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"EditarAluno\" class=\"menu-item-selected\" >Editar Aluno</a>\n" +
"                    </li>\n" +
"                    <li>\n" +
"                        <a href=\"EditarResponsavel\">Editar Responsável</a>\n" +
"                    </li>\n"+"<li>"+
						"<a href='Remover'>Remover</a>"+
					"</li>"
                   + "<li>\n" +
"                        <a href=\"Busca\" id=\"search-item\"><img src=\"resources/images/search-item.png\" class=\"search-image\"></a>\n" +
"                    </li>" +
"                </ul>\n" +
"            </div>");
            out.println("<div class='conteudo'>");
            out.println("<form id='formulario' class='rounded' method='post' action='EditarAluno' onsubmit='return validaAluno(this)'>");
            out.println("<h2>Edição de Alunos</h2>");
            if(request.getParameter("ra") != null){
            	if(request.getParameter("nomeAluno") != null){
            		String ra, nomeAluno,emailAluno,telefoneAluno,enderecoAluno,emailResp;
                	ra = request.getParameter("ra");
                	nomeAluno = request.getParameter("nomeAluno");
                	emailAluno = request.getParameter("emailAluno");
                	telefoneAluno = request.getParameter("telefoneAluno");
                	enderecoAluno = request.getParameter("enderecoAluno");
                	emailResp = request.getParameter("emailResp");
                	telefoneAluno = telefoneAluno.replace("(", "");
                	telefoneAluno = telefoneAluno.replace(")", "");
                	telefoneAluno = telefoneAluno.replace("-", "");
                	
                	try{
                		Alunos alunos = new Alunos();
                		Aluno alunoParaEditar = new Aluno(ra,nomeAluno,emailAluno,telefoneAluno,enderecoAluno,emailResp);
                		alunos.editarAluno(alunoParaEditar);
                		out.println("<div class='mensagem'>O Aluno Foi Editado Com Sucesso</div>");
    		        	out.println("<input type='submit' name='Submit'  class='submit' title='Submit' value='Voltar'/>");
                	}catch(Exception e){
                		out.println("<div class='mensagem'>"+e.getMessage()+"</div>");
                        out.println("<div class='field' style='display:none;'><label for='RA'>RA:</label><input type='text' class='input ra'"+" value='"+ra+"' " +"name='ra' id='ra' maxlength='5'/><p class='hint'>Insira seu RA</p></div>");
                        out.println("<div class='field'><label for='nomeAluno'>Nome do aluno:</label><input type='text' class='input'"+" value='"+nomeAluno+"' " +" name='nomeAluno' id='nomeAluno' maxlength='50'/><p class='hint'>Nome completo</p></div>");
                        out.println("<div class='field'><label for='emailAluno'>Email:</label><input type='text' class='input'"+" value='"+emailAluno+"' " +" name='emailAluno' id='emailAluno' maxlength='100'/><p class='hint'>Insira o seu email</p></div>");
                        out.println("<div class='field'><label for='telefoneAluno'>Telefone/celular:</label><input type='text' class='input telefone'"+" value='"+telefoneAluno+"' " +" name='telefoneAluno' id='telefoneAluno' maxlength='15'/><p class='hint'>Insira seu número de telefone fixo ou celular</p></div>");
                        out.println("<div class='field'><label for='enderecoAluno'>Endereço:</label><input type='text' class='input' "+" value='"+enderecoAluno+"' " +"name='enderecoAluno' id='enderecoAluno' maxlength='100'/><p class='hint'>Insira seu endereço</p></div>");
                        out.println("<div class='field'><label for='emailResp'>Email do Responsável:</label><input type='text' class='input'"+" value='"+emailResp+"' " +" name='emailResp' id='emailResp' maxlength='100'/><p class='hint'>Insira o email de seu responsável</p></div>");
                        out.println("<input type='submit' name='Submit'  class='submit' value='Editar Aluno' />");
                        out.println("<input type='button' name='Submit'  class='submit' value='Voltar' onclick=\"window.location.replace('EditarAluno');\"/>");
                	}
            	}else{
            		Alunos alunos;
            		try{
            			alunos = new Alunos();
            			Aluno alunoParaEdicao = alunos.getAluno(request.getParameter("ra"));
            			if(alunoParaEdicao!= null){
                            out.println("<div class='field' style='display:none;'><label for='RA'>RA:</label><input type='text' class='input ra'"+" value='"+alunoParaEdicao.getRA()+"' " +"name='ra' id='ra' maxlength='5'/><p class='hint'>Insira seu RA</p></div>");
                            out.println("<div class='field'><label for='nomeAluno'>Nome do aluno:</label><input type='text' class='input'"+" value='"+alunoParaEdicao.getNome()+"' " +" name='nomeAluno' id='nomeAluno' maxlength='50'/><p class='hint'>Nome completo</p></div>");
                            out.println("<div class='field'><label for='emailAluno'>Email:</label><input type='text' class='input'"+" value='"+alunoParaEdicao.getEmail()+"' " +" name='emailAluno' id='emailAluno' maxlength='100'/><p class='hint'>Insira o seu email</p></div>");
                            out.println("<div class='field'><label for='telefoneAluno'>Telefone/celular:</label><input type='text' class='input telefone'"+" value='"+alunoParaEdicao.getTelefone()+"' " +" name='telefoneAluno' id='telefoneAluno' maxlength='15'/><p class='hint'>Insira seu número de telefone fixo ou celular</p></div>");
                            out.println("<div class='field'><label for='enderecoAluno'>Endereço:</label><input type='text' class='input' "+" value='"+alunoParaEdicao.getEndereco()+"' " +"name='enderecoAluno' id='enderecoAluno' maxlength='100'/><p class='hint'>Insira seu endereço</p></div>");
                            out.println("<div class='field'><label for='emailResp'>Email do Responsável:</label><input type='text' class='input'"+" value='"+alunoParaEdicao.getResponsavel()+"' " +" name='emailResp' id='emailResp' maxlength='100'/><p class='hint'>Insira o email de seu responsável</p></div>");
                            out.println("<input type='submit' name='Submit'  class='submit' value='Editar Aluno' />");
                            out.println("<input type='button' name='Submit'  class='submit' value='Voltar' onclick=\"window.location.replace('EditarAluno');\"/>");
            			}else{
            				out.println("<div class='mensagem'>RA Não Encontrado</div>");
            				out.println("<div class='field'><label for='RA'>RA:</label><input type='text' class='input ra' name='ra' id='ra' maxlength='5'/><p class='hint'>Insira seu RA</p></div>");
            	            out.println("<input type='submit' name='Submit'  class='submit' value='Buscar RA' />");
            			}
            		}catch(Exception e){
            			out.println("<div class='mensagem'>"+e.getMessage()+"</div>");
            		}
            	}
            	
            }else{
	            out.println("<div class='field'><label for='RA'>RA:</label><input type='text' class='input ra' name='ra' id='ra' maxlength='5'/><p class='hint'>Insira seu RA</p></div>");
	            out.println("<input type='submit' name='Submit'  class='submit' value='Buscar RA' />");
            }
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
