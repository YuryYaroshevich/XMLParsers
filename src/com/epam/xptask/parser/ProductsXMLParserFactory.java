package com.epam.xptask.parser;

import com.epam.xptask.parser.dom.ProductsXMLDOMParser;
import com.epam.xptask.parser.exception.ParserTechnicalException;
import com.epam.xptask.parser.sax.ProductsXMLSAXParser;

public class ProductsXMLParserFactory {
	private static final String SAX_TYPE = "SAX";
	private static final String DOM_TYPE = "DOM";

	private ProductsXMLParserFactory() {
	}

	public static ProductsXMLParser getParser(String parserType)
			throws ParserTechnicalException {
		if (SAX_TYPE.equals(parserType)) {
			return new ProductsXMLSAXParser();
		} else if (DOM_TYPE.equals(parserType)) {
			return new ProductsXMLDOMParser();
		} else {
			return null;
		}		
	}
}
