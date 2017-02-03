package org.zenradar.adl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zenradar.adl.data.BookDao;
import org.zenradar.adl.data.UserDao;
import org.zenradar.adl.model.Book;
import org.zenradar.adl.model.User;

/**
 * The primary controller for Another Digital Library
 * 
 * There are two views. A books view which lists all the books in the library.
 * A members view which list all the members of the library. The members view
 * also displays a list of borrowed books for a member when the member is
 * selected.
 * 
 * @author adam
 *
 */
@Controller
public class SiteController {

	private static final Logger logger = LoggerFactory.getLogger(SiteController.class);
			
	@Autowired
	BookDao bookDao;

	@Autowired
	UserDao userDao;

	/**
	 * The Books page
	 * Lists all books in the library.
	 * 
	 * @param model
	 * @return books
	 */
	@RequestMapping(value = {"/books", "/index", "/"}, method = RequestMethod.GET)
	public String books(@ModelAttribute("model") ModelMap model) {
		logger.info("Book list accessed");
		List<Book> bookList = bookDao.findAll();
		model.addAttribute("bookList", bookList);

		return "books";
	}
	
	/**
	 * The Members page
	 * Lists all members of the library.
	 * 
	 * @param model
	 * @return members
	 */
	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public String members(@ModelAttribute("model") ModelMap model) {
		logger.info("Member list accessed");
		List<User> userList = userDao.findAll();
		model.addAttribute("userList", userList);

		return "members";
	}

}