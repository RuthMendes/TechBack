package br.uniesp.si.techback.service.impl;

import br.uniesp.si.techback.exception.ExceptionMessages;
import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.repository.UsuarioRepository;
import br.uniesp.si.techback.service.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    @Override
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Integer id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(ExceptionMessages.UsuarioService.USUARIO_POR_ID_NAO_ENCONTRADO)
        );
    }

    @Transactional
    @Override
    public Usuario atualizar(Integer id, Usuario usuario) {
        Usuario usuarioFromDb = buscarPorId(id);
        BeanUtils.copyProperties(usuario, usuarioFromDb);

        return usuarioFromDb;
    }

    @Transactional
    @Override
    public void deletar(Integer id) {
        Usuario usuario = buscarPorId(id);

        usuarioRepository.delete(usuario);
    }
}
