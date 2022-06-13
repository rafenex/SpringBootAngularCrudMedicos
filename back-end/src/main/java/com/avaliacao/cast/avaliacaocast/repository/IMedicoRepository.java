package com.avaliacao.cast.avaliacaocast.repository;

import com.avaliacao.cast.avaliacaocast.entities.Medico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicoRepository extends JpaRepository<Medico, Long>{
	

}
