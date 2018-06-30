package br.com.ctup.DAO;

import java.util.List;

import br.com.ctup.model.Pessoa;

public interface PessoaDao {
	void salvar(Pessoa pessoa);
	void excluir (Integer id);
	Pessoa selecionarPorId(Integer id);
	List<Pessoa> listarTodos();
	Pessoa autenticar(String login, String senha);
}
