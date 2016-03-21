package cz.uhk.braces.controller;

import cz.uhk.braces.model.Country;
import cz.uhk.braces.model.Tour;
import cz.uhk.braces.model.register.Register;
import cz.uhk.braces.service.CRUDService;
import cz.uhk.braces.service.RegisterItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * User: Lukas Rezner
 * Date: 17.3.16
 */
@Controller
@RequestMapping(TourController.TOUR_DOMAIN)
public class TourController {

	public static final String TOUR_DOMAIN = "tour";
	private static final String SHOW_ALL_TOURS_URL = "showAllTours/";

	private static final String ALL_TOURS_VIEW = "tour/tours";
	private static final String DETAIL_TOUR_URL = "detail/{id}/";
	private static final String NEW_TOUR_FORM_URL = "createTour/";

	private static final String NEW_TOUR_FORM_VIEW = "tour/newTour";
	private static final String SAVE_TOUR_URL = "save/";
	@Autowired
	private CRUDService<Tour> tourService;

	@Autowired
	private RegisterItemService registerItemService;

	@Autowired
	@Qualifier("countryServiceImpl")
	private CRUDService<Country> countryService;


	@RequestMapping(value = SHOW_ALL_TOURS_URL, method = RequestMethod.GET)
	public String showAllTours(Model model) {
		List<Tour> result = tourService.getAll();

		model.addAttribute("tours", result);
		return ALL_TOURS_VIEW;
	}

	@RequestMapping(value = DETAIL_TOUR_URL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Tour showDetail(@PathVariable Long id) {
		return tourService.getByID(id);
	}

	@RequestMapping(value = NEW_TOUR_FORM_URL, method = RequestMethod.GET)
	public String newTourForm(Model model) {
		Tour tour = new Tour();
		model.addAttribute("tour", tour);
		//prepare selects
		model.addAttribute("countries", countryService.getAll());
		model.addAttribute("types", registerItemService.getByRegister(Register.TOUR_TYPE));
		model.addAttribute("transports", registerItemService.getByRegister(Register.TRANSPORT_TYPE));
		model.addAttribute("categories", registerItemService.getByRegister(Register.TOUR_CATEGORY));
		model.addAttribute("cateringTypes", registerItemService.getByRegister(Register.TOUR_CATERING));
		model.addAttribute("accommodationTypes", registerItemService.getByRegister(Register.TOUR_ACCOMMODATION));
		return NEW_TOUR_FORM_VIEW;
	}

	@RequestMapping(value = SAVE_TOUR_URL, method = RequestMethod.POST)
	public String saveTour(@ModelAttribute("tour") Tour tour) {

		tourService.update(tour);
		return "redirect:"+ TOUR_DOMAIN + "/" + SHOW_ALL_TOURS_URL;
	}
}
