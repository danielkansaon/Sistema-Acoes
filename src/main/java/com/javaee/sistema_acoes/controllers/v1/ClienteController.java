package com.javaee.mongodb.controllers.v1;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javaee.mongodb.domain.Cliente;
import com.javaee.mongodb.services.ClienteService;

@RestController
@RequestMapping(AcaoController.BASE_URL)
public class ClienteController {

	public static final String BASE_URL = "/api/v1/cliente";

    private final ClienteService clienteService;

    public ClienteController(ClienteService _clienteService) {
        this.clienteService = _clienteService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Acao> getAll(){
        return clienteService.retornar_todos();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        return acaoService.criar_cliente(cliente);
    }
}
