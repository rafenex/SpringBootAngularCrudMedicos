package com.avaliacao.cast.avaliacaocast.controllers;

import javax.transaction.Transactional;

import com.avaliacao.cast.avaliacaocast.dto.AccountPostRequest;
import com.avaliacao.cast.avaliacaocast.entities.Usuario;
import com.avaliacao.cast.avaliacaocast.repository.IUsuarioRepository;
import com.avaliacao.cast.avaliacaocast.security.MD5Cryptography;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.ApiOperation;

@Controller
@Transactional
public class AccountController {
	
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	private static final String ENDPOINT = "/api/account";
	
	@ApiOperation("Serviço de criação de conta de usuário.")
	@RequestMapping(value = ENDPOINT, method = RequestMethod.POST)
	@CrossOrigin
	public ResponseEntity<String> post(@RequestBody AccountPostRequest request){
		try {
			//verificar se o login informado existe no banco de addos
			if (usuarioRepository.findByLogin(request.getLogin())!= null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("O Login informado já está cadastrado no sistema, tente outro");								
			}	
			//cadastrar usuário
			Usuario usuario = new Usuario();	
			usuario.setNome(request.getNome());
			usuario.setLogin(request.getLogin());
			usuario.setSenha(MD5Cryptography.encrypt(request.getSenha()));
			usuarioRepository.save(usuario);
			
			return ResponseEntity.status(HttpStatus.OK)
					.body("Conta de usuário criada com sucesso");
			
		} catch (Exception e){
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(e.getMessage());
			
		}
	}


	

}