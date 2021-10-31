package by.epamtc.melnikov.elibrary.main;

import java.util.List;

import by.epamtc.melnikov.elibrary.bean.Book;
import by.epamtc.melnikov.elibrary.dao.DAOProvider;
import by.epamtc.melnikov.elibrary.dao.StorageDAO;
import by.epamtc.melnikov.elibrary.dao.exception.DAOException;

public class Main {

	public static void main(String[] args) {
		
		DAOProvider provider = DAOProvider.getInstantce();
		StorageDAO storageDAO = provider.getStorageDAO();
		try {
			List<Book> books = storageDAO.readBooks();
			storageDAO.writeBooks(books);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
