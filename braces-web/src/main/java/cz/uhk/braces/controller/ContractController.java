package cz.uhk.braces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.braces.model.Contract;
import cz.uhk.braces.service.CRUDService;

@Controller
@RequestMapping("contract/")
public class ContractController {
	
	@Autowired
	private CRUDService<Contract> contractService;
	
	@RequestMapping(value = "showAllContracts/", method = RequestMethod.GET)
	public String showAllTours(Model model) {
		List<Contract> result = contractService.getAll();

		model.addAttribute("contracts", result);
		return "contracts";
	}

}
