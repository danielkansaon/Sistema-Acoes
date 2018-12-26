package com.javaee.sistema_acoes.services;

import java.util.Set;
import java.util.List;

import com.javaee.sistema_acoes.domain.Acao;

public interface IAcaoService {

	Set<Acao> lista_todas_acoes();
	
    Acao comprar_acao(String idAcao, String idNovoComprador);
	
    Acao vender_acao(String idAcao);
    
    Acao criar_acao(Acao acao);

    List<Acao> lista_todas_acoes_por_empresa(String idEmpresa);
}
