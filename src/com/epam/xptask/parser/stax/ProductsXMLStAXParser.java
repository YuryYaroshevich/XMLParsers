package com.epam.xptask.parser.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.epam.xptask.parser.ProductsXMLParser;
import com.epam.xptask.parser.exception.ParserLogicalException;
import com.epam.xptask.parser.exception.ParserTechnicalException;
import com.epam.xptask.product.Category;

public final class ProductsXMLStAXParser implements ProductsXMLParser {
	private static final ProductsXMLParser parser = new ProductsXMLStAXParser();

	private static final XMLInputFactory xmlInputFactory = XMLInputFactory
			.newInstance();

	private ProductsXMLStAXParser() {
	}
	
	public static ProductsXMLParser getInstance() {
		return parser;
	}
	
	public List<Category> parse(String xml)
			throws ParserLogicalException, ParserTechnicalException {
		try {
			InputStream input = new FileInputStream(xml);
			XMLStreamReader reader = xmlInputFactory
					.createXMLStreamReader(input);
			return ProductsStAXHandler.getCategories(reader);
		} catch (XMLStreamException e) {
			e.printStackTrace();
			throw new ParserTechnicalException(e);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new ParserTechnicalException(e);
		}
	}

}
