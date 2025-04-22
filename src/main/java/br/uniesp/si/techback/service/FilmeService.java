package br.uniesp.si.techback.service;

import br.uniesp.si.techback.model.Filme;

import java.util.List;

public interface FilmeService {
    Filme salvar(Filme filme);
    List<Filme> listarTodos();
    Filme buscarPorId(Integer id);
    Filme atualizar(Integer id, Filme filme);
    void deletar(Integer id);
}
