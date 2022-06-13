package com.avaliacao.cast.avaliacaocast.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MedicoGetResponse {	

	private Long idMedico;
	private String nome;
	private String crm;
	private String telefone;
	private String tipo;
	
}
