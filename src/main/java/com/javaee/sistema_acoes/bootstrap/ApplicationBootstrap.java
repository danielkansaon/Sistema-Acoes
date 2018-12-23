package com.javaee.sistema_acoes.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.javaee.sistema_acoes.domain.Cliente;
import com.javaee.sistema_acoes.repositories.IClienteRepository;

import com.javaee.sistema_acoes.domain.Empresa;
import com.javaee.sistema_acoes.repositories.IEmpresaRepository;

@Component
public class ApplicationBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private IClienteRepository clienteRepository;
    private IEmpresaRepository empresaRepository;
	
	public ApplicationBootstrap(IClienteRepository _clienteRepository, IEmpresaRepository _empresaRepository) {
        this.clienteRepository = _clienteRepository;
        this.empresaRepository = _empresaRepository;
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		if (clienteRepository.count() == 0L) {
            clienteRepository.deleteAll();
            
            loadEmpresas();
            loadClientes();
		}
	}
	
	private void loadClientes() {
        Cliente cli = new Cliente();
        cli.setNome("João");
        clienteRepository.save(cli);

        Cliente cli2 = new Cliente();
        cli2.setNome("Maria");
        clienteRepository.save(cli2);
    }

    private void loadEmpresas() {
        //Empresa emp = new Empresa();
        //emp.setNome("Empresa X");
        //empresaRepository.save(emp);
    }

}