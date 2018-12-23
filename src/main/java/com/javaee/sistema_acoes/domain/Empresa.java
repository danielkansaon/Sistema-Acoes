package com.javaee.sistema_acoes.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empresa {
	
	@Id
	private long id;
	private String nome;
}
