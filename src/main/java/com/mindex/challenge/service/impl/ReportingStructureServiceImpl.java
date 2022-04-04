package com.mindex.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

	@Autowired
	private EmployeeService employeeService;

	@Override
	public ReportingStructure getReport(String id) {
		Employee employee = employeeService.read(id);

		int totalReports = getNumberOfReports(employee, 0);

		ReportingStructure structure = new ReportingStructure();
		structure.setEmployee(employee);
		structure.setNumberOfReports(totalReports);

		return structure;
	}

	private int getNumberOfReports(Employee root, int count) {
		count = count + (root.getDirectReports() != null ? root.getDirectReports().size() : 0);
		if (root.getDirectReports() != null) {
			for (Employee child : root.getDirectReports()) {
				child = employeeService.read(child.getEmployeeId());
				count = getNumberOfReports(child, count);
			}
		}

		return count;
	}

}
