package com.epam.xptask.exception;

public abstract class XPLogicalException extends XPException {
	private static final long serialVersionUID = 1L;

	public XPLogicalException(Exception e) {
		super(e);
	}
}
