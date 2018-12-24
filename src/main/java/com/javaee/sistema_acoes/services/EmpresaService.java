package com.javaee.sistema_acoes.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.javaee.sistema_acoes.domain.Empresa;
import com.javaee.sistema_acoes.repositories.EmpresaRepository;

@Service
public class EmpresaService implements IEmpresaService{
	private EmpresaRepository empresaRepository;
	
	public EmpresaService(EmpresaRepository _empresaRepository){
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
        Empresa empresa = empresaRepository.findById(idEmpresa);
        empresa.setQtdAcoes(qtdAcoes);
		return empresaRepository.save(empresa);
    }  
}