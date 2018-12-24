package com.javaee.sistema_acoes.bootstrap;

import java.util.Date;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.javaee.sistema_acoes.domain.Acao;
import com.javaee.sistema_acoes.domain.Cliente;
import com.javaee.sistema_acoes.repositories.AcaoRepository;
import com.javaee.sistema_acoes.repositories.ClienteRepository;

import com.javaee.sistema_acoes.domain.Empresa;
import com.javaee.sistema_acoes.repositories.EmpresaRepository;

@Component
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ClienteRepository clienteRepository;
    private EmpresaRepository empresaRepository;
    private AcaoRepository acaoRepository;
	private String idCliente;
	private String idEmpresa;
    
	public ApplicationBootstrap(ClienteRepository _clienteRepository, EmpresaRepository _empresaRepository, 
			AcaoRepository acaoRepository) {
        this.clienteRepository = _clienteRepository;
        this.empresaRepository = _empresaRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		if (clienteRepository.count() == 0L) {
            clienteRepository.deleteAll();
            
            loadEmpresas();
            loadClientes();
            loadAcoes();
		}
	}
	
	private void loadClientes() {
        Cliente cli = new Cliente();
        cli.setNome("João");
        cli.setEmail("joao@gmail.com");
        clienteRepository.save(cli);

        Cliente cli2 = new Cliente();
        cli2.setNome("Maria");
        cli2.setEmail("maria@gmail.com");
        idCliente = cli2.getId();
        clienteRepository.save(cli2);
    }

    private void loadEmpresas() {
        Empresa emp = new Empresa();
        emp.setNome("Empresa X");
        emp.setQtdAcoes(5);
        idEmpresa = emp.getId();
        empresaRepository.save(emp);
    }
    
    @SuppressWarnings("deprecation")
	private void loadAcoes() {
        Acao acao = new Acao();
        acao.setValor_atual(5);
        acao.setValor_inicial(4);        
        acao.setData(new Date(2018,5,2));
        acao.setIdCliente(idCliente);
        acao.setIdEmpresa(idEmpresa);
        
        acaoRepository.save(acao);
    }

}