package by.epamtc.melnikov.elibrary.bean;

import java.io.Serializable;

import by.epamtc.melnikov.elibrary.bean.type.BookSizeType;

public class Book implements Serializable {
	
	private static final long serialVersionUID = -27114457911218714L;
	
	private String title;
	private String author;
	private BookSizeType sizeType;
	
	public Book() {
		
	}
	
	public Book(String title, String author, BookSizeType sizeType) {
		this.title = title;
		this.author = author;
		this.sizeType = sizeType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public BookSizeType getSizeType() {
		return sizeType;
	}

	public void setSizeType(BookSizeType sizeType) {
		this.sizeType = sizeType;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [title=" + title + ", author=" + author + ", sizeType=" + sizeType + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((sizeType == null) ? 0 : sizeType.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (sizeType != other.sizeType)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
		
	}
	
}