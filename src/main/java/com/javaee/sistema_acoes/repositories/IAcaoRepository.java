package com.diogo.trabalhofinal.mercadoacoes.repositories;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.diogo.trabalhofinal.mercadoacoes.domain.Acao;

public interface IAcaoRepository extends MongoRepository<Acao, Long> {

	public Acao obter_acao_empresa(long idEmpresa);
	public Acao comprar_acao(long idCliente, long idAcao, Date dataCompra);
	public Acao vender_acao(long idCliente, long idAcao);
}