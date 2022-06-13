package com.avaliacao.cast.avaliacaocast.dto;

import com.avaliacao.cast.avaliacaocast.entities.Medico;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoPostRequest {
	private String nome;
	private String crm;
	private String telefone;
	private String tipo;
	
	
	public Medico toMedico() {
		Medico medico = new Medico();
		medico.setNome(nome);
		medico.setCrm(crm);
		medico.setTelefone(telefone);
		medico.setTipo(tipo);
		return medico;
		
	}
	
}
