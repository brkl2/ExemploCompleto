package br.com.ctup.controller;

import java.io.IOException;
import java.util.List;

import javax.faces.context.FacesContext;

import br.com.ctup.DAO.PessoaDao;
import br.com.ctup.DAO.PessoaDaoImpl;
import br.com.ctup.model.Pessoa;

//classe responsavel pelo contato com o view(paginas jsp)
public class PessoaController {
	private Pessoa pessoa;
	//private PessoaDao pessoaDao = PessoaDaoImpl.getInstance();
private PessoaDao pessoaDao = new PessoaDaoImpl();
	public PessoaController() {
		pessoa = new Pessoa();
	}

	public List<Pessoa> getPessoas() {
		return pessoaDao.listarTodos();

	}

	public String salvar() {
		pessoaDao.salvar(pessoa);
		pessoa = new Pessoa();
		return "sucesso";
	}

	public String editar() {// pega o valor do id que esta atrelado ao link ao
							// jsp
		Integer id = Integer.parseInt(
				(String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		pessoa = pessoaDao.selecionarPorId(id);
		return "sucesso";
	}
	
	public String excluir() {// pega o valor do id que esta atrelado ao link ao
		// jsp
		Integer id = Integer.parseInt(
				(String) FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));
		 pessoaDao.excluir(id);
		 pessoa = new Pessoa();
		
		return "sucesso";
	}

	// devemos gerar o get e set pessoa, prq é por ele que passamos os
	// parametros da jsp
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public void autenticar() throws IOException{
	if(pessoa.getNome().equals("adm") && pessoa.getSenha().equals("adm")){
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adminSessao", pessoa);
		FacesContext.getCurrentInstance().getExternalContext().redirect("Login.jsp");
	}else{
		System.out.println("ELSE");
			pessoa = pessoaDao.autenticar(pessoa.getNome(), pessoa.getSenha());
	
		if (pessoa != null){
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pessoaSessao", pessoa);
			System.out.println("ENCONTROU");
			FacesContext.getCurrentInstance().getExternalContext().redirect("MP.html");;
		}else{
			System.out.println("NULL");
			FacesContext.getCurrentInstance().getExternalContext().redirect("Login.jsp");
		}
	}
}
public void omegalul() throws IOException{
if(pessoa.getNome().equals("adm") && pessoa.getSenha().equals("adm")) {	
FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("adminSessao", pessoa);	
FacesContext.getCurrentInstance().getExternalContext().redirect("Login.jsp");	
}else {
System.out.println("ELSE");
pessoa = pessoaDao.autenticar(pessoa.getNome(), pessoa.getSenha());
if (pessoa != null){
	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("pessoaSessao", pessoa);
	System.out.println("ENCONTROU");
	FacesContext.getCurrentInstance().getExternalContext().redirect("Bemvindo.html");
}else{
	System.out.println("NULL");
	FacesContext.getCurrentInstance().getExternalContext().redirect("Bemvindo.html");
}
}


}

}

