package com.codecool.bookchelf;

public class PaperbackBook  extends Book{

	public PaperbackBook(String title, String author, int releaseYear, int numberOfPages) {
		super(title, author, releaseYear, numberOfPages);
		super.weightInGram = calculateWeightInGram();
	}

	public int getWeightInGram() {
		return super.weightInGram;
	}

	public int calculateWeightInGram() {
		int pageWeight=10;
		int papercoverWeight=20;
		return pageWeight*numberOfPages+papercoverWeight;
	}
}
