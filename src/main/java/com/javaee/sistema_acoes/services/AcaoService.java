package com.javaee.sistema_acoes.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.sistema_acoes.domain.Acao;
import com.javaee.sistema_acoes.email.EmailSender;
import com.javaee.sistema_acoes.repositories.IAcaoRepository;


@Service
public class AcaoService implements IAcaoService{
	private IAcaoRepository acaoRepository;
	
	public AcaoService(IAcaoRepository acaoRepository){
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
	public Acao comprar_acao(long id, Acao acao) {
		acao.setIdcliente(id);
		Acao acaoSaved = acaoRepository.save(acao);

		new Thread("emailCompra"){
			public void run(){
				EmailSender.send("kansaonp@gmail.com", "Compra de Ação", "Confirmação da compra de uma nova ação!");
			}
		}.start();
		
		return acaoSaved;
	}

	@Override
	public Acao vender_acao(long id, Acao acao) {
		acao.setIdcliente(id);
		Acao acaoSaved = acaoRepository.save(acao);

		new Thread("emailVenda"){
			public void run(){
				EmailSender.send("kansaonp@gmail.com", "Venda de Ação", "Confirmação da venda de uma ação!");
			}
		}.start();
		
		return acaoSaved;
	}
}