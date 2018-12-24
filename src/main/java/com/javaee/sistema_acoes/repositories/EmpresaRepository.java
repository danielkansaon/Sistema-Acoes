package com.javaee.sistema_acoes.repositories;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.sistema_acoes.domain.Empresa;

@Repository
public interface EmpresaRepository extends MongoRepository<Empresa, Long> {
    Empresa findById(String id);
}