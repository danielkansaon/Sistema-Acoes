package com.javaee.sistema_acoes.repositories;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.javaee.sistema_acoes.domain.Cliente;

public interface IClienteRepository extends MongoRepository<Cliente, Long> {
}