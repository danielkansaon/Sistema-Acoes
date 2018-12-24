package com.javaee.sistema_acoes.domain;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empresa {
	
	@Id
	private String id = UUID.randomUUID().toString();
	private String nome;
	private int qtdAcoes;	
}
