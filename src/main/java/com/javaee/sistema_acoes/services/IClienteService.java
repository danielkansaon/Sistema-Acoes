package com.javaee.mongodb.services;

import java.util.Set;

import com.javaee.mongodb.domain.Cliente;

public interface IAcaoService {

	Set<Cliente> retornar_todos();
	
    Cliente criar_cliente(Cliente cliente);    
  }

