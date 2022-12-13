package com.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swagger.dao.BookRepository;
import com.swagger.model.Book;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	public String saveBook(Book book)
	{
		bookRepo.save(book);
		return "Book save with id "+book.getBookId(); 
	}
	
	public Book getBookById(int id)
	{
		return bookRepo.findById(id).get();
	}
	
	public List<Book> getAllBook()
	{
		return bookRepo.findAll();
	}
	public List<Book> removeBook(int id)
	{
		bookRepo.deleteById(id);
		return bookRepo.findAll();
		
	}

}
