package by.epamtc.melnikov.elibrary.bean.builder;

import by.epamtc.melnikov.elibrary.bean.Book;
import by.epamtc.melnikov.elibrary.bean.type.BookSizeType;

public final class BookBuilder {
	
	private Book book;
	
	public BookBuilder() {
		book = new Book();
	}
	
	public BookBuilder withTitle(String title) {
		book.setTitle(title);
		return this;
	}
	
	public BookBuilder withAuthor(String author) {
		book.setAuthor(author);
		return this;
	}
	
	public BookBuilder withBookSizeType(BookSizeType sizeType) {
		book.setSizeType(sizeType);
		return this;
	}
	
	public Book build() {
		return book;
	}
	
}
