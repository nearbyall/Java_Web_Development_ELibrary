package by.epamtc.melnikov.elibrary.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.epamtc.melnikov.elibrary.bean.Book;
import by.epamtc.melnikov.elibrary.bean.builder.BookBuilder;
import by.epamtc.melnikov.elibrary.bean.type.BookSizeType;
import by.epamtc.melnikov.elibrary.constant.StringConstants;
import by.epamtc.melnikov.elibrary.dao.StorageDAO;
import by.epamtc.melnikov.elibrary.dao.exception.DAOException;

public class TXTStorageDAOImpl implements StorageDAO {

	private static final File STORAGE_RESOURCES = new File("resources/storage.txt");

	@Override
	public List<Book> readBooks() throws DAOException {

		String line;
		List<Book> books = new ArrayList<Book>();
		try (BufferedReader br = new BufferedReader(new FileReader(STORAGE_RESOURCES))) {
			while ((line = br.readLine()) != null) {

				String[] data = line.split(StringConstants.SPLIT_BY);
				Book book = new BookBuilder()
						.withTitle(data[0])
						.withAuthor(data[1])
						.withBookSizeType(BookSizeType.valueOf(data[2]))
						.build();
				books.add(book);
				System.out.println(book);
			}
		} catch (IOException e) {
			throw new DAOException(e.getMessage(), e);
		}
		return books;
		
	}

	@Override
	public void writeBooks(List<Book> books) throws DAOException {
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(STORAGE_RESOURCES))) {
			for (Book book : books) {
				StringBuilder sb = new StringBuilder();
				sb.append(book.getTitle());
				sb.append(",");
				sb.append(book.getAuthor());
				sb.append(",");
				sb.append(book.getSizeType());
				bw.write(sb.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			throw new DAOException(e.getMessage(), e);
		}
		
	}

}
