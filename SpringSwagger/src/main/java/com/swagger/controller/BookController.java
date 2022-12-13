package com.swagger.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swagger.model.Book;
import com.swagger.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/book")
@Api(value="Book Service",description="Priya Book Store")
public class BookController {
	

//	private static final Logger log = LogManager.getLogger(BookController.class);
	
	Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@Autowired
	private BookService bookSrvice;
	
	
	@PostMapping("/addBook")
	//if you dont want same method name(addBook) in your swagger then u can change its name
	@ApiOperation(value="store book api")
	public String addBook(@RequestBody Book book)
	{
		logger.info(" In BookController::addBook {} ",book);
		try {
		bookSrvice.saveBook(book);
		String s=null;
		s.charAt(2);
		}
		catch (Exception e) {
			logger.error(e.getMessage());
			throw new RuntimeException("exception while adding book");
		}
		logger.info("Book save succefully");
		return bookSrvice.saveBook(book);
	}
	
	@GetMapping("/getBookById/{id}")
	@ApiOperation(value="search book api by id")
	public Book getBook(@PathVariable int id)
	{
	return bookSrvice.getBookById(id);	
	}
	
	@GetMapping("/getAllBook")
	@ApiOperation(value="search all book api")
	public List<Book> getAll()
	{
		return bookSrvice.getAllBook();
	}
	@DeleteMapping("/deleteBookById/{id}")
	@ApiOperation(value="remove book api")
	public List<Book> deleteBook(@PathVariable int id)
	{
		return bookSrvice.removeBook(id);
	}

}
