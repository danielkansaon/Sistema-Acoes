package com.javaee.mongodb.services;

import java.util.Set;

import com.javaee.mongodb.domain.Acao;

public interface IAcaoService {

	Set<Acao> lista_todas_acoes();
	
    Set<Acao> comprar_acao(Long id_cliente, Long id_empresa, int qtd);
	
	void void vender_acao(Long id);

}
