package org.zerock.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.AirVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.MemberVO;
import org.zerock.domain.PageMaker;
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.BoardDAO;
import org.zerock.persistence.AirDAO;
/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/air/*")
public class AirController {
	
	@Inject
	private AirDAO AirDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(AirController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value="/register", method= RequestMethod.GET)
	public String airGet(AirVO air, Model model) throws Exception{
		
		return "air/airGet";
	}
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public String airPost(AirVO air, Model model) throws Exception{
		
		AirDAO.create(air);
		
		return "air/airGetSuccess";
		
	}
	
	@RequestMapping(value="/registJSON", method= RequestMethod.POST)
	public String airPostJSON(@RequestBody AirVO air, Model model) throws Exception{
		
		
		logger.info(air.toString());
		AirDAO.create(air);
		
		model.addAttribute("air", AirDAO);
		
		return "air/airList";
	
		
	}
	
	@RequestMapping(value="/registJSON", method= RequestMethod.GET)
	public ModelAndView airGETJSON(@ModelAttribute AirVO air, HttpSession session, Model model, ModelAndView mav) throws Exception{
		
		mav.setViewName("air/airList");
		mav.addObject("list", AirDAO.listAll());
		
		//session = request.getSession(true);
		//session.setAttribute("air", AirDAO);
		
		
		//AirDAO.create(air);
		
		return mav;
	
		
	}
	
	@RequestMapping(value = "/sendAir/{uhome}", method = RequestMethod.GET)
	public ResponseEntity<List<AirVO>> sendAir(@PathVariable("uhome") String uhome){
		
		ResponseEntity<List<AirVO>> entity = null;
		
		try {
			entity = new ResponseEntity<>(
					AirDAO.read(uhome), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	

}








