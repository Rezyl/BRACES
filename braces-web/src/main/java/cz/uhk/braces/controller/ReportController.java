package cz.uhk.braces.controller;

import cz.uhk.braces.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.StringJoiner;

@Controller
@RequestMapping("report/")
public class ReportController {
	
	@Autowired
	private ReportService reportService;

	@RequestMapping(value = "showAllReports/", method = RequestMethod.GET)
	public String showAllTours(Model model) {
		List<List<String>> dataForGraph = reportService.getDataForGraph();

		model.addAttribute("day", formatString(dataForGraph.get(0)) );
		model.addAttribute("data1", formatString(dataForGraph.get(1)));
		model.addAttribute("data2", formatString(dataForGraph.get(2)));
		return "reports";
	}

	private String formatString(List<String> input) {
		StringJoiner sj = new StringJoiner(",");
		input.forEach(sj::add);
		return sj.toString();
	}

}
