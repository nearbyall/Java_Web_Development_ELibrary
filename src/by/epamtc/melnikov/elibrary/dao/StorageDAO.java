package by.epamtc.melnikov.elibrary.dao;

import java.util.List;

import by.epamtc.melnikov.elibrary.bean.Book;
import by.epamtc.melnikov.elibrary.dao.exception.DAOException;

public interface StorageDAO {
	
	boolean isContains(Book book) throws DAOException;
	
	List<Book> readBooks() throws DAOException;
	
	void writeBooks(List<Book> books) throws DAOException;
	
}
