package com.booksbussola.livros.controller;

import com.booksbussola.livros.entity.Livro;
import com.booksbussola.livros.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro") //localhost:8080/livro
public class LivroController {

    private final LivroService livroService;

    public LivroController (LivroService livroService){
        this.livroService = livroService;
    }
    @GetMapping
    public List<Livro> buscarTodos(){
        return livroService.buscarTodos();
    }

    @GetMapping ("{id}")
    public Livro buscarPorId(@PathVariable Long id){
        return livroService.buscarPorId(id).orElse(null);
    }

    @DeleteMapping ("{id}")
    public void deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
    }

    @PostMapping
    public Livro adicionarLivro (@RequestBody Livro livro){
        return livroService.adicionarLivro(livro);
    }

    @PutMapping ("{id}")
    public Livro atualizarLivro (@PathVariable Long id, @RequestBody Livro livroAtualizado){
        return livroService.atualizarLivro(id, livroAtualizado);
    }
}