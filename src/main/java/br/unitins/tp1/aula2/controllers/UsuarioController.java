package br.unitins.tp1.aula2.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.unitins.tp1.aula2.model.Usuario;

@Named
@ApplicationScoped
public class UsuarioController implements Serializable {
	private static final long serialVersionUID = 6368692416331958818L;
	private Usuario usuario = null;
	private List<Usuario> listUsuarios;
	private int cont = 1;

	public Usuario getUsuario() {
		if (usuario == null) {
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getListUsuarios() {
		if (listUsuarios == null) {
			listUsuarios = new ArrayList<Usuario>();
		}
		return listUsuarios;
	}

	public void incluir() {
		getUsuario().setId(cont++);
		getListUsuarios().add(getUsuario());
		limpar();
	}

	public void alterar() {
		int index = getListUsuarios().indexOf(getUsuario());
		getListUsuarios().set(index, getUsuario());
		limpar();
	}

	public void excluir(Usuario usuario) {
		getListUsuarios().remove(usuario);
	}

	public void excluir() {
		excluir(getUsuario());
		limpar();
	}

	public void limpar() {
		usuario = null;
	}

	public void editar(Usuario usuario) {
		Usuario clonedUsuario = usuario.getClone();
		setUsuario(clonedUsuario);
	}
}
