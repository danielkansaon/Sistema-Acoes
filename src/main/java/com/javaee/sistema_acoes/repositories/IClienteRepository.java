package com.diogo.trabalhofinal.mercadoacoes.repositories;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.diogo.trabalhofinal.mercadoacoes.domain.Cliente;

public interface IClienteRepository extends MongoRepository<Acao, Long> {

    public Cliente obter_todos_clientes();
	public Cliente criar_cliente(string nome);