package com.javaee.sistema_acoes.repositories;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.javaee.sistema_acoes.domain.Acao;

@Repository
public interface AcaoRepository extends MongoRepository<Acao, Long> {
    Acao findById(String id);    
    List<Acao> findByEmpresa(String id);
}