package com.codecool.bookchelf;

public class Book {
	String title;
	String author;
	int releaseYear;
	int numberOfPages;



	int weightInGram;




	public Book(String title, String author, int releaseYear, int numberOfPages) {
		this.title = title;
		this.author = author;
		this.releaseYear=releaseYear;
		this.numberOfPages=numberOfPages;
	}

	public String getBookInfo() {
		return author+": "+title+"("+String.valueOf(releaseYear)+")";
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public int getWeightInGram() {
		return weightInGram;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public String getAuthor() {
		return author;
	}
}
