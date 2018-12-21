package com.javaee.mongodb.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document
public class Acao{

	private Long id;
	private Long cod_empresa;
	private float valor_inicial;
	private float valor_atual;
	
	@Nullable
	private Date data_hora;
	@Nullable
	private Long idcliente;
}
