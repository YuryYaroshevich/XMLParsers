package com.epam.xptask.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.xptask.parser.ProductsXMLParser;
import com.epam.xptask.parser.ProductsXMLParserFactory;
import com.epam.xptask.parser.exception.ParserLogicalException;
import com.epam.xptask.parser.exception.ParserTechnicalException;
import com.epam.xptask.product.Category;
import static com.epam.resource.FileURLReader.*;

public class ParserController extends HttpServlet {
	private static final long serialVersionUID = 7688907932488576018L;

	private static final String PARSER_PARAM = "parser";

	private static final String CATEGORIES_ATTR = "categories";

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// find appropriate XML parser
			String parserType = request.getParameter(PARSER_PARAM);
			ProductsXMLParser parser = ProductsXMLParserFactory
					.getParser(parserType);
			// fill list of categories
			List<Category> categories = parser.parse(getFileURL(PRODUCTS_XML));
			// set request attribute
			request.setAttribute(CATEGORIES_ATTR, categories);
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(getFileURL(PRODUCTS_PAGE));
			dispatcher.forward(request, response);
		} catch (ParserTechnicalException e) {
			e.printStackTrace();
		} catch (ParserLogicalException e) {
			e.printStackTrace();
		}
	}
}
