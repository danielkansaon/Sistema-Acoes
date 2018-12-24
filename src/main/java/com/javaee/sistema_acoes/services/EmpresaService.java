package com.javaee.sistema_acoes.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javaee.sistema_acoes.domain.Empresa;
import com.javaee.sistema_acoes.repositories.IEmpresaRepository;

@Service
public class EmpresaService implements IEmpresaService{
	private IEmpresaService empresaRepository;
	
	public EmpresaService(IEmpresaService _empresaRepository){
		this.empresaRepository = _empresaRepository;
	}
	
	@Override
	public Set<Empresa> retornar_todos() {
		Set<Empresa> empresas = new HashSet<>();
		this.empresaRepository.findAll().iterator().forEachRemaining(empresas::add);
		return empresas;
	}

	@Override
	public Empresa criar_empresa(Empresa empresa) {		
		return empresaRepository.save(empresa);
    }

    @Override
	public Empresa atualizarQtdAcoes(String idEmpresa, int qtdAcoes) {		
        Optional<Empresa> empresa = empresaRepository.findById(idEmpresa);
        empresa.setQtdAcoes(qtdAcoes);
		return empresaRepository.save(empresa);
    }  
}