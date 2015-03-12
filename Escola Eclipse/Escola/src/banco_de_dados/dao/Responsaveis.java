package banco_de_dados.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import banco_de_dados.BD;
import banco_de_dados.ConnectionData;
import banco_de_dados.dbo.Responsavel;

public class Responsaveis {
	private BD bancoConec;
	
	public Responsaveis()throws Exception{
		this.bancoConec = new BD(ConnectionData.DRIVER,
				ConnectionData.CONNECTION_STRING,
				ConnectionData.USER, ConnectionData.PASSWORD);
	}
	
	public void inserirResponsavel(Responsavel responsavel) throws Exception{
		ResultSet result = this.bancoConec.execConsulta("Select * from ACI_Responsavel where Email='"
	+responsavel.getEmail()+"'");
		if(result.first()){
			throw new Exception("Responsavel com esse email j� existente");
		}
		
		result.close();
		
		String comSQL = "insert into ACI_Responsavel values('"+
				responsavel.getEmail()+"','"+responsavel.getNome()+
				"','"+ responsavel.getTelefone()+"','"+responsavel.getEndereco() + "')";
		
		this.bancoConec.execComando(comSQL);
	}
	
	public void removerResponsavel(String emailResponsavel) throws Exception{
		ResultSet result = this.bancoConec.execConsulta("Select * from ACI_Responsavel where Email='"
				+emailResponsavel+"'");
		
		if(!result.first()){
			result.close();
			throw new Exception("Respons�vel com esse Email inexistente");
		}
		result.close();
		
		String comSql = "select * from ACI_Aluno where Responsavel='" + emailResponsavel + "'";
		result = this.bancoConec.execConsulta(comSql);
		
		if(result.first()){
			result.close();
			throw new Exception("Esse Respons�vel Possui Alunos Cadastrados, Delete Os Alunos Primeiro");
		}
		
		result.close();
		
		comSql = "delete from ACI_Responsavel where Email='"+emailResponsavel + "'";
		this.bancoConec.execComando(comSql);
	}
	
	public void editarResponsavel(Responsavel responsavel) throws Exception{
		ResultSet result = this.bancoConec.execConsulta("Select * from ACI_Responsavel where Email='"
				+responsavel.getEmail()+"'");
		if(!result.first()){
			throw new Exception("Responsavel com esse email j� inexistente");
		}
		
		result.close();
		
		String comSql = "update ACI_Responsavel set Nome='"+responsavel.getNome()+
				"', Telefone='" + responsavel.getTelefone() + "', Endereco='" + responsavel.getEndereco()
				+ "' where Email='"+ responsavel.getEmail() + "'";
		this.bancoConec.execComando(comSql);
	}
	
	public ResultSet getResponsaveis() throws Exception{
		ResultSet result = this.bancoConec.execConsulta("Select * from ACI_Responsavel");
		if(result.first()){
			result.beforeFirst();
			return result;
		}else{
			return null;
		}
	}
	
	public Responsavel getResponsavel(String email) throws Exception{
		ResultSet result = this.bancoConec.execConsulta("Select * from ACI_Responsavel where Email='"+email+"'");
		if(result.first()){
			Responsavel responsavel = new Responsavel(result.getString("Email"), result.getString("Nome"),result.getString("Telefone")
					,result.getString("Endereco"));
			return responsavel;
		}else{
			return null;
		}
	}
	
	public ArrayList<Responsavel> buscarResponsavel(String email, String nome, String telefone, String endereco) throws Exception{
		
		if ((email == null) && (nome == null) && (telefone == null) && (endereco == null))
			throw new Exception("Preencha pelo menos um dos campos para realizar a busca");
		
		String cmd = "";
		
		cmd += "select * from ACI_Responsavel where ";
		
		if (email != null) {
			cmd += "email like '%"+email+"%'";
			if ((nome != null) || (telefone != null) || (endereco != null))
				cmd += " and ";
		}
			
		if (nome != null) {
			cmd += "nome like '%"+nome+"%'";
			if ((telefone != null) || (endereco != null))
				cmd += " and ";
		}	

		if (telefone != null) {
			cmd += "telefone like '%"+telefone+"%'";
			if (endereco != null)
				cmd += " and ";
		}
		
		if (endereco != null)
			cmd += "endereco like '%"+endereco+"%'";
		
		ResultSet result = this.bancoConec.execConsulta(cmd);
		
		if (result.first()) {
			String rEmail, rNome, rTelefone, rEndereco;
				ArrayList<Responsavel> aResp = new ArrayList<Responsavel>();
				rEmail = result.getString("email");
				rNome = result.getString("nome");
				rTelefone = result.getString("telefone");
				rEndereco = result.getString("endereco");
				Responsavel r = new Responsavel(rEmail,rNome,rTelefone,rEndereco);
				aResp.add(r);
				
				while (result.next()) {
					rEmail = result.getString("email");
					rNome = result.getString("nome");
					rTelefone = result.getString("telefone");
					rEndereco = result.getString("endereco");
					Responsavel resp = new Responsavel(rEmail,rNome,rTelefone,rEndereco);
					aResp.add(resp);
				}
				
				return aResp;
		} else {
			throw new Exception("Nenhum resultado");
		}
	}
	
}
