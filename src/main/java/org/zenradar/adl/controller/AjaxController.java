package org.zenradar.adl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zenradar.adl.data.BookDao;
import org.zenradar.adl.model.Book;

/**
 * The REST service end-point for Another Digital Library
 * 
 * @author adam
 *
 */
@RestController
public class AjaxController {

	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);

	@Autowired
	BookDao bookDao;

	/**
	 * Returns a list of all borrowed books for the given user.
	 * The list may be empty.
	 * 
	 * @param userId
	 * @return a list of books
	 */
	@RequestMapping(value = "/borrowed/{userId}", method = RequestMethod.GET)
	public ResponseEntity<List<Book>> getBooks(@PathVariable("userId") String userId) {
		int id = Integer.parseInt(userId);
		logger.info("getBooks request for user " + id);
		List<Book> books = bookDao.findBorrowed(id);
		if (books.isEmpty()) {
			logger.info("getBooks found no books for user " + id);
		}
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

}