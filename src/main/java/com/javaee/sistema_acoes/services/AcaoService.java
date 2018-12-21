package com.javaee.mongodb.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.mongodb.domain.Acao;
import com.javaee.mongodb.repositories.IAcaoRepository;

@Service
public class AcaoService implements IAcaoService{
	private IAcaoRepository acaoRepository;
	
	public MercadoService(IAcaoRepository acaoRepository){
		this.acaoRepository = acaoRepository;
	}
	
	@Override
	public Set<Acao> lista_todas_acoes() {
		Set<Acao> acoes = new HashSet<>();
		this.acaoRepository.findAll().iterator().forEachRemaining(acoes::add);
		return acoes;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Acao criar_acao(Acao acao) {	
		return acaoRepository.save(acao);
	}

	@Override
	public Set<Acao> comprar_acao(Long id, Acao acao) {
		acao.setIdcliente(id)
		Acao acaoSaved = acaoRepository.save(acao);
		return acaoSaved;
	}

	@Override
	public void vender_acao(Long id, Acao acao) {
		acao.setIdcliente(id)
		Acao acaoSaved = acaoRepository.save(acao);
		return acaoSaved;
	}
}