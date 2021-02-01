package com.codecool.bookchelf;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bookshelf {

	List<Book> books = new ArrayList<>();

	public void addBook(Book book) {
		books.add(book);
	}

	public List<Book> getBooks(int year) {
		return books.stream().filter(book -> book.getReleaseYear()==year).collect(Collectors.toList());
	}

	public String getLightestAuthor() {
		return books.stream().min(Comparator.comparing(Book::getWeightInGram)).get().getAuthor();
//		int lightestBook = books.stream().mapToInt(book -> book.weightInGram).min().orElseThrow(IllegalStateException::new);
//		System.out.println(lightestBook);
//		return books.stream().filter(book -> book.weightInGram == lightestBook).findFirst().orElseThrow(IllegalStateException::new).getAuthor();
	}

	public String getAuthorOfMostWrittenPages(){
		Set<String> authors; // Set deklaralasa
		authors = books.stream().map(Book::getAuthor).collect(Collectors.toSet()); // osszes szerzo osszegyujtese egy Set-be (azert Set, hogy ne legyen ismetlodes
		Map<String, Integer> sumOfPages = new HashMap<String, Integer>(); // Map peldanyositasa, key: author, value: irt oldalak szama

		// forEach: mindegyik elemen vegrehajtja: minden irot belerakunk a Map-be ugy, hogy a value-t ugy adjuk hozza a key-hez
		// , hogy az adott iro altal irt osszes oldal legyen a value-ban segedmetodus (getSumOfPagesForAuthor) hivassal

		authors.stream()
				.forEach(author -> sumOfPages.put(author, getSumOfPagesForAuthor(author)));

		// a Map osszes key-value parjan megyunk vegig, ezekbol valasztjuk ki a maximumot ugy,
		// hogy a max-on belul levo comparator a value alapjan hasonlitsa ossze az entryset-et
		// A max vegen egy optional-t kapunk, amit kezelni kell, es a getKey vel vesszuk ki a key - value parbol csak a key-t,
		// ami lesz a kert String, az iro neve

		return sumOfPages.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).orElseThrow(IllegalStateException::new).getKey();
	}

	private int getSumOfPagesForAuthor(String author){

		// konyveken megyunk vegig, filterrel megnezzuk, hogy a parameterben kapott author ugyanaz-e, mint az adott book authorja
		// Majd a mapToInt letrehoz egy olyan intStream-et, ami tartalmazza az author-hoz tartozo osszes oldalszamot
		// es ezeket osszeadja a sum()-mal egy darab integerre

		return books.stream().filter(book -> book.getAuthor().equals(author)).mapToInt(Book::getNumberOfPages).sum();
	}

	public void printBooks() {
		books.forEach(book -> System.out.println(book.getBookInfo()));
	}

//
//	Legyen egy printBooks() függvénye, ami kiírja az összes könyv adatát.
//	Soronként kiírja a könyvek getBookInfo() visszatérési értékét
}
