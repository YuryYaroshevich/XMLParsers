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

public class ProductsXMLStAXParser implements ProductsXMLParser {
	private static final XMLInputFactory xmlInputFactory = XMLInputFactory
			.newInstance();

	private static final ProductsStAXHandler handler = new ProductsStAXHandler();

	public List<Category> parse(String xml) throws ParserLogicalException,
			ParserTechnicalException {
		try {
			InputStream input = new FileInputStream(xml);
			XMLStreamReader reader = xmlInputFactory
					.createXMLStreamReader(input);
			return handler.getCategories(reader);
		} catch (XMLStreamException e) {
			e.printStackTrace();
			throw new ParserTechnicalException(e);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new ParserTechnicalException(e);
		}
	}

}
