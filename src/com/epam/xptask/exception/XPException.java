package com.epam.xptask.exception;

abstract class XPException extends Exception {
	private static final long serialVersionUID = -9176692414785303498L;
	
	protected Exception hidden;

	public XPException(Exception e) {
		super(e);
		hidden = e;
	}
	
	public String toString() {
		return super.toString();
	}
}
