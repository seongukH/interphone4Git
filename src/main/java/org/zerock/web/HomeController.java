package org.zerock.web;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.domain.MemberVO;

import org.zerock.persistence.BoardDAO;
import org.zerock.persistence.MemberDAO;
/**
 * Handles requests for the application home page.
 */
@Controller

public class HomeController {
	
	@Inject
	private MemberDAO memberdao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	*/
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Locale locale, Model model) {
		logger.info("Welcome signupPage! The client locale is {}.", locale);
		
		
		
		return "signUp";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(MemberVO Member, Model model) {
		logger.info("Signup Post The client locale is {}.", Member);		
		
		memberdao.insertMember(Member);
		
		return "signUpSuccess";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String signin(@ModelAttribute("MemberVO") MemberVO membervo) {
		logger.info("Welcome signupPage! The client locale is {}.", membervo);		
		
		return "signIn";
	}
	
	/*
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public String signinPost(MemberVO Member, Model model) {
		logger.info("signinPage post! The client locale is {}.", Member);
		
		//model.addAttribute( );
		
		if(memberdao.loginCheck(Member)!=null) {
			
			return "signinSuccess";
		}
		
		return "signIn";
	}*/
	
	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public ModelAndView signinPost(HttpSession session, ModelAndView mav, 
			MemberVO Member, Model model) throws Exception {
		logger.info("signinPage post! The client locale is {}.", memberdao.loginCheck(Member));
		
		//model.addAttribute( );
		//MemberVO membervo = memberdao.loginCheck(Member);
		
		if(memberdao.loginCheck(Member)!=null) {
			session.setAttribute("MemberVO", memberdao.loginCheck(Member));
			mav.setViewName("signinSuccess");
			mav.addObject("MemberVO",memberdao.loginCheck(Member));
			model.addAttribute("MemberVO", memberdao.loginCheck(Member));
			//logger.info(memberdao.loginCheck(Member));
			return mav;
		}
		mav.setViewName("signinFail");
		return mav;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@ModelAttribute MemberVO vo, HttpSession session, ModelAndView mav) {
		logger.info("signinPage post! The client locale is {}.", memberdao.listAll());
		//logger.info("signinPage post! The client locale is {}.",searchType + word);
		mav.setViewName("list");
		mav.addObject("list", memberdao.listAll());
		
		//session = request.getSession(true);
		session.setAttribute("member", memberdao);
		
		//mav.addObject("list", memberdao.search("userName", "bbb"));
		
		
		return mav;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	  public ModelAndView read(@RequestParam("userNo") int userNo, ModelAndView mav)
	      throws Exception {
		logger.info("signinPage post! The client locale is {}.", memberdao.read(userNo));
	    //model.addAttribute(memberdao.read(userNo));
		mav.setViewName("view");
	    mav.addObject("MemberVO", memberdao.read(userNo));
	    
	    return mav;
	  }
	
	
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("userId") String userId) {
		logger.info("delete");
		
		memberdao.delete(userId);
		
		return "redirect:/list";
	}
	
	
	
}








