package com.book.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.book.model.Book;
import com.book.repository.BookRepository;

@Component
public class BookDao {
	
	public static final Logger logger = LogManager.getLogger(BookDao.class);
	
	@Autowired
	BookRepository bookRepository;
	
	
	public Book create (Book book) throws Exception {
		Book value=null;
		try
		{
		value= bookRepository.save(book);
		logger.info("book saved");
		} 
		catch (Exception exception) {
			
			exception.printStackTrace();
			throw exception;
		}
			
	return value;

}
	
	public List<Book>  getAllBook(@RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "3") Integer pageSize,String sortBy) 
	{
		
		Pageable paging=PageRequest.of(pageNo, pageSize,Sort.by(sortBy));
		 Page<Book> pagedResult = bookRepository.findAll(paging);
         
	        if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } 
	        else {
	            return new ArrayList<Book>();
	        }
	    }
	
	
}
