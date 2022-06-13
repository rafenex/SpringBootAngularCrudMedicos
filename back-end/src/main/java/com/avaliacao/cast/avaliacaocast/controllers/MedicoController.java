package com.avaliacao.cast.avaliacaocast.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.avaliacao.cast.avaliacaocast.dto.MedicoGetResponse;
import com.avaliacao.cast.avaliacaocast.dto.MedicoPostRequest;
import com.avaliacao.cast.avaliacaocast.entities.Medico;
import com.avaliacao.cast.avaliacaocast.repository.IMedicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class MedicoController {

	@Autowired
	private IMedicoRepository medicoRepository;

	private static final String ENDPOINT = "api/medicos";

	@PostMapping(value = ENDPOINT)
	public ResponseEntity<String> cadastrar(@RequestBody MedicoPostRequest request) {
		try {
			Medico medico = request.toMedico();
			medicoRepository.save(medico);
			return ResponseEntity.status(HttpStatus.CREATED).body("Medico cadastrado com sucesso");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: " + e.getMessage());
		}
	}

	@GetMapping(value = ENDPOINT)
	public ResponseEntity<List<MedicoGetResponse>> listar() {
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

	@GetMapping(value = ENDPOINT + "/{idMedico}")
	public ResponseEntity<?> findById(@PathVariable("idMedico") Long idMedico) {
		Optional<Medico> item = medicoRepository.findById(idMedico);
		if (item.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não encontrado");
		} else {
			MedicoGetResponse response = new MedicoGetResponse();
			Medico medico = item.get();
			response.setIdMedico(medico.getIdMedico());
			response.setNome(medico.getNome());
			response.setCrm(medico.getCrm());
			response.setTelefone(medico.getTelefone());
			response.setTipo(medico.getTipo());
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
	}

	@DeleteMapping(value = ENDPOINT + "/{idMedico}")
	public ResponseEntity<String> deleteById(@PathVariable("idMedico") Long idMedico) {
		try {
			Optional<Medico> item = medicoRepository.findById(idMedico);
			if (item.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
			} else {
				Medico medico = item.get();
				medicoRepository.delete(medico);
				return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
		}
	}

	@PutMapping(value = ENDPOINT +"/{idMedico}")
	public ResponseEntity<?> update(@PathVariable("idMedico")Long idMedico, @RequestBody MedicoPostRequest request){
		try {
			Optional<Medico> item = medicoRepository.findById(idMedico);
			if (item.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não encontrado");
			}else { 
				Medico medico = item.get();
				medico.setNome(request.getNome());
				medico.setCrm(request.getCrm());
				medico.setTelefone(request.getTelefone());
				medico.setTipo(request.getTipo());
				medicoRepository.save(medico);
				return ResponseEntity.status(HttpStatus.OK).body("Médico atualizado");
			}
		} catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: "+ e.getMessage());
		}
		
	}

}
