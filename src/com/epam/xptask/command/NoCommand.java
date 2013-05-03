package com.epam.xptask.command;

import javax.servlet.http.HttpServletRequest;

import static com.epam.xptask.pagegetter.PageGetter.*;

public class NoCommand implements ICommand {
	public String execute(HttpServletRequest request) {
		return getPage(MAIN_PAGE);
	}
}
