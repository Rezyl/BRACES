package cz.uhk.braces.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: Lukas Rezner
 * Date: 3.3.16
 */
@Controller
public class MainController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		return "redirect:/tour/showAllTours/";
	}
}
