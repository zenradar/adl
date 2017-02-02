package org.zenradar.adl.controller;

import java.util.List;

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

@Controller
public class SiteController {

	@Autowired
	BookDao bookDao;

	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = {"/books", "/index", "/"}, method = RequestMethod.GET)
	public String book(@ModelAttribute("model") ModelMap model) {
		List<Book> bookList = bookDao.findAll();

		model.addAttribute("bookList", bookList);

		return "books";
	}
	
	@RequestMapping(value = "/members", method = RequestMethod.GET)
	public String index(@ModelAttribute("model") ModelMap model) {
		List<User> userList = userDao.findAll();

		List<Book> bookList = bookDao.findBorrowed(2);

		model.addAttribute("bookList", bookList);

		model.addAttribute("userList", userList);

		return "members";
	}

}