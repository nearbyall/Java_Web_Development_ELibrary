package by.epamtc.melnikov.elibrary.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.epamtc.melnikov.elibrary.controller.command.impl.AddBook;
import by.epamtc.melnikov.elibrary.controller.command.impl.Authorization;
import by.epamtc.melnikov.elibrary.controller.command.impl.CorrectNote;
import by.epamtc.melnikov.elibrary.controller.command.impl.DeleteBook;
import by.epamtc.melnikov.elibrary.controller.command.impl.FindBooksBySizeType;
import by.epamtc.melnikov.elibrary.controller.command.impl.FindBooksByTitle;
import by.epamtc.melnikov.elibrary.controller.command.impl.FindBooksByTitleAndAuthor;
import by.epamtc.melnikov.elibrary.controller.command.impl.Registration;
import by.epamtc.melnikov.elibrary.controller.command.impl.ShowBooks;
import by.epamtc.melnikov.elibrary.controller.command.impl.WrongRequest;

public final class CommandProvider {

	private final Map<CommandName, Command> repository = new HashMap<>();
	
	public CommandProvider() {
		repository.put(CommandName.AUTHORIZATION, new Authorization());
		repository.put(CommandName.REGISTRATION, new Registration());
		repository.put(CommandName.ADD_BOOK, new AddBook());
		repository.put(CommandName.DELETE_BOOK, new DeleteBook());
		repository.put(CommandName.CORRECT_NOTE, new CorrectNote());
		repository.put(CommandName.SHOW_BOOKS, new ShowBooks());
		repository.put(CommandName.FIND_BOOKS_BY_SIZE_TYPE, new FindBooksBySizeType());
		repository.put(CommandName.FIND_BOOKS_BY_TITLE, new FindBooksByTitle());
		repository.put(CommandName.FIND_BOOKS_BY_TITLE_AND_AUTHOR, new FindBooksByTitleAndAuthor());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
	}
	
	public Command getCommand(String name) {
		
		CommandName commandName = null;
		Command command = null;
		
		try {
			commandName = CommandName.valueOf(name);
			command = repository.get(commandName);
		} catch (NullPointerException | IllegalArgumentException e) {
			//write log
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		
		return command;
		
	}
	
}
