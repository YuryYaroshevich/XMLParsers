package com.epam.xptask.command.creator;

import javax.servlet.http.HttpServletRequest;

import com.epam.xptask.command.Command;
import com.epam.xptask.command.NoCommand;
import com.epam.xptask.command.ParseCommand;

public class CommandCreator {
	private static final String COMMAND_PARAM = "command";

	private CommandCreator() {
	}

	public static Command createCommand(HttpServletRequest request) {
		CommandEnum commandEnum = getCommandEnum((String) request
				.getParameter(COMMAND_PARAM));
		switch (commandEnum) {
		case PARSE:
			return new ParseCommand();	
		default:
			return new NoCommand();
		}
	}

	private static CommandEnum getCommandEnum(String command) {
		if (command == null) {
			return CommandEnum.NO_COMMAND;
		} else if (isWrongCommandName(command)) {
			return CommandEnum.NO_COMMAND;
		} else {
			return CommandEnum.valueOf(command);
		}
	}

	private static boolean isWrongCommandName(String command) {
		CommandEnum[] realCommandNames = CommandEnum.values();
		for (CommandEnum realCommandName : realCommandNames) {
			if (realCommandName.toString().equals(command)) {
				return false;
			}
		}
		return true;
	}
}
