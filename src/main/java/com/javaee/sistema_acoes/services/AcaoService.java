package com.javaee.sistema_acoes.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.javaee.sistema_acoes.domain.Acao;
import com.javaee.sistema_acoes.domain.Empresa;
import com.javaee.sistema_acoes.domain.Cliente;
import com.javaee.sistema_acoes.email.EmailSender;
import com.javaee.sistema_acoes.repositories.AcaoRepository;
import com.javaee.sistema_acoes.repositories.EmpresaRepository;
import com.javaee.sistema_acoes.repositories.ClienteRepository;


@Service
public class AcaoService implements IAcaoService{
	@Autowired
  	private ClienteRepository clienteRepository;

  	@Autowired
  	private EmpresaRepository empresaRepository;
	  
	private AcaoRepository acaoRepository;
	
	public AcaoService(AcaoRepository acaoRepository){
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

		if(get_qtdAcoes_empresa(acao.getIdEmpresa()) >= get_qtdMaxAcoes_empresa(acao.getIdEmpresa())){
			throw new IllegalArgumentException("Limite esgotado de ações da empresa");
		}

		return acaoRepository.save(acao);
	}

	@Override
	public Acao comprar_acao(String idAcao, String idNovoComprador) {
		Acao acao = acaoRepository.findById(idAcao);

		if (acao == null) {
            throw new IllegalArgumentException("Ação não existente para este ID: " + idAcao);
		}

		if(acao.getIdCliente() != null or acao.getIdCliente() != "0"){
			throw new IllegalArgumentException("A ação não pode ser comprada pois já pertence a outro cliente. Ação: " + idAcao);
		}

		acao.setData(new Date()); // Inserindo nova data de compra

		new Thread("emailCompra"){
			public void run(){
				
				String idAntigo = acao.getIdCliente();
				EmailSender.send(get_email_cliente(idNovoComprador), "Compra de Ação", "Confirmação da compra da ação: " + idAcao);
				
				if(idAntigo != "0"){
					EmailSender.send(get_email_cliente(idNovoComprador), "Compra de Ação", "Sua antiga ação foi comprada por outro cliente! Ação: " + idAcao);
				}				
			}
		}.start();
		
		acao.setIdCliente(idNovoComprador);
		return acaoRepository.save(acao);
	}

	@Override
	public Acao vender_acao(String idAcao) {
		Acao acao = acaoRepository.findById(idAcao);

		if (acao == null) {
            throw new IllegalArgumentException("Ação não existente para este ID: " + idAcao);
		}
		
		if(acao.getIdCliente() == null or acao.getIdCliente() == "0"){
			throw new IllegalArgumentException("A ação não pode ser vendida pois não pertence a nenhum cliente. Ação: " + idAcao);
		}

		acao.setData(null);
		
		new Thread("emailVenda"){
			public void run(){				
				String idAntigo = acao.getIdCliente();
				
				if(idAntigo != "0"){
					EmailSender.send(get_email_cliente(idAntigo), "Venda de Ação", "Confirmação da venda da ação: " + idAcao);
				}				
			}
		}.start();
		
		acao.setIdCliente("0");
		return acaoRepository.save(acao);	
	}
	
	@Override	
	public List<Acao> lista_todas_acoes_por_empresa(String idEmpresa){
		return this.acaoRepository.findByEmpresa(idEmpresa);
	}

	private String get_email_cliente(String idCliente){
		Cliente clienteOptional = clienteRepository.findById(idCliente);

		if (clienteOptional == null) {
            throw new IllegalArgumentException("Id inválido: " + idCliente);
		}

		return clienteOptional.getEmail();
	}

	private int get_qtdAcoes_empresa(String idEmpresa){
		List<Acao> empresaOptional = this.acaoRepository.findByEmpresa(idEmpresa);
		return empresaOptional.size();		
	}

	private int get_qtdMaxAcoes_empresa(String idEmpresa){
		Empresa empresaOptional = empresaRepository.findById(idEmpresa);

		if (empresaOptional == null) {
            throw new IllegalArgumentException("Id inválido: " + idEmpresa);
		}

		return empresaOptional.getQtdAcoes();
	}
}