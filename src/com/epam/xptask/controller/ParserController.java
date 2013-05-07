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
import com.epam.xptask.util.pagegetter.PageGetter;

public class ParserController extends HttpServlet {
	private static final long serialVersionUID = 7688907932488576018L;
	
	private static final String PARSER_PARAM = "parser";

	private static final String CATEGORIES_ATTR = "categories";

	private static final String PRODUCTS_XML =
			"c:/workspace/XMLParsers/src/com/epam/xml/ExampleProductsXSD.xml";

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
			String parserType = request.getParameter(PARSER_PARAM);
			ProductsXMLParser parser = ProductsXMLParserFactory
					.getParser(parserType);
			List<Category> categories = parser.parse(PRODUCTS_XML);
			request.setAttribute(CATEGORIES_ATTR, categories);
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher(
							PageGetter.getPage(PageGetter.PRODUCTS_PAGE));
			dispatcher.forward(request, response);
		} catch (ParserTechnicalException e) {
			e.printStackTrace();
		} catch (ParserLogicalException e) {
			e.printStackTrace();
		}
		
		/*
		 * Command command = CommandCreator.createCommand(request); String page;
		 * try { page = command.execute(request); } catch (XPTechnicalException
		 * e) { e.printStackTrace(); throw new ServletException(e); } catch
		 * (XPLogicalException e) { e.printStackTrace(); throw new
		 * ServletException(e); } RequestDispatcher dispatcher =
		 * getServletContext() .getRequestDispatcher(page);
		 * dispatcher.forward(request, response);
		 */
	}
}
