package com.book.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.MetaDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.dao.BookDao;
import com.book.model.Book;
import com.book.validation.FieldValidation;

@Service
public class BookService 
{
	public static final Logger logger = LogManager.getLogger(BookService.class);
	
	@Autowired
	FieldValidation fieldvalidation;
	
	@Autowired
	BookDao bookDao;
	
	
	public Book create (Book book) throws Exception 
	{
		Book value = null;
		 try {
			 value=FieldValidation.validPrice(book);
			 logger.info(book.getPrice());
			 
			 value=FieldValidation.findAuthorName(book);
			 logger.info(book.getAuthorname());
			 
			 value= bookDao.create(book);
		} 
		 catch (MetaDataAccessException exception) 
		 {
			exception.printStackTrace();
			throw exception;
		}
		return value;
	}
	
	public List<Book> getAllBook(@RequestParam(defaultValue="0")Integer pageNo,@RequestParam(defaultValue="10")Integer pageSize,@RequestParam(defaultValue="bookid")String sortBy)
	{
		return  bookDao.getAllBook(pageNo,pageSize,sortBy);
	}
	
	
}
