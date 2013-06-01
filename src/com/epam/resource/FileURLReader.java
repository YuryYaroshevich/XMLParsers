package com.epam.resource;

import java.util.ResourceBundle;

public final class FileURLReader {
	private static final ResourceBundle bundle = ResourceBundle
			.getBundle("com.epam.resource.fileurl");

	public static final String PRODUCTS_XML = "products.xml";
	public static final String PRODUCTS_PAGE = "products.page";
	
	private FileURLReader() {
	}
	
	public static String getFileURL(String key) {
		return bundle.getString(key);
	}
}
