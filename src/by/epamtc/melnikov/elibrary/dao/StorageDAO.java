package by.epamtc.melnikov.elibrary.dao;

import java.util.List;

import by.epamtc.melnikov.elibrary.bean.Book;
import by.epamtc.melnikov.elibrary.dao.exception.DAOException;

public interface StorageDAO {
	
	List<Book> readBooks() throws DAOException;
	
	void writeBooks(List<Book> books) throws DAOException;
	
	void addBook(Book newBook) throws DAOException;
	
	void deleteBook(Book uselessBook) throws DAOException;
	
}
