package com.javaee.sistema_acoes.domain;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empresa {
	
	@Id
	private int id;
	private String nome;
}
