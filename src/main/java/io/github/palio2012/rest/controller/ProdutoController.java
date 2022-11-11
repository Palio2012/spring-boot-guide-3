package io.github.palio2012.rest.controller;


import io.github.palio2012.domain.entities.Produto;
import io.github.palio2012.domain.respository.Produtos;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping ("api/produtos")
public class ProdutoController {

    private Produtos repository;

    public ProdutoController(Produtos repository) {
        this.repository = repository;
    }

    @GetMapping ("{id}")
    public Produto getProdutoById (@PathVariable Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public Produto save (@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @DeleteMapping
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Integer id) {
        repository.findById(id)
                .map( produto -> {
                    repository.delete(produto);
                    return produto;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    @PutMapping ("{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void update (@PathVariable Integer id, @RequestBody Produto produto) {
        repository.findById(id)
                .map(produtoExistente -> {
                    produto.setId(produtoExistente.getId());
                    repository.save(produto);
                    return produtoExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    @GetMapping
    public List<Produto> findAll (Produto filtro) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        return repository.findAll(example);
    }
}

