package com.avaliacao.cast.avaliacaocast.controllers;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avaliacao.cast.avaliacaocast.service.RelatorioReportService;

import net.sf.jasperreports.engine.JRException;


@Controller
@RequestMapping
public class RelatorioJasperController {
	
	
	@Autowired
	private RelatorioReportService service;	


	@GetMapping("/report/{format}")	
	private ResponseEntity<String> generateReport(@PathVariable String format) throws FileNotFoundException, JRException{
		String exportReport = service.exportReport(format);		
		return ResponseEntity.status(HttpStatus.CREATED).body(exportReport);
		
	}
	
	
	
	
	


}
