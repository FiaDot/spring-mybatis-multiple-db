package com.fiadot.mmdb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fiadot.mmdb.mapper.TestDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@Autowired
	TestDao test_dao;
	

	@RequestMapping(value = "/access", method = RequestMethod.GET)
	@ResponseBody
	public String access() {		
	
		int result = 0;
				
		result = test_dao.sp_multiple_db_test();				
		logger.info("test = " + result);
		
		ContextHolder.setType("1");
		result = test_dao.sp_multiple_db_test();				
		logger.info("test = " + result);	
		
		ContextHolder.setType("2");
		result = test_dao.sp_multiple_db_test();				
		logger.info("test = " + result);
				
		ContextHolder.setType("3");
		result = test_dao.sp_multiple_db_test();				
		logger.info("test = " + result);
		
		return "0";
	}
	
	
	@RequestMapping(value = "/access1", method = RequestMethod.GET)
	@ResponseBody
	public String access1() {
		ContextHolder.setType("1");
		
		
		int result = test_dao.sp_multiple_db_test();				
		logger.info("test = " + result);				
		return "1";
	}
	
	@RequestMapping(value = "/access2", method = RequestMethod.GET)
	@ResponseBody
	public String access2() {
		ContextHolder.setType("2");
		int result = test_dao.sp_multiple_db_test();				
		logger.info("test = " + result);				
		return "2";
	}
	
	
	@RequestMapping(value = "/access3", method = RequestMethod.GET)
	@ResponseBody
	public String access3() {
		ContextHolder.setType("3");
		int result = test_dao.sp_multiple_db_test();				
		logger.info("test = " + result);				
		return "3";
	}
	
}
