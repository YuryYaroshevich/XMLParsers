package com.epam.xptask.command;

import javax.servlet.http.HttpServletRequest;

import static com.epam.xptask.util.pagegetter.PageGetter.*;

public class NoCommand implements Command {
	public String execute(HttpServletRequest request) {
		return getPage(MAIN_PAGE);
	}
}
