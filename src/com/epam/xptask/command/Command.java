package com.epam.xptask.command;

import javax.servlet.http.HttpServletRequest;

import com.epam.xptask.exception.XPLogicalException;
import com.epam.xptask.exception.XPTechnicalException;

public interface Command {
	String execute(HttpServletRequest request) throws XPTechnicalException,
			XPLogicalException;
}
