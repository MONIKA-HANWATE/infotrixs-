package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.QuoteDao;
import com.springrest.springrest.entities.Quote;

@Service
public class QuoteServiceImp implements QuoteService {
	
	@Autowired
	private QuoteDao quoteDao;
	
	//List<Quote> list;
	
	public QuoteServiceImp() {	
		//list = new ArrayList<>();
		//list.add(new Quote(145,"Keep your face always toward the sunshine, and shadows will fall behind you "));
		//list.add(new Quote(146,"where is my java"));
	}

	@Override
	public List<Quote> getQuotes() {	
	//return list;
	
	return quoteDao.findAll();
	}
	
	@Override
	public Quote getQuote(long quoteId) {
		
	/*	Quote c= null;
		for(Quote quote : list) {
			if(quote.getId()==quoteId) {
				c=quote;
				break;
			}
		}
		return c;
		*/
	return quoteDao.getOne(quoteId);
	}
	
	
	@Override
	
	public Quote addQuote(Quote quote) {
		/*
		list.add(quote);
	return quote;
		*/
		quoteDao.save(quote);
		return quote;
	}
	
     @Override
	
	public Quote updateQuote(Quote quote) {
    	 
    /*	 list.forEach(e -> {
    		 if(e.getId()==quote.getId()) {
    			 e.setToday_quote(quote.getToday_quote());
    		 }
    			 
    	 });
    	 return quote;
    	*/ 
		quoteDao.save(quote);
		return quote;
	}
     
     
     @Override
 	public void deleteQuote(long parseLong) {
    	 
    	// list =this.list.stream().filter(e -> e.getId()!= parseLong).collect(Collectors.toList());
    	 
     Quote entity= quoteDao.getOne(parseLong);
     quoteDao.delete(entity);
     }
     

     public Quote getRandomQuote() {
 	    List<Quote> allQuotes = quoteDao.findAll();
 	    
 	    if (allQuotes.isEmpty()) {
 	        return null; // Handle the case when there are no quotes in the database.
 	    }

 	    int randomIndex = new Random().nextInt(allQuotes.size());

 	    return allQuotes.get(randomIndex);
 	}

	
}
