package com.epam.xptask.parser.sax;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.epam.xptask.parser.ProductsXMLParser;
import com.epam.xptask.parser.exception.ParserLogicalException;
import com.epam.xptask.parser.exception.ParserTechnicalException;
import com.epam.xptask.product.Category;

public class ProductsXMLSAXParser implements ProductsXMLParser {
	private final XMLReader xmlReader;

	public ProductsXMLSAXParser() throws ParserTechnicalException {
		try {
			xmlReader = XMLReaderFactory.createXMLReader();
		} catch (SAXException e) {
			e.printStackTrace();
			throw new ParserTechnicalException(e);
		}
	}

	public List<Category> parse(String xmlLocation)
			throws ParserLogicalException, ParserTechnicalException {
		try {
			ProductsSAXHandler handler = new ProductsSAXHandler();
			xmlReader.setContentHandler(handler);
			xmlReader.parse(xmlLocation);
			return handler.getCategories();
		} catch (IOException e) {
			e.printStackTrace();
			throw new ParserTechnicalException(e);
		} catch (SAXException e) {
			e.printStackTrace();
			throw new ParserLogicalException(e);
		}
	}
}
