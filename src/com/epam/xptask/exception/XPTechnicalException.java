package com.epam.xptask.exception;

public abstract class XPTechnicalException extends XPException {
	private static final long serialVersionUID = 8364410416562733013L;

	public XPTechnicalException(Exception e) {
		super(e);
	}
}
