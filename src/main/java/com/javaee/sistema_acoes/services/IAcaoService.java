package com.javaee.sistema_acoes.services;

import java.util.Set;

import com.javaee.sistema_acoes.domain.Acao;

public interface IAcaoService {

	Set<Acao> lista_todas_acoes();
	
    Acao comprar_acao(Long id, Acao acao);
	
    Acao vender_acao(Long id, Acao acao);
    
    Acao criar_acao(Acao acao);

}
