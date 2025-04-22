package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario salvar(Usuario usuario);
    List<Usuario> listarTodos();
    Usuario buscarPorId(Integer id);
    Usuario atualizar(Integer id, Usuario usuario);
    void deletar(Integer id);
}