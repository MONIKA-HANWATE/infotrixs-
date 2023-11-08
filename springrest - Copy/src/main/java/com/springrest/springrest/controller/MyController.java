package com.springrest.springrest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Random;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Quote;

import com.springrest.springrest.services.QuoteService;
//import com.springrest.springrest.services.QuoteDao;
@RestController
@RequestMapping("/quotes")
public class MyController {
	
	@Autowired
	private QuoteService quoteService;
	
	@GetMapping("/quotes")
	public List<Quote> getQuotes() {
		return this.quoteService.getQuotes();
		
	}
	
	@GetMapping("/quotes/{quoteId}")
	public Quote getQuote(@PathVariable String quoteId) {
		
		return this.quoteService.getQuote(Long.parseLong(quoteId));
	}
	
	
	@PostMapping("/quotes")
	public Quote addQuote(@RequestBody Quote quote) {
		return this.quoteService.addQuote(quote);
	}
	
	@PutMapping("/quotes")
	public Quote updateQuote(@RequestBody Quote quote) {
		return this.quoteService.updateQuote(quote);
	}

	@DeleteMapping("/quotes/{quoteId}")
	public ResponseEntity<HttpStatus> deleteQuote(@PathVariable String quoteId){
		try {
			this.quoteService.deleteQuote(Long.parseLong(quoteId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	
	 @GetMapping("/random")
	    public Quote getRandomQuote1() {
	        return quoteService.getRandomQuote();
	    }


}
