package com.epam.xptask.util.pagegetter;

import java.util.ResourceBundle;

public class PageGetter {
	private static final String PAGES_PROPERTY = "com.epam.xptask.pagegetter.pages";
	
	private static final ResourceBundle bundle = ResourceBundle
			.getBundle(PAGES_PROPERTY);

	public static final String MAIN_PAGE = "main";
	public static final String PRODUCTS_PAGE = "products";
	
	private PageGetter() {
	}
	
	public static String getPage(String key) {
		return bundle.getString(key);
	}
}
