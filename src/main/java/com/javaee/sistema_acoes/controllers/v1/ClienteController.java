package com.javaee.sistema_acoes.controllers.v1;

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

import com.javaee.sistema_acoes.domain.Cliente;
import com.javaee.sistema_acoes.services.IClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Cliente")
@RestController
@RequestMapping(AcaoController.BASE_URL)
public class ClienteController {

	public static final String BASE_URL = "/api/v1/cliente";

    private final IClienteService clienteService;

    public ClienteController(IClienteService _clienteService) {
        this.clienteService = _clienteService;
    }

    @Api(value = "Obter todos os clientes")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<Cliente> getAll(){
        return clienteService.retornar_todos();
    }
    
    @Api(value = "Criar um novo cliente")
    @PostMapping({"/criar"})
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
       return clienteService.criar_cliente(cliente);
    }
}
