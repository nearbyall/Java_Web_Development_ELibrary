package by.epamtc.melnikov.elibrary.controller;

import by.epamtc.melnikov.elibrary.constant.SplitConstants;
import by.epamtc.melnikov.elibrary.controller.command.Command;
import by.epamtc.melnikov.elibrary.controller.command.CommandProvider;

public class Controller {
	
	private final CommandProvider provider = new CommandProvider();
	
	public String executeTask(String request) {
		
		String commandName;
		Command executionCommand;
		
		commandName = request.substring(0, request.indexOf(SplitConstants.SPLIT_BY));
		executionCommand = provider.getCommand(commandName);
		
		String response;
		response = executionCommand.execute(request);
		
		return response;
		
	}
	
}
