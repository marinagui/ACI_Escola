package banco_de_dados.dao;

import banco_de_dados.BD;
import banco_de_dados.dbo.Aluno;

public class Alunos {
	
	BD bancoConec;
	
	public Alunos()throws Exception{
		this.bancoConec = new BD("com.microsoft.sqlserver.jdbc.SQLServerDriver",
    			"jdbc:sqlserver://regulus:1433;databasename=BD13185",
    			"BD13185", "GeorgeOrwell");
	}
	
	public void incluirAluno(Aluno aluno){
	}
}
