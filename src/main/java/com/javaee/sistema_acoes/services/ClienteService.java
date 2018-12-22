package com.javaee.sistema_acoes.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.sistema_acoes.domain.Cliente;
import com.javaee.sistema_acoes.repositories.IClienteRepository;

@Service
public class ClienteService implements IClienteService{
	private IClienteRepository clienteRepository;
	
	public ClienteService(IClienteRepository _clienteRepository){
		this.clienteRepository = _clienteRepository;
	}
	
	@Override
	public Set<Cliente> retornar_todos() {
		Set<Cliente> clientes = new HashSet<>();
		this.clienteRepository.findAll().iterator().forEachRemaining(clientes::add);
		return clientes;
	}

	@Override
	public Cliente criar_cliente(Cliente cliente) {		
		return clienteRepository.save(cliente);
	}

	@Override
	public Cliente obterClientePorId(Long id) {
		return obterPorId(id);
	}
	
	private Cliente obterPorId(Long id) {
		Optional<Cliente> clienteOptional = clienteRepository.findById(id);
		if (!clienteOptional.isPresent()) {
            throw new IllegalArgumentException("Id inválido: " + id.toString());
        }
		return clienteOptional.get();
	}
}