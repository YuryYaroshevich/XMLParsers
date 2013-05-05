package com.epam.xptask.parser.exception;

import com.epam.xptask.exception.XPTechnicalException;

public class ParserTechnicalException extends XPTechnicalException {
	private static final long serialVersionUID = 5073133169742245193L;

	public ParserTechnicalException(Exception e) {
		super(e);
	}
}
