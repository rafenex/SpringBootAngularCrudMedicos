package com.avaliacao.cast.avaliacaocast.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.avaliacao.cast.avaliacaocast.entities.Medico;
import com.avaliacao.cast.avaliacaocast.repository.IMedicoRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class RelatorioReportService {
	
	@Autowired
	IMedicoRepository repository;
	
	public String exportReport(String reportFormat) throws JRException, FileNotFoundException  {
		
		String path = "C:\\Users\\User\\Desktop\\medicos";
		List<Medico>medicos = repository.findAll();
		File file = ResourceUtils.getFile("classpath:medicos2.jrxml");
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(medicos);		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("Criado por ", "Treinamento CastGroup");
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters , datasource); 
		
		if(reportFormat.equalsIgnoreCase("html")) {
			JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\medicos.html");
		}
		
		if(reportFormat.equalsIgnoreCase("pdf")) {
			JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\medicos.pdf");
		}
		

		return "report gerado no caminho: " + path;
		
		
	}

}
