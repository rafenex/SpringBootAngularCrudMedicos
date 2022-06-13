package com.avaliacao.cast.avaliacaocast.controllers;

import java.util.ArrayList;
import java.util.List;

import com.avaliacao.cast.avaliacaocast.dto.MedicoGetResponse;
import com.avaliacao.cast.avaliacaocast.dto.MedicoPostRequest;
import com.avaliacao.cast.avaliacaocast.entities.Medico;
import com.avaliacao.cast.avaliacaocast.repository.IMedicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MedicoController {
	
	@Autowired
	private IMedicoRepository medicoRepository;
	
	private static final String ENDPOINT = "api/medicos";
	
	@PostMapping(value = ENDPOINT)
	public ResponseEntity<String> cadastrar(@RequestBody MedicoPostRequest request){
		try {
			Medico medico = request.toMedico();
			medicoRepository.save(medico);
			return ResponseEntity.status(HttpStatus.CREATED).body("Medico cadastrado com sucesso");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}
	}
	
	@GetMapping(value=ENDPOINT)
	public ResponseEntity<List<MedicoGetResponse>> listar(){
		List<MedicoGetResponse> response = new ArrayList<MedicoGetResponse>();
		for (Medico medico : medicoRepository.findAll()) {
			MedicoGetResponse item = new MedicoGetResponse();
			item.setIdMedico(medico.getIdMedico());
			item.setNome(medico.getNome());
			item.setCrm(medico.getCrm());
			item.setTelefone(medico.getTelefone());
			item.setTipo(medico.getTipo());
			response.add(item);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
}
