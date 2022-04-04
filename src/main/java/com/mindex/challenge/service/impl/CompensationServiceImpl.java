package com.mindex.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

@Service
public class CompensationServiceImpl implements CompensationService {

	@Autowired
	CompensationRepository repository;

	@Override
	public Compensation create(Compensation compensation) {
		repository.insert(compensation);
		return compensation;
	}

	@Override
	public Compensation read(String id) {
		return repository.findByEmployeeId(id);
	}

}
