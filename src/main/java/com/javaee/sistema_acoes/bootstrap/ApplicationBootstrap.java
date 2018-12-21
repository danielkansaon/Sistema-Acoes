package com.javaee.sistema_acoes.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.javaee.sistema_acoes.domain.Cliente;
import com.javaee.sistema_acoes.repositories.ClienteRepository;

import com.javaee.sistema_acoes.domain.Empresa;
import com.javaee.sistema_acoes.repositories.EmpresaRepository;

@Component
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private ClienteRepository clienteRepository;
    private EmpresaRepository empresaRepository;
	
	public ApplicationBootstrap(ClienteRepository _clienteRepository, EmpresaRepository _empresaRepository) {
        this.clienteRepository = _clienteRepository;
        this.empresaRepository = _empresaRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		if (clienteRepository.count() == 0L) {
            clienteRepository.deleteAll();
            
            loadEmpresas();
            loadCategories();
		}
	}
	
	private void loadClientes() {
        Cliente cli = new Cliente();
        cli.setNome("João");
        clienteRepository.save(cli);

        Cliente cli = new Cliente();
        cli.setNome("Maria");
        clienteRepository.save(cli);
    }

    private void loadEmpresas() {
        Empresa emp = new Empresa();
        emp.setNome("Empresa X");
        empresaRepository.save(emp);
    }

    private void loadAcoes() {
        Empresa emp = new Empresa();
        emp.setNome("Empresa X");
        empresaRepository.save(emp);
    }
}