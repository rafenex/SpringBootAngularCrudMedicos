package com.avaliacao.cast.avaliacaocast.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //mostrando ao framework que essa classe é uma entidade do banco de dados
@Table(name="usuario") //criando uma tabela no banco de dados
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idusuario")
	private Integer idUsuario;
	
	@Column(name="nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name="login", length = 50, nullable = false)
	private String login;
	
	@Column(name="senha", length = 50, nullable = false)
	private String senha;

}