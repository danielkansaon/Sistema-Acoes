package com.javaee.sistema_acoes.domain;

import java.util.ArrayList;
import java.util.List;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Cliente {

	@Id
	private String id = UUID.randomUUID().toString();
	private String nome;
	private String email;
	
	@DBRef
	private List<Acao> acoes;
}
