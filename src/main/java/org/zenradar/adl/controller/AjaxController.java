package org.zenradar.adl.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.zenradar.adl.data.BookDao;
import org.zenradar.adl.model.Book;
import org.zenradar.adl.model.User;


@RestController
public class AjaxController {

	@Autowired
	BookDao bookDao;
	
	/*@RequestMapping("/ajax")
    public ModelAndView helloAjaxTest() {
        return new ModelAndView("index", "message", "Crunchify Spring MVC with Ajax and JQuery Demo..");
    }*/
 
    @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
    public @ResponseBody
    String getTime(@RequestParam("userId") String userId) {
 
        Random rand = new Random();
        float r = rand.nextFloat() * 100;
        String result = "<br/>User: " + userId + "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
        System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
        return result;
    }

    @RequestMapping(value = "/borrowed/{userId}", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBooks(@PathVariable("userId") int id) {
    	System.out.println("getBooks called.");
    	List<Book> books = bookDao.findBorrowed(id);
    	if(books.isEmpty()){
    		System.out.println("no book for id: " + id);
        		
            return new ResponseEntity<List<Book>>(books, HttpStatus.OK);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }
    
}