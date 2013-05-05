package com.epam.xptask.command;

import static com.epam.xptask.util.pagegetter.PageGetter.PRODUCTS_PAGE;
import static com.epam.xptask.util.pagegetter.PageGetter.getPage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.epam.xptask.exception.XPException;
import com.epam.xptask.exception.XPLogicalException;
import com.epam.xptask.exception.XPTechnicalException;
import com.epam.xptask.parser.ProductsXMLParser;
import com.epam.xptask.parser.sax.ProductsXMLSAXParser;
import com.epam.xptask.product.Category;

public class ParseCommand implements ICommand {
	private static final String PARSER_PARAM = "parser";

	private static final String CATEGORIES_ATTR = "categories";

	private static final String PRODUCTS_XML = "D:/indigoWorkspace/XMLParsers/src/com/epam/xml/ExampleProductsXSD.xml";

	public String execute(HttpServletRequest request)
			throws XPTechnicalException, XPLogicalException {
		ProductsXMLParser parser = new ProductsXMLSAXParser();
		List<Category> categories = parser.parse(PRODUCTS_XML);
		request.setAttribute(CATEGORIES_ATTR, categories);
		return getPage(PRODUCTS_PAGE);
	}
}

/*
 * String parser = request.getParameter(PARSER_PARAM); Good g1 = new
 * Good("producer1", "model1", "12/12/1121","green", 232); Good g2 = new
 * Good("producer2", "model2", "12/12/1121","green", 232); Good g3 = new
 * Good("producer3", "model3", "12/12/1121","green", 232); Good g4 = new
 * Good("producer4", "model4", "12/12/1121","green", 232); Good g5 = new
 * Good("producer5", "model5", "12/12/1121","green", 232); Good g6 = new
 * Good("producer6", "model6", "12/12/1121","green"); Subcategory s1 = new
 * Subcategory("subcat1"); s1.addGood(g1); s1.addGood(g2); Subcategory s2 = new
 * Subcategory("subcat2"); s2.addGood(g3); s2.addGood(g4); s2.addGood(g5);
 * Subcategory s3 = new Subcategory("subcat3"); s3.addGood(g6); Category c1 =
 * new Category("categ1"); c1.addSubcategory(s1); c1.addSubcategory(s2);
 * Category c2 = new Category("categ2"); c2.addSubcategory(s3); List<Category>
 * cats = new ArrayList<Category>(); cats.add(c1); cats.add(c2);
 * request.setAttribute("categories", cats);
 */
