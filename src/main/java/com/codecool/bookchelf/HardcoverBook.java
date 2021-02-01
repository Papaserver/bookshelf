package com.codecool.bookchelf;

public class HardcoverBook extends Book{

	public HardcoverBook(String title, String author, int releaseYear, int numberOfPages) {
		super(title, author, releaseYear, numberOfPages);
		super.weightInGram = calculateWeightInGram();
	}

	public int getWeightInGram() {
		return super.weightInGram;
	}

	public int calculateWeightInGram() {
		int pageWeight=10;
		int hardcoverWeight=100;
		return pageWeight*numberOfPages+hardcoverWeight;
	}
}
