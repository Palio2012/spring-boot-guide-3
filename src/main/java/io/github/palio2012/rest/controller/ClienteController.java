package io.github.palio2012.rest.controller;

import io.github.palio2012.domain.entities.Cliente;
import io.github.palio2012.domain.respository.Clientes;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping ("api/repository")
public class ClienteController {

    private Clientes repository;

    public ClienteController (Clientes repository) {
        this.repository = repository;
    }

    @GetMapping("{id}")
    public Cliente getClienteById( @PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public Cliente save (@RequestBody Cliente cliente) {
        return repository.save(cliente);
    }

    @DeleteMapping ("{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void delete ( @PathVariable Integer id) {
        repository.findById(id)
                .map(cliente -> { repository.delete(cliente);
                    return cliente;})
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));

    }

    @PutMapping ("{id}")
    @ResponseStatus (HttpStatus.NO_CONTENT)
    public void update ( @PathVariable Integer id, @RequestBody Cliente cliente) {
         repository.findById(id).map( clienteExistente -> {
            cliente.setId(clienteExistente.getId());
            repository.save(cliente);
            return clienteExistente;
        } ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @GetMapping
    public List <Cliente> findAll (Cliente filtro) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                                        .withIgnoreCase()
                                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        return repository.findAll(example);
    }

}