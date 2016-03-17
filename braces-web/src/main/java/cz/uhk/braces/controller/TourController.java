package cz.uhk.braces.controller;

import cz.uhk.braces.model.Tour;
import cz.uhk.braces.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * User: Lukas Rezner
 * Date: 17.3.16
 */
@Controller
@RequestMapping("tour/")
public class TourController {

	@Autowired
	private CRUDService<Tour> tourService;

	@RequestMapping(value = "showAllTours/", method = RequestMethod.GET)
	public String showAllTours(Model model) {
		List<Tour> result = tourService.getAll();

		model.addAttribute("tours", result);
		return "tours";
	}
}
