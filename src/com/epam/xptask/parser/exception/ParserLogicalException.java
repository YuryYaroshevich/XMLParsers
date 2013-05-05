package com.epam.xptask.parser.exception;

import com.epam.xptask.exception.XPLogicalException;

public class ParserLogicalException extends XPLogicalException {
	private static final long serialVersionUID = -6861216893130830174L;

	public ParserLogicalException(Exception e) {
		super(e);
	}
}
