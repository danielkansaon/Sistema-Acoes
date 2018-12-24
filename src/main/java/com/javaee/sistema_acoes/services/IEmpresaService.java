package com.javaee.sistema_acoes.services;

import java.util.Set;

import com.javaee.sistema_acoes.domain.Empresa;

public interface IEmpresaService {

  Set<Empresa> retornar_todos();
	
  Empresa criar_empresa(Empresa empresa);    

  Empresa atualizarQtdAcoes(String idEmpresa, int qtdAcoes);
}

