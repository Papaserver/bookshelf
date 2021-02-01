package com.codecool.bookchelf;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		HardcoverBook hardcoverBook = new HardcoverBook( "Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997, 365);
		HardcoverBook hardcoverBook2 = new HardcoverBook( "Harry Potter and the Philosopher's Stone","J. K. Rowling", 1990, 365);
		HardcoverBook hardcoverBook3 = new HardcoverBook( "Harry Potter and the Philosopher's Stone","J. K. Rowling", 1997, 365);
		HardcoverBook hardcoverBook4 = new HardcoverBook( "Harry Potter and the Philosopher's Stone","J. K. Rowling", 1996, 365);
		HardcoverBook hardcoverBook5 = new HardcoverBook( "EZ KELL Harry Potter and the Philosopher's Stone","EZ J. K. Rowling", 1997, 65);
		System.out.println(hardcoverBook.getWeightInGram());

		Bookshelf bookshelf = new Bookshelf();
		bookshelf.addBook(hardcoverBook);
		bookshelf.addBook(hardcoverBook2);
		bookshelf.addBook(hardcoverBook3);
		bookshelf.addBook(hardcoverBook4);
		bookshelf.addBook(hardcoverBook5);

		for (Book book: bookshelf.getBooks(1997)) {
			System.out.println(book.getBookInfo());
		}

		bookshelf.getBooks(1997).forEach(e -> System.out.println(e.getBookInfo()));


		System.out.println(Arrays.toString(bookshelf.getBooks(1997).toArray()));

		System.out.println();

		System.out.println(bookshelf.getLightestAuthor());

		System.out.println("Printbook:");
		bookshelf.printBooks();
	}

}
