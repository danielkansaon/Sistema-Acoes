package com.javaee.sistema_acoes.repositories;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.javaee.sistema_acoes.domain.Acao;

public interface IAcaoRepository extends MongoRepository<Acao, Long> {

	public Acao obter_acao_empresa(long idEmpresa);
	public Acao comprar_acao(long idCliente, long idAcao, Date dataCompra);
	public Acao vender_acao(long idCliente, long idAcao);
}