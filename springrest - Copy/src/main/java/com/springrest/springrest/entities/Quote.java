package com.springrest.springrest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Quote {
	@Id
	private long id;
	
	private String today_quote;
	
	
	public Quote(long id, String today_quote) {
		super();
		this.id = id;
		this.today_quote = today_quote;
	}
	public Quote() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getToday_quote() {
		return today_quote;
	}
	public void setToday_quote(String today_quote) {
		this.today_quote = today_quote;
	}
	@Override
	public String toString() {
		return "Quote [id=" + id + ", today_quote=" + today_quote + "]";
	}
	

}
