package com.booksbussola.livros.service;

import com.booksbussola.livros.entity.Livro;
import com.booksbussola.livros.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    public Livro adicionarLivro (Livro livro){
        return livroRepository.save(livro);
    }

    public List<Livro> buscarTodos(){
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId (Long id){
        return livroRepository.findById(id);
    }

    public void deletarLivro (Long id){
        livroRepository.deleteById(id);
    }

    public Livro atualizarLivro (Long id, Livro livroAtualizado){
        Livro livro = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro nao encontrado com esse id" +id));

        livro.setNome(livroAtualizado.getNome());
        livro.setAutor(livroAtualizado.getAutor());
        livro.setAno(livroAtualizado.getAno());
        livro.setPreco(livroAtualizado.getPreco());

        return livroRepository.save(livro);
    }
}
