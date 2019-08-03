package com.book.validation;

import javax.naming.NameNotFoundException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.book.controller.BookController;
import com.book.dao.BookDao;
import com.book.model.Book;


@Component
public class FieldValidation {
	
	public static final Logger logger = LogManager.getLogger(BookDao.class);
	
	FieldValidation(){
	
		super();
	}
	
	
public static Book validPrice(Book book) throws NumberFormatException
{
		if (book.getPrice() >= 150 && book.getPrice()<= 500)
			
			logger.info("book is added");
		
		else
			throw new NumberFormatException("price is not between 150 and 500");
		return book;
					
	}
	public static Book findAuthorName (Book book) throws NameNotFoundException
	{ 
		
	
		if ("aravinth".equals(book.getAuthorname())) 
			
			logger.info("author name is correct");
		
		else
			
            throw new NameNotFoundException("Name is not match!");
		return book;
        
	}
	

}
