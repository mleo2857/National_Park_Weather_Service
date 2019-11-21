package com.techelevator.npgeekControllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.Login;
import com.techelevator.npgeek.Park;
import com.techelevator.npgeek.SurveyResult;
import com.techelevator.npgeekDAO.parkDAO;
import com.techelevator.npgeekDAO.surveyResultDAO;
import com.techelevator.npgeekDAO.weatherDAO;

@Controller
public class HomeController {
	
	@Autowired 
	private parkDAO parkdao;
	
	@Autowired 
	private weatherDAO weatherdao;
	
	@Autowired
	private surveyResultDAO surveydao;
	
	@RequestMapping(path = {"/", "/homePage"})
	public String displayHomePage(ModelMap map, HttpSession session) {
		List<Park> allParks = parkdao.getAllParks();
		map.addAttribute("parks", allParks);
		if(session.getAttribute("tempChoice") == null) {
			session.setAttribute("tempChoice", "Fahrenheit");
		}
		if(session.getAttribute("login") == null) {
			session.setAttribute("login", false);
		}
		return "homePage";
	}

	@RequestMapping(path="/parkDetail", method=RequestMethod.GET)
	public String parkDetailPage(@RequestParam String id, @RequestParam String temp, ModelMap model, HttpSession session) {
		model.put("park", parkdao.getParkByParkCode(id));
		model.put("weather", weatherdao.getWeatherByParkCode(id));
		session.setAttribute("tempChoice", temp);
		return "parkDetail";
	}
	
	@RequestMapping(path="/survey", method=RequestMethod.GET)
	public String showSurveyInput(ModelMap map, HttpSession session) {
		if(!map.containsAttribute("surveyPost")) {
			map.addAttribute("surveyPost", new SurveyResult());
		}
		if(session.getAttribute("login").equals(false)) {
			return"redirect:/login";
		}
		return "survey";
	}
	
	@RequestMapping(path = "/survey", method = RequestMethod.POST)
	public String processForumPost(
			@Valid @ModelAttribute("surveyPost") SurveyResult survey,
			BindingResult result,
			RedirectAttributes flash
			) {
		
		if (result.hasErrors()) {
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "surveyPost", result);
			flash.addFlashAttribute("surveyPost", survey);
			return "redirect:/survey";
		}
		
		SurveyResult surveyPost = new SurveyResult(survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
		// surveyPost.setDatePosted(LocalDateTime.now());
		surveydao.save(surveyPost);
		return "redirect:/surveyResults";
	}
	
	@RequestMapping(path = "/surveyResults", method = RequestMethod.GET)
	public String showSurveyResults(ModelMap map) {
				
		ArrayList<Park> parks = surveydao.getParkSurveyCount().keySet().iterator().next();
		Map<String, Integer> parkSurveyCount = surveydao.getParkSurveyCount().values().iterator().next();
		
		System.out.println(parks);
		System.out.println(parkSurveyCount);
		
		map.addAttribute("parks", parks);
		map.addAttribute("surveyMap", parkSurveyCount);

		return "surveyResults";
	}
	
	@RequestMapping(path="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap map, HttpSession session) {
		if(!map.containsAttribute("Login")) {
			map.addAttribute("Login", new Login());
		}
		return "login";
	}
	
	@RequestMapping(path="/login", method = RequestMethod.POST)
//	public String processLogin(@Valid @ModelAttribute("Login") Login login, HttpSession session, BindingResult result, RedirectAttributes flash) {
	public String processLogin( @ModelAttribute("Login") Login login, HttpSession session) {

	System.out.println("verifying data");

//		if(result.hasErrors()) {
//			System.out.println("test");
//			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "Login", result);
//			flash.addFlashAttribute("Login", login);
//			
//			return "redirect:/login";
//			
//		}
		session.setAttribute("login", true);
		return "redirect:/homePage";
	}
	
}
