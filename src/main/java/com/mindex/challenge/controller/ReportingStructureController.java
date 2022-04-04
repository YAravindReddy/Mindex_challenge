package com.mindex.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

@RestController
public class ReportingStructureController {

	@Autowired
	private ReportingStructureService reportingStructureService;

	@GetMapping("/report/{id}")
	public ReportingStructure getReport(@PathVariable String id) {
		return reportingStructureService.getReport(id);
	}

}
