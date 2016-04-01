package cz.uhk.braces.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cz.uhk.braces.model.Accomodation;
import cz.uhk.braces.service.CRUDService;

@Controller
@RequestMapping(AccomodationController.ACCOMODATION_DOMAIN)
public class AccomodationController {
	public static final String ACCOMODATION_DOMAIN = "accomodation";
	private static final String SHOW_ALL_ACCOMODATION_URL = "showAllAccomodations/";
	private static final String ALL_ACCOMODATIONS_VIEW = "tour/accomodation";
	
	@Autowired
	private CRUDService<Accomodation> accomodationService;
	
	@RequestMapping(value = SHOW_ALL_ACCOMODATION_URL, method = RequestMethod.GET)
	public String showAllTours(Model model) {
		List<Accomodation> result = accomodationService.getAll();
		model.addAttribute("accomodations", result);
		return ALL_ACCOMODATIONS_VIEW;
	}

}
