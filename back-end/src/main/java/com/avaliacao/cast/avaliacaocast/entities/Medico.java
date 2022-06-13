package com.avaliacao.cast.avaliacaocast.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name="medico")
@Entity
public class Medico {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedico;
	
	@Column(name="nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name="crm", length = 150, nullable = false)
	private String crm;

	@Column(name="telefone", length = 150, nullable = false)
	private String telefone;
	
	@Column(name="tipo", length = 150, nullable = false)
	private String tipo;
	
}
