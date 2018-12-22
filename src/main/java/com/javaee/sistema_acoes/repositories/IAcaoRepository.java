package com.javaee.sistema_acoes.repositories;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.sistema_acoes.domain.Acao;

@Repository
public interface IAcaoRepository extends MongoRepository<Acao, Long> {
}