package com.epam.xptask.command;

import static com.epam.xptask.util.pagegetter.PageGetter.PRODUCTS_PAGE;
import static com.epam.xptask.util.pagegetter.PageGetter.getPage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.epam.xptask.exception.XPLogicalException;
import com.epam.xptask.exception.XPTechnicalException;
import com.epam.xptask.parser.ProductsXMLParser;
import com.epam.xptask.parser.ProductsXMLParserFactory;
import com.epam.xptask.product.Category;

public class ParseCommand implements Command {
	private static final String PARSER_PARAM = "parser";

	private static final String CATEGORIES_ATTR = "categories";

	private static final String PRODUCTS_XML =
			"c:/workspace/XMLParsers/src/com/epam/xml/ExampleProductsXSD.xml";
	//"D:/indigoWorkspace/XMLParsers/src/com/epam/xml/ExampleProductsXSD.xml";

	public String execute(HttpServletRequest request)
			throws XPTechnicalException, XPLogicalException {
		String parserType = request.getParameter(PARSER_PARAM);
		ProductsXMLParser parser = ProductsXMLParserFactory
				.getParser(parserType);
		List<Category> categories = parser.parse(PRODUCTS_XML);
		request.setAttribute(CATEGORIES_ATTR, categories);
		return getPage(PRODUCTS_PAGE);
	}
}

