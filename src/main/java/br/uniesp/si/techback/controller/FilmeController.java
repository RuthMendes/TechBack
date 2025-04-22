package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Filme;
import br.uniesp.si.techback.service.FilmeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Filme criarFilme(@RequestBody Filme filme) {
        return filmeService.salvar(filme);
    }

    @GetMapping
    public List<Filme> listarFilmes() {
        return filmeService.listarTodos();
    }

    @GetMapping("/{id}")
    public Filme buscarFilme(@PathVariable Integer id) {
        return filmeService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Filme atualizarFilme(@PathVariable Integer id, @RequestBody Filme filme) {
        return filmeService.atualizar(id, filme);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletarFilme(@PathVariable Integer id) {
        filmeService.deletar(id);
    }
}
