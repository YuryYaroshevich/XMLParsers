package com.epam.xptask.parser;

import com.epam.xptask.parser.dom.ProductsXMLDOMParser;
import com.epam.xptask.parser.exception.ParserTechnicalException;
import com.epam.xptask.parser.sax.ProductsXMLSAXParser;
import com.epam.xptask.parser.stax.ProductsXMLStAXParser;

public final class ProductsXMLParserFactory {
	private static final String SAX_TYPE = "SAX";
	private static final String DOM_TYPE = "DOM";

	private ProductsXMLParserFactory() {
	}

	public static ProductsXMLParser getParser(String parserType)
			throws ParserTechnicalException {
		if (SAX_TYPE.equals(parserType)) {
			return ProductsXMLSAXParser.getInstance();
		} else if (DOM_TYPE.equals(parserType)) {
			return ProductsXMLDOMParser.getInstance();
		} else {
			return ProductsXMLStAXParser.getInstance();
		}		
	}
}
