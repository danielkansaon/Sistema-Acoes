package com.javaee.sistema_acoes.repositories;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.sistema_acoes.domain.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, Long> {
    Cliente findById(String id);
}