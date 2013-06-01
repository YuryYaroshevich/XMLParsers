package com.epam.xptask.parser.dom;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.epam.xptask.parser.ProductsXMLParser;
import com.epam.xptask.parser.exception.ParserLogicalException;
import com.epam.xptask.parser.exception.ParserTechnicalException;
import com.epam.xptask.product.Category;

public final class ProductsXMLDOMParser implements ProductsXMLParser {
	private static final ProductsXMLParser parser = new ProductsXMLDOMParser();
	
	private static final DocumentBuilderFactory docBuilderfactory = DocumentBuilderFactory
			.newInstance();

	private ProductsXMLDOMParser() {
	}

	public static ProductsXMLParser getInstance() {
		return parser;
	}

	public List<Category> parse(String xml) throws ParserLogicalException,
			ParserTechnicalException {
		try {
			DocumentBuilder docBuilder = docBuilderfactory.newDocumentBuilder();
			Document document = docBuilder.parse(xml);
			Element root = document.getDocumentElement();
			List<Category> categories = ProductsDOMHandler.getCategories(root);
			return categories;
		} catch (SAXException e) {
			e.printStackTrace();
			throw new ParserLogicalException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ParserTechnicalException(e);
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			throw new ParserTechnicalException(e);
		}
	}
}
