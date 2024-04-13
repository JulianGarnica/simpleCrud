package com.example.demo.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.views.BooksRepository;
import com.example.demo.models.Books;

@RestController
@RequestMapping("/api")
public class BooksController {
	
	@Autowired
    BooksRepository booksRepository;
	
	@GetMapping("/books")
	public List<Books> books() {
		return booksRepository.findAll();
	}
	
	@GetMapping("/book/{id}")
    public Optional<Books> show(@PathVariable String id){
        int bookId = Integer.parseInt(id);
        return booksRepository.findById(bookId);
    }
	
	@PostMapping("/book")
    public Books create(@RequestBody Map<String, String> body){
        String title = body.get("title");
    	String description = body.get("description");
    	String bookstore = body.get("bookstore");
    	String locationBookstore = body.get("locationBookstore");
        return booksRepository.save(new Books(title, description, bookstore, locationBookstore));
    }
	
	@PutMapping("/book/{id}")
    public Books update(@PathVariable String id, @RequestBody Map<String, String> body){
        int bookId = Integer.parseInt(id);
        // getting blog
        Books book = booksRepository.findById(bookId).orElse(null);
        book.setTitle(body.get("title"));
        book.setDescription(body.get("description"));
        book.setBookstore(body.get("bookstore"));
        book.setLocationBookstore(body.get("locationBookstore"));
        return booksRepository.save(book);
    }
	
	@DeleteMapping("/book/{id}")
    public boolean delete(@PathVariable String id){
        int bookId = Integer.parseInt(id);
        booksRepository.deleteById(bookId);
        return true;
    }
}
