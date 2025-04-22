package br.uniesp.si.techback.service.impl;

import br.uniesp.si.techback.exception.ExceptionMessages;
import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.repository.FilmeRepository;
import br.uniesp.si.techback.service.FilmeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FilmeServiceImpl implements FilmeService {
    private final FilmeRepository filmeRepository;

    @Transactional
    @Override
    public Filme salvar(Filme filme) {
        return filmeRepository.save(filme);
    }

    @Override
    public List<Filme> listarTodos() {
        return filmeRepository.findAll();
    }

    @Override
    public Filme buscarPorId(Integer id) {
        return filmeRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(ExceptionMessages.FilmeService.FILME_POR_ID_NAO_ENCONTRADO)
        );
    }

    @Transactional
    @Override
    public Filme atualizar(Integer id, Filme filme) {
        Filme filmeFromDb = buscarPorId(id);

        filmeFromDb.setTitulo(filme.getTitulo());
        filmeFromDb.setAutor(filme.getAutor());
        filmeFromDb.setAnoDeLancamento(filme.getAnoDeLancamento());

        return filmeFromDb;
    }

    @Transactional
    @Override
    public void deletar(Integer id) {
        Filme filme = buscarPorId(id);

        filmeRepository.delete(filme);
    }
}
