package com.javaee.sistema_acoes.services;

import java.util.Set;

import com.javaee.sistema_acoes.domain.Acao;

public interface IAcaoService {

	Set<Acao> lista_todas_acoes();
	
    Acao comprar_acao(String idAcao, String idNovoComprador);
	
    Acao vender_acao(String idAcao);
    
    Acao criar_acao(Acao acao);

}
