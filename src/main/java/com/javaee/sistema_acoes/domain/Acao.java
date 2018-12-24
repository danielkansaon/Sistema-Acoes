package com.javaee.sistema_acoes.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Document
public class Acao{

	@Id
	private String id = UUID.randomUUID().toString();
	private String idEmpresa;
	private float valor_inicial;
	private float valor_atual;
	
	@Nullable
	private Date data;
	@Nullable
	private String idCliente;
	
	@DBRef
	private Cliente cliente;
	@DBRef
	private Empresa empresa;
}
