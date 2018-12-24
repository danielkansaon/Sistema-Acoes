package com.javaee.sistema_acoes.services;

import java.util.Set;

import com.javaee.sistema_acoes.domain.Cliente;

public interface IClienteService {

  Set<Cliente> retornar_todos();
	
  Cliente criar_cliente(Cliente cliente);    

  Cliente obterClientePorId(String id);
  }

