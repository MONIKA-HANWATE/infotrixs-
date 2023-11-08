package com.springrest.springrest.services;

import java.util.List;
import com.springrest.springrest.entities.Quote;

public interface QuoteService {
	public List<Quote> getQuotes();

	public Quote getQuote(long parseLong);


	public Quote addQuote(Quote quote);

	public Quote updateQuote(Quote quote);

	public void deleteQuote(long parseLong);

	public Quote getRandomQuote();


	

	

}
