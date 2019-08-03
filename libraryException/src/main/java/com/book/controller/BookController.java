package com.book.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.Book;
import com.book.service.BookService;


@RequestMapping("library")
@RestController
public class BookController{
	public static final Logger logger = LogManager.getLogger(BookController.class);
	
	 
		
	@Autowired
	BookService bookService;
	
	@PostMapping
	public Book create (@RequestBody Book book) throws Exception 
	{
		Book value=null;
	   try {
			 value= bookService.create(book);
			 logger.debug("debug occur in creation");
			 logger.error("error occur in creation");
			 logger.trace("trace occur in creation");
			 
		} catch (MetaDataAccessException exception) 
	   {
			exception.printStackTrace();
			
			throw exception;
		}	
		 
		 return value;
	}
	
	
	
	@GetMapping
	public List<Book> getAllBook(@RequestParam(defaultValue="0")Integer pageNo,@RequestParam(defaultValue="10")Integer pageSize,@RequestParam(defaultValue="bookid")String sortBy)
	{
		return  bookService.getAllBook(pageNo,pageSize,sortBy);
	}


	

}
