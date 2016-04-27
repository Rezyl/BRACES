package cz.uhk.braces.service.impl;

import cz.uhk.braces.model.Contract;
import cz.uhk.braces.service.CRUDService;
import cz.uhk.braces.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: Lukas Rezner
 * Date: 27.4.16
 */
@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	@Qualifier("contractServiceImpl")
	private CRUDService<Contract> contractService;

	@Override
	public List<List<String>> getDataForGraph() {
		List<Contract> contracts = contractService.getAll();

		List<List<String>> resutl = new ArrayList<>();
		resutl.add(new LinkedList<>());
		resutl.add(new LinkedList<>());
		resutl.add(new LinkedList<>());

		for (Contract contract : contracts) {
			resutl.get(0).add(String.valueOf(contract.getCreationDate().getDayOfMonth()));
			resutl.get(1).add(String.valueOf(getCountForDay(contract.getCreationDate().getDayOfMonth(), false, contracts)));
			resutl.get(2).add(String.valueOf(getCountForDay(contract.getCreationDate().getDayOfMonth(), true, contracts)));
		}
		return resutl;
	}

	private int getCountForDay(int day, boolean cancel, List<Contract> contracts) {
		int result = 0;
		for (Contract contract : contracts) {

			if (contract.getCancel() == cancel && contract.getCreationDate().getDayOfMonth() == day) {
				result++;
			}
		}
		return result;
	}
}
